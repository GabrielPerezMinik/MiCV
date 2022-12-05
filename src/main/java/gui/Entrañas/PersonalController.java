package gui.Entrañas;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import cv.Nacionalidad;
import cv.Personal;
import gui.lanzador.AppCV;
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
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable {
	
	ListProperty<String> paisesList = new SimpleListProperty<>(FXCollections.observableArrayList());
	ListProperty<Nacionalidad> nacionalidadesList = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ObjectProperty<Personal> personalObject = new SimpleObjectProperty<>();

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
	private ListView<Nacionalidad> nacionalidadesListView;

	public PersonalController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PersonalView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		personalObject.addListener(this::onPersonalChanged);

		try {
			Path paisesFile = Paths.get(getClass().getResource("/csv/paises.csv").toURI());
			Path nacionalidadesFile = Paths.get(getClass().getResource("/csv/nacionalidades.csv").toURI());

			List<String> paises = Files.readAllLines(paisesFile, StandardCharsets.UTF_8);

			List<String> nacionalidades = Files.readAllLines(nacionalidadesFile, StandardCharsets.UTF_8);

			paisesList.setAll(paises);
			nacionalidadesList.setAll(nacionalidades.stream().map(s -> {
				Nacionalidad n = new Nacionalidad();
				n.setDenominacion(s);
				return n;
			}).collect(Collectors.toList()));

		} catch (URISyntaxException  | IOException e ) {
			e.printStackTrace();
		}

		paisComboBox.setItems(paisesList);

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

			dniTextField.textProperty().bindBidirectional(nv.identificacionProperty());
			nombreTextField.textProperty().bindBidirectional(nv.nombreProperty());
			apellidosTextField.textProperty().bindBidirectional(nv.apellidosProperty());
			fechaNacimientoDate.valueProperty().bindBidirectional(nv.fechaNacimientoProperty());
			direccionTextArea.textProperty().bindBidirectional(nv.direccionProperty());
			codigoPostalTextField.textProperty().bindBidirectional(nv.codigoPostalProperty());
			localidadtextField.textProperty().bindBidirectional(nv.localidadProperty());
			nacionalidadesListView.itemsProperty().bind(nv.nacionalidadesProperty());
    		
    		paisComboBox.getSelectionModel().select(nv.getPais());
    		nv.paisProperty().bind(paisComboBox.getSelectionModel().selectedItemProperty());
			
		}

	}

	@FXML
	void onAnadirNacionalidad(ActionEvent event) {

		ChoiceDialog<Nacionalidad> dialog = new ChoiceDialog<>();
		dialog.initOwner(AppCV.PrimaryStage);
		dialog.setTitle("Nueva nacionalidad");
		dialog.setHeaderText("Añadir nacionalidad");
		dialog.setContentText("Seleccione una nacionalidad");
		dialog.getItems().setAll(nacionalidadesList);
		dialog.getItems().removeAll(getPersonalObjectProperty().getNacionalidades());
		dialog.setSelectedItem(dialog.getItems().get(0));
		Nacionalidad nacionalidad = dialog.showAndWait().orElse(null);
		
		if(nacionalidad != null) {
			getPersonalObjectProperty().getNacionalidades().add(nacionalidad);
		}
		
	}

	@FXML
	void onQuitarNacionalidad(ActionEvent event) {
		if (!nacionalidadesListView.getSelectionModel().isEmpty()) {
			getPersonalObjectProperty().nacionalidadesProperty().remove(nacionalidadesListView.getSelectionModel().selectedIndexProperty().get());
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

	public final ObjectProperty<Personal> personalObjectProperty() {
		return this.personalObject;
	}

	public final Personal getPersonalObjectProperty() {
		return this.personalObjectProperty().get();
	}

	public final void setPersonalObjectProperty(final Personal personalObjectProperty) {
		this.personalObjectProperty().set(personalObjectProperty);
	}

}
