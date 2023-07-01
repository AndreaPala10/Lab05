package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

import it.polito.tdp.lab05.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController {

	AnagrammiModel model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtCorrect;

    @FXML
    private TextField txtField;

    @FXML
    private TextArea txtWrong;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	
    	this.txtCorrect.clear();   //PULIZIA CAMPI
    	this.txtWrong.clear();
    	
    	String parola=this.txtField.getText();	//PRENDO LA PAROLA INSERITA
    	
    	//CONTROLLI SULLA PAROLA
    	/*
    	 *  if(parola <2) troppo corta
    	 *  if(parola >8) troppo lunga     vedi bene database
    	 */
    	
    	Set<String> anagrammi=this.model.calcolaAnagrammi(parola);
    	
    	for(String anagramma: anagrammi) {
    		this.txtCorrect.appendText(anagramma+"\n");
    	}
    	
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorrect.clear();
    	this.txtWrong.clear();
    	this.txtField.clear();
    }

    @FXML
    void insertWord(ActionEvent event) {

    }

    @FXML
    void writeCorrect(MouseEvent event) {

    }

    @FXML
    void writeWrong(MouseEvent event) {

    }

    public void setModel(AnagrammiModel model) {
    	this.model=model;
    }
    @FXML
    void initialize() {
        assert btnCalculate != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
