package screen;

import java.util.ArrayList;

import gui.score.ScoreboardPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import player.Player;

public class Test extends Application {
	public void start(Stage primaryStage) {
		// TODO
		StartScreen root1= new StartScreen();
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
