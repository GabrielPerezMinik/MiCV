package cv;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {

	private ObjectProperty<Personal>personalProperty = new SimpleObjectProperty<>(new Personal());
	private ObjectProperty<Contacto> contactProperty = new SimpleObjectProperty<>(new Contacto());
	private ListProperty<Titulo> titulosListProperty = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Experiencia> experienciaListProperty = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Conocimiento> conocimientoListProperty = new SimpleListProperty<>(FXCollections.observableArrayList()); 
	
	
	public final ObjectProperty<Personal> personalPropertyProperty() {
		return this.personalProperty;
	}
	

	public final Personal getPersonalProperty() {
		return this.personalPropertyProperty().get();
	}
	

	public final void setPersonalProperty(final Personal personalProperty) {
		this.personalPropertyProperty().set(personalProperty);
	}


	public final ObjectProperty<Contacto> contactPropertyProperty() {
		return this.contactProperty;
	}
	


	public final Contacto getContactProperty() {
		return this.contactPropertyProperty().get();
	}
	


	public final void setContactProperty(final Contacto contactProperty) {
		this.contactPropertyProperty().set(contactProperty);
	}
	


	public final ListProperty<Titulo> titulosListPropertyProperty() {
		return this.titulosListProperty;
	}
	


	public final ObservableList<Titulo> getTitulosListProperty() {
		return this.titulosListPropertyProperty().get();
	}
	


	public final void setTitulosListProperty(final ObservableList<Titulo> titulosListProperty) {
		this.titulosListPropertyProperty().set(titulosListProperty);
	}
	


	public final ListProperty<Experiencia> experienciaListPropertyProperty() {
		return this.experienciaListProperty;
	}
	


	public final ObservableList<Experiencia> getExperienciaListProperty() {
		return this.experienciaListPropertyProperty().get();
	}
	


	public final void setExperienciaListProperty(final ObservableList<Experiencia> experienciaListProperty) {
		this.experienciaListPropertyProperty().set(experienciaListProperty);
	}
	


	public final ListProperty<Conocimiento> conocimientoListPropertyProperty() {
		return this.conocimientoListProperty;
	}
	


	public final ObservableList<Conocimiento> getConocimientoListProperty() {
		return this.conocimientoListPropertyProperty().get();
	}
	


	public final void setConocimientoListProperty(final ObservableList<Conocimiento> conocimientoListProperty) {
		this.conocimientoListPropertyProperty().set(conocimientoListProperty);
	}
	
	
	
	
	
}
