package cv;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {

	LocalDate desde;
	LocalDate hasta;
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
	
	
	
}
