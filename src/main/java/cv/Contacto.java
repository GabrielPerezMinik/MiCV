package cv;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contacto {

	ListProperty<Telefono> telefonosList = new SimpleListProperty<>(FXCollections.observableArrayList());
	ListProperty<Email> emailList = new SimpleListProperty<>(FXCollections.observableArrayList());
	ListProperty<Web> webList = new SimpleListProperty<>(FXCollections.observableArrayList());

	public final ListProperty<Telefono> telefonosListProperty() {
		return this.telefonosList;
	}

	public final ObservableList<Telefono> getTelefonosList() {
		return this.telefonosListProperty().get();
	}

	public final void setTelefonosList(final ObservableList<Telefono> telefonosList) {
		this.telefonosListProperty().set(telefonosList);
	}

	public final ListProperty<Email> emailListProperty() {
		return this.emailList;
	}

	public final ObservableList<Email> getEmailList() {
		return this.emailListProperty().get();
	}

	public final void setEmailList(final ObservableList<Email> emailList) {
		this.emailListProperty().set(emailList);
	}

	public final ListProperty<Web> webListProperty() {
		return this.webList;
	}

	public final ObservableList<Web> getWebList() {
		return this.webListProperty().get();
	}

	public final void setWebList(final ObservableList<Web> webList) {
		this.webListProperty().set(webList);
	}

}
