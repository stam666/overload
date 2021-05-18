package scoreboard;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.Player;

public class Test extends Application {
	public void start(Stage primaryStage) {
		// TODO
		ArrayList<Player> s= new ArrayList<Player>();
		s.add(new Player("AA"));
		s.add(new Player("AS"));
		s.add(new Player("ADD"));
		s.add(new Player("CC"));
		HBox root = new ScoreboardPane(s);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setMaxWidth(1024);
		primaryStage.setMinWidth(1024);
		primaryStage.setMaxHeight(256);
		primaryStage.setMinHeight(256);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
