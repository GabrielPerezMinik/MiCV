package cv.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import cv.gui.app.AppCV;
import cv.gui.dialogs.TituloDialog;
import cv.model.Titulo;
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

public class FormacionController implements Initializable {

	private ListProperty<Titulo> FormacionList = new SimpleListProperty<>();
	

    @FXML
    private TableView<Titulo> formacionTableView;

	@FXML
    private TableColumn<Titulo, String> denominacionColumnTable;

    @FXML
    private TableColumn<Titulo, LocalDate> desdeColumnTable;

    @FXML
    private TableColumn<Titulo, LocalDate> hastaColumnTable;

    @FXML
    private TableColumn<Titulo, String> organizadorColumnTable;
	
    @FXML
    private BorderPane formacionView;

    public FormacionController() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FormacionView.fxml"));
		loader.setController(this);
		loader.load();

    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		formacionTableView.itemsProperty().bind(FormacionList);

		denominacionColumnTable.setCellValueFactory(v -> v.getValue().denominacionProperty());
		organizadorColumnTable.setCellValueFactory(v -> v.getValue().organizadorProperty());
		desdeColumnTable.setCellValueFactory(v -> v.getValue().desdeObjectProperty());
		hastaColumnTable.setCellValueFactory(v -> v.getValue().hastaObjectProperty());
		

		denominacionColumnTable.setCellFactory(TextFieldTableCell.forTableColumn());
		organizadorColumnTable.setCellFactory(TextFieldTableCell.forTableColumn());
		hastaColumnTable.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		desdeColumnTable.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		
	}


    @FXML
    void onAnadir(ActionEvent event) {
    	TituloDialog dialog = new TituloDialog();
    	dialog.initOwner(AppCV.PrimaryStage);
    	Titulo titulo = dialog.showAndWait().orElse(null);
    	if(titulo != null) {
    		FormacionListProperty().add(titulo);
    	}
    }

    @FXML
    void onEliminar(ActionEvent event) {
    	if(!formacionTableView.getSelectionModel().isEmpty()) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.initOwner(AppCV.PrimaryStage);
        	alert.setTitle("Confirmacion");
        	alert.setHeaderText("Confirmacion de eliminar");
        	alert.setContentText("Estás seguro que desea eliminar?");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){
        		getFormacionList().remove(formacionTableView.getSelectionModel().selectedIndexProperty().get());
        	} 
    	}
    }

	
	public BorderPane getFormacionView() {
		return formacionView;
	}

	public final ListProperty<Titulo> FormacionListProperty() {
		return this.FormacionList;
	}
	

	public final ObservableList<Titulo> getFormacionList() {
		return this.FormacionListProperty().get();
	}
	

	public final void setFormacionList(final ObservableList<Titulo> FormacionList) {
		this.FormacionListProperty().set(FormacionList);
	}	

}
