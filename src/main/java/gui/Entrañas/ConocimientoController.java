package gui.Entrañas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class ConocimientoController implements Initializable {

	@FXML
	private BorderPane conocimientoView;

	public ConocimientoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	void onAnadirConocimiento(ActionEvent event) {

	}

	@FXML
	void onAnadirIdioma(ActionEvent event) {

	}

	@FXML
	void onEliminar(ActionEvent event) {

	}

	public BorderPane getConocimientoView() {
		return conocimientoView;
	}

}
