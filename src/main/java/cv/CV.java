package cv;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {

	private ObjectProperty<Personal>personalObject = new SimpleObjectProperty<>(new Personal());
	private ObjectProperty<Contacto> contactObject = new SimpleObjectProperty<>(new Contacto());
	private ListProperty<Titulo> titulosList = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Experiencia> experienciaList = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Conocimiento> conocimientoList = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	public final ObjectProperty<Personal> personalObjectProperty() {
		return this.personalObject;
	}
	
	public final Personal getPersonalObject() {
		return this.personalObjectProperty().get();
	}
	
	public final void setPersonalObject(final Personal personalObject) {
		this.personalObjectProperty().set(personalObject);
	}
	
	public final ObjectProperty<Contacto> contactObjectProperty() {
		return this.contactObject;
	}
	
	public final Contacto getContactObject() {
		return this.contactObjectProperty().get();
	}
	
	public final void setContactObject(final Contacto contactObject) {
		this.contactObjectProperty().set(contactObject);
	}
	
	public final ListProperty<Titulo> titulosListProperty() {
		return this.titulosList;
	}
	
	public final ObservableList<Titulo> getTitulosList() {
		return this.titulosListProperty().get();
	}
	
	public final void setTitulosList(final ObservableList<Titulo> titulosList) {
		this.titulosListProperty().set(titulosList);
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
