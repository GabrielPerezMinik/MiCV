package gui.Entrañas.Dialog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cv.Conocimiento;
import cv.Nivel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ConocimientoDialog extends Dialog<Conocimiento> implements Initializable{

	
	
	private StringProperty denominacion = new SimpleStringProperty();
	private ObjectProperty<Nivel> nivelObject = new SimpleObjectProperty<>();

	   @FXML
	    private TextField denominacionTextField;

	    @FXML
	    private ComboBox<Nivel> nivelComboBox;

	    @FXML
	    private Button reiniciarButton;

	    @FXML
	    private VBox view;

    
    public ConocimientoDialog() {
    	super();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/dialog/ConocimientoDialog.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ButtonType crearButtonType = new ButtonType("Crear", ButtonData.OK_DONE);

		setTitle("Nuevo conocimiento");
		
		getDialogPane().setContent(view);
		getDialogPane().getButtonTypes().addAll(crearButtonType, ButtonType.CANCEL);
		
		setResultConverter(buttonType -> onCovertResult(buttonType));
		
		Button crearButton = (Button) getDialogPane().lookupButton(crearButtonType);
		crearButton.disableProperty().bind(denominacion.isEmpty().or(nivelObject.isNull()));

		denominacion.bind(denominacionTextField.textProperty());
		nivelObject.bind(nivelComboBox.getSelectionModel().selectedItemProperty());
		
		nivelComboBox.getItems().setAll(Nivel.values());
		
		denominacionTextField.requestFocus();
		
	}
	
	private Conocimiento onCovertResult(ButtonType buttonType) {
		if(buttonType.getButtonData() == ButtonData.OK_DONE) {
			Conocimiento conocimiento = new Conocimiento();
			conocimiento.setDenominacion(denominacion.get());
			conocimiento.setNivelObject(nivelObject.get());
			return conocimiento;
		}
		return null;
	 }

	
    @FXML
    void onReiniciar(ActionEvent event) {
    	nivelComboBox.getSelectionModel().select(null);
    }
}
