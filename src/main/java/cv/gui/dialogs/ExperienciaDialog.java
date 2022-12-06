package cv.gui.dialogs;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import cv.model.Experiencia;
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

public class ExperienciaDialog extends Dialog<Experiencia> implements Initializable{

	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty empleador = new SimpleStringProperty();
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
    private TextField empleadorTextField;
	
    public ExperienciaDialog() {
    	super();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/dialog/ExperienciaDialog.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ButtonType crearButtonType = new ButtonType("Crear", ButtonData.OK_DONE);

		setTitle("Nuevo experiencia");

		getDialogPane().setContent(View);
		getDialogPane().getButtonTypes().addAll(crearButtonType, ButtonType.CANCEL);

		setResultConverter(buttonType -> onCovertResult(buttonType));
		
		Button crearButton = (Button) getDialogPane().lookupButton(crearButtonType);
		crearButton.disableProperty()
				.bind(denominacion.isEmpty().or(empleador.isEmpty().or(desdeObject.isNull().or(hastaObject.isNull()))));

		denominacion.bind(denominacionTextField.textProperty());
		empleador.bind(empleadorTextField.textProperty());
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

	private Experiencia onCovertResult(ButtonType buttonType) {
		
		if (buttonType.getButtonData() == ButtonData.OK_DONE) {
			Experiencia experiencia = new Experiencia();
			experiencia.setDenominacion(denominacion.get());
			experiencia.setEmpleador(empleador.get());
			experiencia.setDesde(desdeDatePicker.getValue());
			experiencia.setHasta(hastaDatePicker.getValue());
			return experiencia;
		}
		return null;
		
	}

}
