package cv.gui.dialogs;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import cv.model.Titulo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TituloDialog extends Dialog<Titulo> implements Initializable{

	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty organizador = new SimpleStringProperty();
	private ObjectProperty<LocalDate> desdeObject = new SimpleObjectProperty<>();
	private ObjectProperty<LocalDate> hastaObject = new SimpleObjectProperty<>();
	
    @FXML
    private VBox View;
	
    @FXML
    private TextField denominacionTextField;

    @FXML
    private DatePicker desdeDatePicker;

    @FXML
    private DatePicker hastaDatePicker;

    @FXML
    private TextField organizadorTextField;
	
    public TituloDialog() {
		super();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/dialog/TituloDialog.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		ButtonType crearButtonType = new ButtonType("Crear", ButtonData.OK_DONE);

		setTitle("Nuevo título");
		
		getDialogPane().setContent(View);
		getDialogPane().getButtonTypes().addAll(crearButtonType, ButtonType.CANCEL);
		
		setResultConverter(buttonType -> onCovertResult(buttonType));
		
		Button crearButton = (Button) getDialogPane().lookupButton(crearButtonType);
		crearButton.disableProperty().bind(denominacion.isEmpty().or(organizador.isEmpty().or(desdeObject.isNull().or(hastaObject.isNull()))));
		
		denominacion.bind(denominacionTextField.textProperty());
		organizador.bind(organizadorTextField.textProperty());
		desdeObject.bind(desdeDatePicker.valueProperty());
		hastaObject.bind(hastaDatePicker.valueProperty());
		
		denominacionTextField.requestFocus();
		
		hastaDatePicker.setDayCellFactory(d -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				if (desdeDatePicker.getValue() != null) {
					setDisable(item.isBefore(desdeDatePicker.getValue()));
				}
			}
		});
		
		desdeDatePicker.setDayCellFactory(d -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				if (hastaDatePicker.getValue() != null) {
					setDisable(item.isAfter(hastaDatePicker.getValue()));
				}
			}
		});
		
	}
	
	

	private Titulo onCovertResult(ButtonType buttonType) {
		if(buttonType.getButtonData() == ButtonData.OK_DONE) {
			Titulo titulo = new Titulo();
			titulo.setDenominacion(denominacion.get());
			titulo.setOrganizador(organizador.get());
			titulo.setDesde(desdeDatePicker.getValue());
			titulo.setHasta(hastaDatePicker.getValue());
			return titulo;
		}
		return null;
	}



	public VBox getView() {
		return View;
	}

	
	
}
