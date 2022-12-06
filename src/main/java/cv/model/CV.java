package cv.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {

	private ObjectProperty<Personal>personal = new SimpleObjectProperty<>(new Personal());
	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<>(new Contacto());
	private ListProperty<Titulo> titulos = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Experiencia> experiencia = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Conocimiento> conocimiento = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}
	
	public final Personal getPersonal() {
		return this.personalProperty().get();
	}
	
	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}
	
	public final ObjectProperty<Contacto> contactoProperty() {
		return this.contacto;
	}
	
	public final Contacto getContacto() {
		return this.contactoProperty().get();
	}
	
	public final void setContacto(final Contacto contacto) {
		this.contactoProperty().set(contacto);
	}
	
	public final ListProperty<Titulo> titulosProperty() {
		return this.titulos;
	}
	
	public final ObservableList<Titulo> getTitulos() {
		return this.titulosProperty().get();
	}
	
	public final void setTitulos(final ObservableList<Titulo> titulos) {
		this.titulosProperty().set(titulos);
	}
	
	public final ListProperty<Experiencia> experienciaProperty() {
		return this.experiencia;
	}
	
	public final ObservableList<Experiencia> getExperiencia() {
		return this.experienciaProperty().get();
	}
	
	public final void setExperiencia(final ObservableList<Experiencia> experiencia) {
		this.experienciaProperty().set(experiencia);
	}
	
	public final ListProperty<Conocimiento> conocimientoProperty() {
		return this.conocimiento;
	}
	
	public final ObservableList<Conocimiento> getConocimiento() {
		return this.conocimientoProperty().get();
	}
	
	public final void setConocimiento(final ObservableList<Conocimiento> conocimiento) {
		this.conocimientoProperty().set(conocimiento);
	}
	
}
