package com.javafx.dea.controller;

import com.javafx.dea.main.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class StartController {
	
	private Main principal;
	
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
    private TextField loweIntervalTxt;

    @FXML
    private RadioButton repeatedRadioButt;

    @FXML
    private RadioButton nonRepeatedRadioButt;

    @FXML
    private TextField upperIntervalTxt;

    @FXML
    private RadioButton orderedNormalyRadioButt;

    @FXML
    private RadioButton inverselyOrderedRadioButt;

    @FXML
    private RadioButton randomNumbersRadioButt;

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
		this.loweIntervalTxt = new TextField();
		this.repeatedRadioButt = new RadioButton();
		this.nonRepeatedRadioButt = new RadioButton();
		this.upperIntervalTxt = new TextField();
		this.orderedNormalyRadioButt = new RadioButton();
		inverselyOrderedRadioButt = new RadioButton();
		this.randomNumbersRadioButt = new RadioButton();
		this.heapButt2 = new Button();
		this.mergeButt2 = new Button();
		this.radixButt2 = new Button();
	}

	public Button getMergeButt1() {
		return mergeButt1;
	}

	public TextField getArbitrarilyTxt() {
		return arbitrarilyTxt;
	}

	public TextField getFloatingPointtxt() {
		return floatingPointtxt;
	}

	public Button getRadixButt1() {
		return radixButt1;
	}

	public Button getHeapButt1() {
		return heapButt1;
	}

	public RadioButton getArbitrarilyRadioButt() {
		return arbitrarilyRadioButt;
	}

	public RadioButton getFloatingPointRadioButt() {
		return floatingPointRadioButt;
	}

	public TextField getLengthNumbersTxt() {
		return lengthNumbersTxt;
	}

	public TextField getLoweIntervalTxt() {
		return loweIntervalTxt;
	}

	public RadioButton getRepeatedRadioButt() {
		return repeatedRadioButt;
	}

	public RadioButton getNonRepeatedRadioButt() {
		return nonRepeatedRadioButt;
	}

	public TextField getUpperIntervalTxt() {
		return upperIntervalTxt;
	}

	public RadioButton getOrderedNormalyRadioButt() {
		return orderedNormalyRadioButt;
	}

	public RadioButton getInverselyOrderedRadioButt() {
		return inverselyOrderedRadioButt;
	}

	public RadioButton getRandomNumbersRadioButt() {
		return randomNumbersRadioButt;
	}

	
	public Button getHeapButt2() {
		return heapButt2;
	}

	public Button getMergeButt2() {
		return mergeButt2;
	}

	public Button getRadixButt2() {
		return radixButt2;
	}
	
	@FXML
    void showResultMerge1(ActionEvent event) {
		principal.showMessageResultMerge1();
    }

	
}
