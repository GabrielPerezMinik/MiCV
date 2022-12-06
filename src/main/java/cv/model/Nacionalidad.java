package cv.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {

	public StringProperty denominacion= new SimpleStringProperty();

	public Nacionalidad() {}
	
	public Nacionalidad(String denominacion) {
		
		setDenominacion(denominacion);
		
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
	
	public String toString() {
		return getDenominacion();
	}
	
}
