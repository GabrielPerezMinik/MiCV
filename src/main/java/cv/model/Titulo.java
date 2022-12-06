package cv.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Titulo {
	
	private ObjectProperty<LocalDate> desdeObject = new SimpleObjectProperty<>();
	private ObjectProperty<LocalDate> hastaObject = new SimpleObjectProperty<>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty organizador = new SimpleStringProperty();
	
	public final ObjectProperty<LocalDate> desdeObjectProperty() {
		return this.desdeObject;
	}
	
	public final LocalDate getDesdeObject() {
		return this.desdeObjectProperty().get();
	}
	
	public final void setDesdeObject(final LocalDate desdeObject) {
		this.desdeObjectProperty().set(desdeObject);
	}
	
	public final ObjectProperty<LocalDate> hastaObjectProperty() {
		return this.hastaObject;
	}
	
	public final LocalDate getHastaObject() {
		return this.hastaObjectProperty().get();
	}
	
	public final void setHastaObject(final LocalDate hastaObject) {
		this.hastaObjectProperty().set(hastaObject);
	}
	
	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	
	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	
	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
	public final StringProperty organizadorProperty() {
		return this.organizador;
	}
	
	public final String getOrganizador() {
		return this.organizadorProperty().get();
	}
	
	public final void setOrganizador(final String organizador) {
		this.organizadorProperty().set(organizador);
	}	
	
}
