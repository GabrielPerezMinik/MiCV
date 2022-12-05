package cv;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {

	ObjectProperty<LocalDate> desdeObject= new SimpleObjectProperty<>();
	ObjectProperty<LocalDate> hastaObject= new SimpleObjectProperty<>();
	StringProperty denominacion=new SimpleStringProperty();
	StringProperty empleador=new SimpleStringProperty();
	
	
	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	
	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	
	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
	public final StringProperty empleadorProperty() {
		return this.empleador;
	}
	
	public final String getEmpleador() {
		return this.empleadorProperty().get();
	}
	
	public final void setEmpleador(final String empleador) {
		this.empleadorProperty().set(empleador);
	}

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
	
}
