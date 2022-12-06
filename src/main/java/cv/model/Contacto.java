package cv.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contacto {

	ListProperty<Telefono> telefonos = new SimpleListProperty<>(FXCollections.observableArrayList());
	ListProperty<Email> email = new SimpleListProperty<>(FXCollections.observableArrayList());
	ListProperty<Web> web = new SimpleListProperty<>(FXCollections.observableArrayList());

	public final ListProperty<Telefono> telefonosProperty() {
		return this.telefonos;
	}

	public final ObservableList<Telefono> getTelefonos() {
		return this.telefonosProperty().get();
	}

	public final void setTelefonos(final ObservableList<Telefono> telefonos) {
		this.telefonosProperty().set(telefonos);
	}

	public final ListProperty<Email> emailProperty() {
		return this.email;
	}

	public final ObservableList<Email> getEmail() {
		return this.emailProperty().get();
	}

	public final void setEmail(final ObservableList<Email> email) {
		this.emailProperty().set(email);
	}

	public final ListProperty<Web> webProperty() {
		return this.web;
	}

	public final ObservableList<Web> getWeb() {
		return this.webProperty().get();
	}

	public final void setWeb(final ObservableList<Web> web) {
		this.webProperty().set(web);
	}

}
