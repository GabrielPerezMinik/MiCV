package gui.Entrañas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import cv.Experiencia;
import gui.Entrañas.Dialog.ExperienciaDialog;
import gui.lanzador.AppCV;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.LocalDateStringConverter;

public class ExperienciaController implements Initializable {

	private ListProperty<Experiencia> experienciaList = new SimpleListProperty<>();

	@FXML
	private TableView<Experiencia> experienciaTableView;

	@FXML
	private TableColumn<Experiencia, String> denominacioColumnTable;

	@FXML
	private TableColumn<Experiencia, LocalDate> desdeColumtable;

	@FXML
	private TableColumn<Experiencia, String> empleadorColumTable;

	@FXML
	private TableColumn<Experiencia, LocalDate> hastaColumntable;

	@FXML
	private BorderPane experienciaView;

	public ExperienciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ExperienciaView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		experienciaTableView.itemsProperty().bind(experienciaList);
		denominacioColumnTable.setCellValueFactory(v -> v.getValue().denominacionProperty());
		empleadorColumTable.setCellValueFactory(v -> v.getValue().empleadorProperty());
		desdeColumtable.setCellValueFactory(v -> v.getValue().desdeObjectProperty());
		hastaColumntable.setCellValueFactory(v -> v.getValue().hastaObjectProperty());
		
		
		denominacioColumnTable.setCellFactory(TextFieldTableCell.forTableColumn());
		empleadorColumTable.setCellFactory(TextFieldTableCell.forTableColumn());
		desdeColumtable.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		hastaColumntable.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));

	}

	@FXML
	void onAnadir(ActionEvent event) {
		ExperienciaDialog dialog = new ExperienciaDialog();
    	dialog.initOwner(AppCV.PrimaryStage);
    	Experiencia experiencia = dialog.showAndWait().orElse(null);
    	if(experiencia != null) {
    		getExperienciaList().add(experiencia);
    		
    	}
	}

	@FXML
	void onElimiar(ActionEvent event) {
		if(!experienciaTableView.getSelectionModel().isEmpty()) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.initOwner(AppCV.PrimaryStage);
        	alert.setTitle("Confirmacion");
        	alert.setHeaderText("Confirmacion de eliminar");
        	alert.setContentText("Estás seguro que desea eliminar?");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){
        		getExperienciaList().remove(experienciaTableView.getSelectionModel().selectedIndexProperty().get());
        	} 
    	}
	}

	public BorderPane getExperienciaView() {
		return experienciaView;
	}

	public final ListProperty<Experiencia> experienciaListProperty() {
		return this.experienciaList;
	}

	public final ObservableList<Experiencia> getExperienciaList() {
		return this.experienciaListProperty().get();
	}

	public final void setExperienciaList(final ObservableList<Experiencia> experienciaList) {
		this.experienciaListProperty().set(experienciaList);
	}

}
