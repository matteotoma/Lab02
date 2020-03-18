package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTesto;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtRisultato.clear();
    	txtTesto.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String s = txtTesto.getText();
    	if(s.contains(" ")){
    		String p[] = s.split(" ");
    		String alienWord = p[0];
    		String translation = p[1];
    		dizionario.addWord(alienWord, translation);
    		String result = "";
    		txtRisultato.clear();
    		if(dizionario.getWords().get(alienWord) == null)
    			txtRisultato.appendText("Formato errato\n");
    		else {
    			result = dizionario.getWords().get(alienWord).toString();
    			txtRisultato.appendText("Nuova parola inserita:\n"+result);
    		}
    		txtTesto.clear();
    	}
    	else {
    		String translation = dizionario.translate(s);
    		txtRisultato.clear();
    		txtRisultato.appendText(translation);
    		txtTesto.clear();
    	}
    }

    @FXML
    void initialize() {
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(AlienDictionary dizionario) {
    	this.dizionario = dizionario;
    }
    
}
