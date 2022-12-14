package cv.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cv.gui.app.AppCV;
import cv.gui.dialogs.TelefonoDialog;
import cv.model.Contacto;
import cv.model.Email;
import cv.model.Telefono;
import cv.model.TipoTelefono;
import cv.model.Web;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;

public class ContactoController implements Initializable {

	private ObjectProperty<Contacto> contactoObject = new SimpleObjectProperty<>();
	

	@FXML
	private SplitPane contacView;

	@FXML
	private TableView<Email> emailTableView;

	@FXML
	private TableColumn<Email, String> emailColumntable;

	@FXML
	private TableView<Telefono> telefonoTableView;

	@FXML
	private TableColumn<Telefono, String> numeroTableColum;

	@FXML
	private TableColumn<Telefono, TipoTelefono> tipoTableColum;

	@FXML
	private TableView<Web> urlTableView;

	@FXML
	private TableColumn<Web, String> urlColumnTable;

	public ContactoController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ContactoView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		contactoObject.addListener((o, ov, nv) -> onContactoChanged(o, ov, nv));

		numeroTableColum.setCellValueFactory(v -> v.getValue().numeroProperty());
		tipoTableColum.setCellValueFactory(v -> v.getValue().tipoTelefonoProperty());
		numeroTableColum.setCellFactory(TextFieldTableCell.forTableColumn());
		tipoTableColum.setCellFactory(ComboBoxTableCell.forTableColumn(TipoTelefono.values()));

		emailColumntable.setCellValueFactory(v -> v.getValue().direccionProperty());
		emailColumntable.setCellFactory(TextFieldTableCell.forTableColumn());

		urlColumnTable.setCellValueFactory(v -> v.getValue().urlProperty());
		urlColumnTable.setCellFactory(TextFieldTableCell.forTableColumn());

	}

	private void onContactoChanged(ObservableValue<? extends Contacto> o, Contacto ov, Contacto nv) {
		if (ov != null) {
			telefonoTableView.itemsProperty().unbindBidirectional(ov.telefonosProperty());
			emailTableView.itemsProperty().unbindBidirectional(ov.emailProperty());
			urlTableView.itemsProperty().unbindBidirectional(ov.webProperty());
		}

		if (nv != null) {
			telefonoTableView.itemsProperty().bindBidirectional(nv.telefonosProperty());
			emailTableView.itemsProperty().bindBidirectional(nv.emailProperty());
			urlTableView.itemsProperty().bindBidirectional(nv.webProperty());
		}
	}

	@FXML
	void onAnadirTelef(ActionEvent event) {
		TelefonoDialog dialog = new TelefonoDialog();
		dialog.initOwner(AppCV.PrimaryStage);
		Telefono telefono = dialog.showAndWait().orElse(null);
		if (telefono != null) {
			getContactoObjectProperty().telefonosProperty().add(telefono);
		}
	}

	@FXML
	void onEliminarTelef(ActionEvent event) {
		if (!telefonoTableView.getSelectionModel().isEmpty()) {
			getContactoObjectProperty().telefonosProperty()
					.remove(telefonoTableView.getSelectionModel().selectedIndexProperty().get());
		}
	}

	@FXML
	void onAnadirEmail(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.initOwner(AppCV.PrimaryStage);
		dialog.setTitle("E-MAIL");
		dialog.setHeaderText("A??adir una nueva direcci??n de correo.");
		dialog.setContentText("E-mail: ");
		Email email = new Email();
		String t=dialog.showAndWait().orElse(null);
		email.setDireccion(t);
		if (email != null) {
			getContactoObjectProperty().emailProperty().add(email);

		}
	}

	@FXML
	void onEliminarEmail(ActionEvent event) {
		if (!emailTableView.getSelectionModel().isEmpty()) {
			getContactoObjectProperty().emailProperty()
					.remove(emailTableView.getSelectionModel().selectedIndexProperty().get());
		}
	}

	@FXML
	void onAnadirURL(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.initOwner(AppCV.PrimaryStage);
		dialog.setTitle("WEB");
		dialog.setHeaderText("A??adir una nueva direcci??n web.");
		dialog.setContentText("URL: ");
		Web web = new Web();
		String t=dialog.showAndWait().orElse(null);
		web.setUrl(t);
		if (web != null) {
			getContactoObjectProperty().webProperty().add(web);
		}
	}

	@FXML
	void onEliminarURL(ActionEvent event) {
		if (!urlTableView.getSelectionModel().isEmpty()) {
			getContactoObjectProperty().webProperty()
					.remove(urlTableView.getSelectionModel().selectedIndexProperty().get());
		}
	}

	public SplitPane getContacView() {
		return contacView;
	}

	public final ObjectProperty<Contacto> contactoObjectProperty() {
		return this.contactoObject;
	}

	public final Contacto getContactoObjectProperty() {
		return this.contactoObjectProperty().get();
	}

	public final void setContactoObjectProperty(final Contacto contactoObjectProperty) {
		this.contactoObjectProperty().set(contactoObjectProperty);
	}

}
