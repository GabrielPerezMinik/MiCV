package gui.Entrañas;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ResourceBundle;

import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import cv.CV;
import gui.lanzador.AppCV;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import json.LocalDateAdapter;

public class RootController implements Initializable {
	
	private static Gson gson = FxGson.fullBuilder().setPrettyPrinting()
			.registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

	//model
	private ObjectProperty<CV> cv = new SimpleObjectProperty<>();
	private Boolean guardar=false;
	private File ficheroCV;
 	

	//Conexion Controladores
	
	ConocimientoController conocimientoController= new ConocimientoController();
	PersonalController personalController= new PersonalController();
	ExperienciaController experienciaController= new ExperienciaController();
	ContactoController contactoController= new ContactoController();
	FormacionController formacionController= new FormacionController();
	
	
	
	@FXML
	private ImageView abrirImage;

	@FXML
	private MenuItem abrirMenuItem;

	@FXML
	private Tab conocimientoTab;

	@FXML
	private Tab contactoTab;

	@FXML
	private Tab experienciaTab;

	@FXML
	private Tab formacionTab;

	@FXML
	private MenuItem guardarComoMenuItem;

	@FXML
	private ImageView guardarImage;

	@FXML
	private MenuItem guardarMenuItem;

	@FXML
	private ImageView nuevoImage;

	@FXML
	private MenuItem nuevoMenuItem;

	@FXML
	private Tab personalTab;

	@FXML
	private BorderPane rootView;

	@FXML
	private MenuItem salirMenuItem;

	public RootController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Root.fxml"));
		loader.setController(this);
		loader.load();

		nuevoImage.setImage(new Image("/images/nuevo.png"));
		abrirImage.setImage(new Image("/images/abrir.png"));
		guardarImage.setImage(new Image("/images/guardar.png"));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		personalTab.setContent(personalController.getPersonalView());
		contactoTab.setContent(contactoController.getContacView());
		formacionTab.setContent(formacionController.getFormacionView());
		experienciaTab.setContent(experienciaController.getExperienciaView());
		conocimientoTab.setContent(conocimientoController.getConocimientoView());
		
		cv.addListener(this::onCVChanged);
		
		cv.set(new CV());
		
	}

	private void onCVChanged(ObservableValue<? extends CV> o, CV ov, CV nv) {
	
		if (ov != null) {
		personalController.personalObjectProperty().unbind();
		contactoController.contactoObjectProperty().unbind();
		experienciaController.experienciaListProperty().unbind();
		formacionController.FormacionListProperty().unbind();
		conocimientoController.conocimientoListProperty().unbind();

	}

	if (nv != null) {
		personalController.personalObjectProperty().bind(nv.personalObjectProperty());
		contactoController.contactoObjectProperty().bind(nv.contactObjectProperty());
		experienciaController.experienciaListProperty().bind(nv.experienciaListProperty());
		formacionController.FormacionListProperty().bind(nv.titulosListProperty());
		conocimientoController.conocimientoListProperty().bind(nv.conocimientoListProperty());

	}
		
	}

	@FXML
	void onAbrirCV(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(AppCV.PrimaryStage);
		
		if(selectedFile !=null) {
			try {
				String json = Files.readString(selectedFile.toPath(),StandardCharsets.UTF_8);
				CV cv = gson.fromJson(json, CV.class);
				this.cv.set(cv);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@FXML
	void onCrearNuevoCV(ActionEvent event) {

		CV cv = new CV();
		this.cv.set(cv);
		
	}

	@FXML
	void onGuardar(ActionEvent event) {
		if (!guardar) {
			onGuardarComo(event);
			guardar = true;
		} else {
			if (ficheroCV != null) {
				String json = gson.toJson(cv.get(), CV.class);
				try {
					Files.writeString(ficheroCV.toPath(), json, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
				} catch (IOException e) {
					Alert alertaErrort= new Alert(AlertType.ERROR);
					alertaErrort.setHeaderText("ocurrio un error");
					alertaErrort.setContentText("El Curriculum Vitae no se ha podido guardar");
					alertaErrort.showAndWait();
				}
			}
		}
		
	}

	@FXML
	void onGuardarComo(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
		File cvFile = fileChooser.showSaveDialog(AppCV.PrimaryStage);

		if(cvFile != null) {
			String json = gson.toJson(cv.get(), CV.class);
			try {
				Files.writeString(cvFile.toPath(), json, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
			} catch (IOException e) {
				Alert alertaErrort= new Alert(AlertType.ERROR);
				alertaErrort.setHeaderText("ocurrio un error");
				alertaErrort.setContentText("El Curriculum Vitae no se ha podido guardar");
				alertaErrort.showAndWait();
			}
		}
	}

	@FXML
	void onSalir(ActionEvent event) {

		AppCV.PrimaryStage.close();
	}

	public BorderPane getRootView() {
		return rootView;
	}

}
