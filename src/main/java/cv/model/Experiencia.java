package cv.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {

	ObjectProperty<LocalDate> desde= new SimpleObjectProperty<>();
	ObjectProperty<LocalDate> hasta= new SimpleObjectProperty<>();
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

	public final ObjectProperty<LocalDate> desdeProperty() {
		return this.desde;
	}
	

	public final LocalDate getDesde() {
		return this.desdeProperty().get();
	}
	

	public final void setDesde(final LocalDate desdeObject) {
		this.desdeProperty().set(desdeObject);
	}
	

	public final ObjectProperty<LocalDate> hastaProperty() {
		return this.hasta;
	}
	

	public final LocalDate getHasta() {
		return this.hastaProperty().get();
	}
	

	public final void setHasta(final LocalDate hasta) {
		this.hastaProperty().set(hasta);
	}
	
}
