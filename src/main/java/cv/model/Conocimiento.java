package cv.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conocimiento {

	StringProperty denominacion= new SimpleStringProperty();
	private ObjectProperty<Nivel> nivelObject = new SimpleObjectProperty<>();

	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	

	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	

	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}


	public final ObjectProperty<Nivel> nivelObjectProperty() {
		return this.nivelObject;
	}
	


	public final Nivel getNivelObject() {
		return this.nivelObjectProperty().get();
	}
	


	public final void setNivelObject(final Nivel nivelObject) {
		this.nivelObjectProperty().set(nivelObject);
	}
		
	
}
