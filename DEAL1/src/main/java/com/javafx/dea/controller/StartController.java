package com.javafx.dea.controller;
import java.net.URL;
import java.util.ResourceBundle;

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
	
	public double getLengthNumbers() throws NumberFormatException{
		return Double.parseDouble(lengthNumbersTxt.getText());
	}
	
	public double getLowerInterval() throws NumberFormatException {
		return Double.parseDouble(lowerIntervalTxt.getText());
	}
	
	public double getUpperInterval() throws NumberFormatException {
		return Double.parseDouble(upperIntervalTxt.getText());
	}
	
	public String getArbitrarily() {
		return arbitrarilyTxt.getText();
	}
	
	public String getFloatingPoint() {
		return floatingPointtxt.getText();
	}
	
	public String sortByMerge() {
		world = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
		String string = "";
		double[] numbers =world.transformStringToDouble(arbitrarilyTxt.getText());
		
		world.merge(numbers);
		
		for (int i =0; i < numbers.length; i++) {
			string+=numbers[i]+" // ";
		}
		return string;
	}
	
	public String sortByHeap() {
		world = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
		String string = "";
		double[] numbers =world.transformStringToDouble(arbitrarilyTxt.getText());
		world.heap(numbers);

		for (int i = 0; i < numbers.length; i++) {
			string+=numbers[i]+" // ";
		}
		return string;
	}
	
	public String sortByRadix() {
		world = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
		String string = "";
		double[] numbers =world.transformStringToDouble(arbitrarilyTxt.getText());
		
		world.radix(numbers);

		for (int i = 0; i < numbers.length; i++) {
			string+=numbers[i]+" - ";
		}
		return string;
	}

	@FXML
    void showResultMerge2(ActionEvent event) {
		try {
			getLengthNumbers();
			getLowerInterval();
			getUpperInterval();
		}catch(NumberFormatException e) {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Error");
			message.setContentText("Please enter a numeric data");
			message.setHeaderText("Error in the entered number");
			message.show();
		}
    }
	
	@FXML
    void showResultRadix2(ActionEvent event) {
		try {
			getLengthNumbers();
			getLowerInterval();
			getUpperInterval();
		}catch(NumberFormatException e) {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Error");
			message.setContentText("Please enter a numeric data");
			message.setHeaderText("Error in the entered number");
			message.show();
		}
    }
	
	@FXML
    void showResultHeap2(ActionEvent event) {
		try {
			getLengthNumbers();
			getLowerInterval();
			getUpperInterval();
		}catch(NumberFormatException e) {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Error");
			message.setContentText("Please enter a numeric data");
			message.setHeaderText("Error in the entered number");
			message.show();
		}
    }
	
	@FXML
    void showResultMerge1(ActionEvent event) {
		Alert message = new Alert(Alert.AlertType.INFORMATION);
		message.setTitle("Sorting by Merge-sort");
		double start = System.currentTimeMillis();
		message.setContentText(sortByMerge());
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
		message.setContentText(sortByRadix());
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
		message.setContentText(sortByHeap());
		double end = System.currentTimeMillis();
		double value = end-start;
		System.out.println(value);
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
