package gui.end;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class test extends Application {
	public void start(Stage primaryStage) {
		// TODO
		EndScreen root1= new EndScreen("RED");
		//ButtonStart root1 = new ButtonStart(); 
		Scene scene = new Scene(root1);
		primaryStage.setScene(scene);
		primaryStage.setMaxWidth(1024);
		primaryStage.setMinWidth(1024);
		primaryStage.setMaxHeight(768);
		primaryStage.setMinHeight(768);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

