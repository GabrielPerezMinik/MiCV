package cv.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import cv.gui.app.AppCV;
import cv.gui.dialogs.ConocimientoDialog;
import cv.gui.dialogs.IdiomaDialog;
import cv.model.Conocimiento;
import cv.model.Nivel;
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
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;

public class ConocimientoController implements Initializable {

	private ListProperty<Conocimiento> conocimientoList = new SimpleListProperty<>();

	@FXML
	private TableView<Conocimiento> conocimientoTable;

	@FXML
	private TableColumn<Conocimiento, String> denomicionColumTable;

	@FXML
	private TableColumn<Conocimiento, Nivel> nivelColumntable;

	@FXML
	private BorderPane conocimientoView;

	public ConocimientoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		conocimientoTable.itemsProperty().bind(conocimientoList);

		denomicionColumTable.setCellValueFactory(v -> v.getValue().denominacionProperty());
		nivelColumntable.setCellValueFactory(v -> v.getValue().nivelObjectProperty());

		
		denomicionColumTable.setCellFactory(TextFieldTableCell.forTableColumn());
		nivelColumntable.setCellFactory(ComboBoxTableCell.forTableColumn(Nivel.values()));

	}

	@FXML
	void onAnadirConocimiento(ActionEvent event) {

		ConocimientoDialog dialog = new ConocimientoDialog();
		dialog.initOwner(AppCV.PrimaryStage);
		Conocimiento conocimiento = dialog.showAndWait().orElse(null);
		if (conocimiento != null) {
			conocimientoListProperty().add(conocimiento);
		}
		
	}

	@FXML
	void onAnadirIdioma(ActionEvent event) {
		IdiomaDialog dialog = new IdiomaDialog();
		dialog.initOwner(AppCV.PrimaryStage);
		Conocimiento conocimiento = dialog.showAndWait().orElse(null);
		if (conocimiento != null) {
			conocimientoListProperty().add(conocimiento);
		}
	}

	@FXML
	void onEliminar(ActionEvent event) {
		if (!conocimientoTable.getSelectionModel().isEmpty()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initOwner(AppCV.PrimaryStage);
			alert.setTitle("Confirmacion");
			alert.setHeaderText("Confirmacion de eliminar");
			alert.setContentText("Estás seguro que desea eliminar?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				getConocimientoList().remove(conocimientoTable.getSelectionModel().selectedIndexProperty().get());
			}
		}
	}

	public BorderPane getConocimientoView() {
		return conocimientoView;
	}

	public final ListProperty<Conocimiento> conocimientoListProperty() {
		return this.conocimientoList;
	}

	public final ObservableList<Conocimiento> getConocimientoList() {
		return this.conocimientoListProperty().get();
	}

	public final void setConocimientoList(final ObservableList<Conocimiento> conocimientoList) {
		this.conocimientoListProperty().set(conocimientoList);
	}

}
