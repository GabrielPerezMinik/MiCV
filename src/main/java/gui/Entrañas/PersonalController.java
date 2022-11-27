package gui.Entrañas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cv.Nacionalidad;
import cv.Personal;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable {

	ListProperty<String> paisesList = new SimpleListProperty<>(FXCollections.observableArrayList());
	ListProperty<Nacionalidad> nacionalidadesList = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ObjectProperty<Personal> personalObjectProperty = new SimpleObjectProperty<>();

	@FXML
	private GridPane personalView;

	@FXML
	private TextField apellidosTextField;

	@FXML
	private TextField codigoPostalTextField;

	@FXML
	private TextArea direccionTextArea;

	@FXML
	private TextField localidadtextField;

	@FXML
	private TextField nombreTextField;

	@FXML
	private TextField dniTextField;

	@FXML
	private DatePicker fechaNacimientoDate;

	@FXML
	private ComboBox<String> paisComboBox;

	@FXML
	private ListView<Personal> nacionalidadesListView;

	public PersonalController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PersonalView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		personalObjectProperty.addListener(this::onPersonalChanged);	

	}

	private void onPersonalChanged(ObservableValue<? extends Personal> o, Personal ov, Personal nv) {

		if (ov != null) {

			ov.identificacionProperty().unbindBidirectional(dniTextField.textProperty());
			ov.nombreProperty().unbindBidirectional(nombreTextField.textProperty());
			ov.apellidosProperty().unbindBidirectional(apellidosTextField.textProperty());
			ov.fechaNacimientoProperty().unbindBidirectional(fechaNacimientoDate.valueProperty());
			ov.direccionProperty().unbindBidirectional(direccionTextArea.textProperty());
			ov.codigoPostalProperty().unbindBidirectional(codigoPostalTextField.textProperty());
			ov.localidadProperty().unbindBidirectional(localidadtextField.textProperty());
			ov.paisProperty().unbind();
			nacionalidadesListView.itemsProperty().unbind();
			

		}
		if (nv != null) {

			nv.identificacionProperty().bindBidirectional(dniTextField.textProperty());
			nv.nombreProperty().bindBidirectional(nombreTextField.textProperty());
			nv.apellidosProperty().bindBidirectional(apellidosTextField.textProperty());
			nv.fechaNacimientoProperty().bindBidirectional(fechaNacimientoDate.valueProperty());
			nv.direccionProperty().bindBidirectional(direccionTextArea.textProperty());
			nv.codigoPostalProperty().bindBidirectional(codigoPostalTextField.textProperty());
			nv.localidadProperty().bindBidirectional(localidadtextField.textProperty());
			nv.paisProperty().bind(paisComboBox.getSelectionModel().selectedItemProperty());
			nacionalidadesListView.itemsProperty().bind(nv.nacionalidadesProperty());
			
		}

	}

	@FXML
	void onAnadirNacionalidad(ActionEvent event) {

	}

	@FXML
	void onQuitarNacionalidad(ActionEvent event) {
		if (!nacionalidadesListView.getSelectionModel().isEmpty()) {

		}
	}

	public GridPane getPersonalView() {
		return personalView;
	}

	public final ListProperty<String> paisesListProperty() {
		return this.paisesList;
	}
	

	public final ObservableList<String> getPaisesList() {
		return this.paisesListProperty().get();
	}
	

	public final void setPaisesList(final ObservableList<String> paisesList) {
		this.paisesListProperty().set(paisesList);
	}
	

	public final ListProperty<Nacionalidad> nacionalidadesListProperty() {
		return this.nacionalidadesList;
	}
	

	public final ObservableList<Nacionalidad> getNacionalidadesList() {
		return this.nacionalidadesListProperty().get();
	}
	

	public final void setNacionalidadesList(final ObservableList<Nacionalidad> nacionalidadesList) {
		this.nacionalidadesListProperty().set(nacionalidadesList);
	}
	

	public final ObjectProperty<Personal> personalObjectPropertyProperty() {
		return this.personalObjectProperty;
	}
	

	public final Personal getPersonalObjectProperty() {
		return this.personalObjectPropertyProperty().get();
	}
	

	public final void setPersonalObjectProperty(final Personal personalObjectProperty) {
		this.personalObjectPropertyProperty().set(personalObjectProperty);
	}
	

	
	
}
