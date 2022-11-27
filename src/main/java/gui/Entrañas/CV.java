package gui.Entrañas;

import cv.Conocimiento;
import cv.Contacto;
import cv.Experiencia;
import cv.Personal;
import cv.Titulo;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {

	ObjectProperty<Personal> personalObjectProperty= new SimpleObjectProperty<Personal>();
	ObjectProperty<Contacto> contactoObjectProperty= new SimpleObjectProperty<Contacto>();
	ListProperty<Conocimiento> conocimientoList= new SimpleListProperty<Conocimiento>(FXCollections.observableArrayList());
	ListProperty<Titulo> tituloList= new SimpleListProperty<Titulo>(FXCollections.observableArrayList());
	ListProperty<Experiencia> experienciaList= new SimpleListProperty<Experiencia>(FXCollections.observableArrayList());
	
	
	public final ListProperty<Conocimiento> conocimientoListProperty() {
		return this.conocimientoList;
	}
	
	public final ObservableList<Conocimiento> getConocimientoList() {
		return this.conocimientoListProperty().get();
	}
	
	public final void setConocimientoList(final ObservableList<Conocimiento> conocimientoList) {
		this.conocimientoListProperty().set(conocimientoList);
	}
	
	public final ListProperty<Titulo> tituloListProperty() {
		return this.tituloList;
	}
	
	public final ObservableList<Titulo> getTituloList() {
		return this.tituloListProperty().get();
	}
	
	public final void setTituloList(final ObservableList<Titulo> tituloList) {
		this.tituloListProperty().set(tituloList);
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

	public final ObjectProperty<Personal> personalObjectPropertyProperty() {
		return this.personalObjectProperty;
	}
	

	public final Personal getPersonalObjectProperty() {
		return this.personalObjectPropertyProperty().get();
	}
	

	public final void setPersonalObjectProperty(final Personal personalObjectProperty) {
		this.personalObjectPropertyProperty().set(personalObjectProperty);
	}
	

	public final ObjectProperty<Contacto> contactoObjectPropertyProperty() {
		return this.contactoObjectProperty;
	}
	

	public final Contacto getContactoObjectProperty() {
		return this.contactoObjectPropertyProperty().get();
	}
	

	public final void setContactoObjectProperty(final Contacto contactoObjectProperty) {
		this.contactoObjectPropertyProperty().set(contactoObjectProperty);
	}
	
}
