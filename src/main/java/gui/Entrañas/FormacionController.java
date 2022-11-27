package gui.Entrañas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class FormacionController implements Initializable {

	 	
    @FXML
    private BorderPane formacionView;

    public FormacionController() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FormacionView.fxml"));
		loader.setController(this);
		loader.load();

    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


	public BorderPane getFormacionView() {
		return formacionView;
	}
	

}
