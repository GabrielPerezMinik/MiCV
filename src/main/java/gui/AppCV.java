package gui;

import gui.Entrañas.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppCV extends Application{

	 public static Stage PrimaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AppCV.PrimaryStage=primaryStage;
		
		RootController controller= new RootController();
		
		
		primaryStage.setTitle("MiCV");
		primaryStage.getIcons().addAll(new Image("/images/cv64x64.png"));
		primaryStage.setScene(new Scene(controller.getRootView()));
		primaryStage.show();
		
	}

	public static void main(String[] args){
		launch(args);

	}
	
}
