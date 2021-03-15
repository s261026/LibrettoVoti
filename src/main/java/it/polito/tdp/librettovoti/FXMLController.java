package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

public class FXMLController {

	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    

    @FXML
    private DatePicker dateEsame;
    
    @FXML
    private TextArea txtResult;

    @FXML
    private TextField idEsame;

    @FXML
    private TextField idVoto;

   // @FXML
  //  private TextField idData;

    @FXML
    private Button btnInserisci;

    @FXML
    void doInserisci(ActionEvent event) {
    	
    	String nomeEsame = idEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE: nome esame vuoto");
    		return;
    	}
    	String votoEsame = idVoto.getText();
    	int votoInt = 0;
    	try {
    		votoInt = Integer.parseInt(votoEsame);
    	} catch(NumberFormatException e) {
    		txtResult.setText("ERRORE: il voto deve essere numerico");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtResult.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	/*String dataEsame = idData.getText();
    	
    	LocalDate data ;
    	try {
    		data= LocalDate.parse(dataEsame);
    	} catch(DateTimeParseException e) {
    		txtResult.setText("ERRORE: data errata");
    		return;
    	}*/
    	
    	LocalDate data = dateEsame.getValue();
    	
    	if(data==null) {
    		txtResult.setText("ERRORE: data errata o mancante");
    		return;
    	}
    	
    	Voto voto = new Voto (nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	txtResult.setText(model.toString());
    	idEsame.clear();
    	idVoto.clear();
    	//idData.clear();
    	dateEsame.setValue(null);

    }
    
    public void setModel (Libretto model) {
    	this.model= model;
    	
    }

    @FXML
    void initialize() {
        assert idEsame != null : "fx:id=\"idEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert idVoto != null : "fx:id=\"idVoto\" was not injected: check your FXML file 'Scene.fxml'.";
       // assert idData != null : "fx:id=\"idData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert dateEsame != null : "fx:id=\"dateEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }
}

