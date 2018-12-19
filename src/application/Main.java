package application;

import java.io.IOException;

import control.ChartDisplayCon;
import control.StartUpCon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	/**Stages for display*/
	public static Stage displayStage, popupStage = new Stage();

	/**Display scenes*/
	public static Scene startUpScene, chartDisplayScene;

	/**Display scenes for hostess station*/
	public static StartUpCon startUpCon;
	/**Display scenes for options screen*/
	public static ChartDisplayCon chartDisplayCon;

	/**Create scenes and controllers*/
	public void init(){
		try {
			//startup scene and controller
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StartUpView.fxml"));
			Parent sceneView = loader.load();
		    startUpCon = loader.getController();
			startUpScene = new Scene(sceneView, 800, 600);

			//chart display scene and controller
			loader = new FXMLLoader(getClass().getResource("/view/ChartDisplayView.fxml"));
		    sceneView = loader.load();
			chartDisplayCon = loader.getController();
			chartDisplayScene = new Scene(sceneView, 800, 600);

		} catch (Exception e) {
			//TODO: add real error handling
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		//set stage properties and other startup items
		this.displayStage = primaryStage;

		//start GUI
		try {
			displayStage.setScene(startUpScene);
			displayStage.show();
		} catch(Exception e) {
			//TODO: add real error handling
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
