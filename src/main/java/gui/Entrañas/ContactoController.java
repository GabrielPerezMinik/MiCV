package gui.Entrañas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;

public class ContactoController implements Initializable {

	
	@FXML
    private SplitPane contacView;
	
	

	public ContactoController() throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	

	}

	public SplitPane getContacView() {
		return contacView;
	}
	
}
