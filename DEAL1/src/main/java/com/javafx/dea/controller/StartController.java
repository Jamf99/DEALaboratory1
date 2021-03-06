package com.javafx.dea.controller;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;

import com.dea.model.AutomaticSorting;
import com.dea.model.Sorting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class StartController implements Initializable{
	
	private Sorting world;
	private AutomaticSorting world2;
	
    @FXML
    private Button mergeButt1;

    @FXML
    private TextField arbitrarilyTxt;

    @FXML
    private TextField floatingPointtxt;

    @FXML
    private Button radixButt1;

    @FXML
    private Button heapButt1;

    @FXML
    private RadioButton arbitrarilyRadioButt;

    @FXML
    private RadioButton floatingPointRadioButt;

    @FXML
    private TextField lengthNumbersTxt;

    @FXML
    private TextField lowerIntervalTxt;

    @FXML
    private RadioButton repeatedRadioButt;

    @FXML
    private RadioButton nonRepeatedRadioButt;

    @FXML
    private TextField upperIntervalTxt;
    
    @FXML
    private ComboBox<String> preferencesTypeCBox;

    @FXML
    private Button heapButt2;

    @FXML
    private Button mergeButt2;

    @FXML
    private Button radixButt2;

	public StartController() {
		this.mergeButt1 = new Button();
		this.arbitrarilyTxt = new TextField();
		this.floatingPointtxt = new TextField();
		this.radixButt1 = new Button();
		this.heapButt1 = new Button();
		this.arbitrarilyRadioButt = new RadioButton();
		this.floatingPointRadioButt = new RadioButton();
		this.lengthNumbersTxt = new TextField();
		this.lowerIntervalTxt = new TextField();
		this.repeatedRadioButt = new RadioButton();
		this.nonRepeatedRadioButt = new RadioButton();
		this.upperIntervalTxt = new TextField();
		this.preferencesTypeCBox = new ComboBox<String>();
		this.heapButt2 = new Button();
		this.mergeButt2 = new Button();
		this.radixButt2 = new Button();
	}
	
	public int getLengthNumbers() throws NumberFormatException{
		return Integer.parseInt(lengthNumbersTxt.getText());
	}
	
	public BigInteger getLowerIntervalBigInteger() throws NumberFormatException {
		return new BigInteger(lowerIntervalTxt.getText());
	}
	
	public BigInteger getUpperIntervalBigInteger() throws NumberFormatException {
		return new BigInteger(upperIntervalTxt.getText());
	}
	
	public BigDecimal getLowerIntervalBigDecimal() throws NumberFormatException {
		return new BigDecimal(lowerIntervalTxt.getText());
	}
	
	public BigDecimal getUpperIntervalBigDecimal() throws NumberFormatException {
		return new BigDecimal(upperIntervalTxt.getText());
	}
	
	public String getArbitrarily() {
		return arbitrarilyTxt.getText();
	}
	
	public String getFloatingPoint() {
		return floatingPointtxt.getText();
	}
	
	public boolean isRepited() {
		if(repeatedRadioButt.isSelected()) {
			return true;
		}else
			return false;
	}
	
	public String sortByMergeManually() {
		String string = "";
		if(arbitrarilyTxt.getText().isEmpty() == false) {
			world = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
			BigInteger[] numbers =world.transformStringToBigInteger(arbitrarilyTxt.getText());
		
			world.mergeBigInteger(numbers);
		
			for (int i =0; i < numbers.length; i++) {
				string+=numbers[i]+" // ";
			}
		}else {
			world = new Sorting(Sorting.FLOATING_POINT_NUMBERS);
			BigDecimal[] numbers =world.transformStringToBigDecimal(floatingPointtxt.getText());
		
			world.mergeBigDecimal(numbers);
		
			for (int i =0; i < numbers.length; i++) {
				string+=numbers[i]+" // ";
			}
		}
		return string;
	}
	
	public String sortByHeapManually() {
		String string = "";
		if(arbitrarilyTxt.getText().isEmpty() == false) {
			world = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
			BigInteger[] numbers =world.transformStringToBigInteger(arbitrarilyTxt.getText());
		
			world.heapBigInteger(numbers);
		
			for (int i =0; i < numbers.length; i++) {
				string+=numbers[i]+" // ";
			}
		}else {
			world = new Sorting(Sorting.FLOATING_POINT_NUMBERS);
			BigDecimal[] numbers =world.transformStringToBigDecimal(floatingPointtxt.getText());
		
			world.heapBigDecimal(numbers);
		
			for (int i =0; i < numbers.length; i++) {
				string+=numbers[i]+" // ";
			}
		}
		return string;
	}
	
	public String sortByRadixManually() {
		String string = "";
		if(arbitrarilyTxt.getText().isEmpty() == false) {
			world = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
			BigInteger[] numbers =world.transformStringToBigInteger(arbitrarilyTxt.getText());
		
			world.radixBigInteger(numbers);
		
			for (int i =0; i < numbers.length; i++) {
				string+=numbers[i]+" // ";
			}
		}else {
			world = new Sorting(Sorting.FLOATING_POINT_NUMBERS);
			BigDecimal[] numbers =world.transformStringToBigDecimal(floatingPointtxt.getText());
		
			world.radixBigDecimal(numbers);
		
			for (int i =0; i < numbers.length; i++) {
				string+=numbers[i]+" // ";
			}
		}
		return string;
	}
	
	public String sortByMergeAutomatic() {
		String string = "";
		try {
			int lengthNumbers = getLengthNumbers();
			BigInteger lower1 = getLowerIntervalBigInteger();
			BigInteger upper1 = getUpperIntervalBigInteger();
			
			BigDecimal lower2 = getLowerIntervalBigDecimal();
			BigDecimal upper2 = getUpperIntervalBigDecimal();
			
			if(preferencesTypeCBox.getSelectionModel().getSelectedIndex() == AutomaticSorting.ORDERED_NORMALLY) {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					world2.mergeBigInteger(numbers);
					for (int i =0; i < lengthNumbers; i++) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					world2.mergeBigDecimal(numbers);
					for (int i =0; i < lengthNumbers; i++) {
						string+=numbers[i]+" // ";
					}
				}
			}else if(preferencesTypeCBox.getSelectionModel().getSelectedIndex() == AutomaticSorting.INVERSELY_ORDERED) {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					world2.mergeBigIntegerInversely(numbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					world2.mergeBigDecimalInversely(numbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}
			}else {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}
			}
			
		}catch(NumberFormatException e) {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Error");
			message.setContentText("Please enter a numeric data");
			message.setHeaderText("Error in the entered number");
			message.show();
		}
			
		return string;
	}
	
	public String sortByRadixAutomatic() {
		String string = "";
		try {
			int lengthNumbers = getLengthNumbers();
			BigInteger lower1 = getLowerIntervalBigInteger();
			BigInteger upper1 = getUpperIntervalBigInteger();
			
			BigDecimal lower2 = getLowerIntervalBigDecimal();
			BigDecimal upper2 = getUpperIntervalBigDecimal();
			
			if(preferencesTypeCBox.getSelectionModel().getSelectedIndex() == AutomaticSorting.ORDERED_NORMALLY) {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					world2.radixBigInteger(numbers);
					for (int i =0; i < lengthNumbers; i++) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					world2.radixBigDecimal(numbers);
					for (int i =0; i < lengthNumbers; i++) {
						string+=numbers[i]+" // ";
					}
				}
			}else if(preferencesTypeCBox.getSelectionModel().getSelectedIndex() == AutomaticSorting.INVERSELY_ORDERED) {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					world2.radixBigInteger(numbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					world2.radixBigDecimal(numbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}
			}else {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}
			}
			
		}catch(NumberFormatException e) {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Error");
			message.setContentText("Please enter a numeric data");
			message.setHeaderText("Error in the entered number");
			message.show();
		}
			
		return string;
	}
	
	public String sortByHeapAutomatic() {
		String string = "";
		try {
			int lengthNumbers = getLengthNumbers();
			BigInteger lower1 = getLowerIntervalBigInteger();
			BigInteger upper1 = getUpperIntervalBigInteger();
			
			BigDecimal lower2 = getLowerIntervalBigDecimal();
			BigDecimal upper2 = getUpperIntervalBigDecimal();
			
			if(preferencesTypeCBox.getSelectionModel().getSelectedIndex() == AutomaticSorting.ORDERED_NORMALLY) {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					world2.heapBigInteger(numbers);
					for (int i =0; i < lengthNumbers; i++) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.ORDERED_NORMALLY, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					world2.heapBigDecimal(numbers);
					for (int i =0; i < lengthNumbers; i++) {
						string+=numbers[i]+" // ";
					}
				}
			}else if(preferencesTypeCBox.getSelectionModel().getSelectedIndex() == AutomaticSorting.INVERSELY_ORDERED) {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					world2.heapBigInteger(numbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					world2.heapBigDecimal(numbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}
			}else {
				if(arbitrarilyRadioButt.isSelected()) {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.ARBITRARILY_LONG_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigInteger[] numbers = world2.generatorBigInteger(lower1, upper1, lengthNumbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}else {
					if(repeatedRadioButt.isSelected()) {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, true, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}else {
						world2 = new AutomaticSorting(Sorting.FLOATING_POINT_NUMBERS, false, lower1, upper1, lengthNumbers, AutomaticSorting.INVERSELY_ORDERED, true);
					}
					BigDecimal[] numbers = world2.generatorBigDecimal(lower2, upper2, lengthNumbers);
					for (int i =lengthNumbers-1; i > 0; i--) {
						string+=numbers[i]+" // ";
					}
				}
			}
			
		}catch(NumberFormatException e) {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Error");
			message.setContentText("Please enter a numeric data");
			message.setHeaderText("Error in the entered number");
			message.show();
		}
			
		return string;
	}

	@FXML
    void showResultMerge2(ActionEvent event) {
		Alert message = new Alert(Alert.AlertType.INFORMATION);
		message.setTitle("Sorting by Merge-sort");
		double start = System.currentTimeMillis();
		message.setContentText(sortByMergeAutomatic());
		double end = System.currentTimeMillis();
		double value = end - start;
		message.setHeaderText("The numbers have been sorted by Merge-sort!, and it lasted "+value+" milli seconds");
		message.show();
    }
	
	@FXML
    void showResultRadix2(ActionEvent event) {
		Alert message = new Alert(Alert.AlertType.INFORMATION);
		message.setTitle("Sorting by Radix-sort");
		double start = System.currentTimeMillis();
		message.setContentText(sortByRadixAutomatic());
		double end = System.currentTimeMillis();
		double value = end - start;
		message.setHeaderText("The numbers have been sorted by Radix-sort!, and it lasted "+value+" milli seconds");
		message.show();
    }
	
	@FXML
    void showResultHeap2(ActionEvent event) {
		Alert message = new Alert(Alert.AlertType.INFORMATION);
		message.setTitle("Sorting by Heap-sort");
		double start = System.currentTimeMillis();
		message.setContentText(sortByHeapAutomatic());
		double end = System.currentTimeMillis();
		double value = end - start;
		message.setHeaderText("The numbers have been sorted by Heap-sort!, and it lasted "+value+" milli seconds");
		message.show();
    }
	
	@FXML
    void showResultMerge1(ActionEvent event) {
		Alert message = new Alert(Alert.AlertType.INFORMATION);
		message.setTitle("Sorting by Merge-sort");
		double start = System.currentTimeMillis();
		message.setContentText(sortByMergeManually());
		double end = System.currentTimeMillis();
		double value = end - start;
		message.setHeaderText("The numbers have been sorted by Merge-sort!, and it lasted "+value+" milli seconds");
		message.show();
    }
	
	@FXML
    void showResultRadix1(ActionEvent event) {
		Alert message = new Alert(Alert.AlertType.INFORMATION);
		message.setTitle("Sorting by Radix-sort");
		double start = System.currentTimeMillis();
		message.setContentText(sortByRadixManually());
		double end = System.currentTimeMillis();
		double value = end - start;
		message.setHeaderText("The numbers have been sorted by Radix-sort!, and it lasted "+value+" milli seconds");
		message.show();
    }
	
	@FXML
    void showResultHeap1(ActionEvent event) {
		Alert message = new Alert(Alert.AlertType.INFORMATION);
		message.setTitle("Sorting by Heap-sort");
		double start = System.currentTimeMillis();
		message.setContentText(sortByHeapManually());
		double end = System.currentTimeMillis();
		double value = end-start;
		message.setHeaderText("The numbers have been sorted by Heap-sort!, and it lasted "+value+" milli seconds");
		message.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> states = FXCollections.observableArrayList("Ordered Normally", "Inversely Ordered", "Random Numbers");
		preferencesTypeCBox.setItems(states);
		preferencesTypeCBox.getSelectionModel().select(0);
	}

	
}
