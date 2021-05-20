package gui.action;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.SubPlayer;

public class test extends Application {
	public void start(Stage primaryStage) {
		// TODO
		ArrayList<SubPlayer> s =  new ArrayList<SubPlayer>();
		for(int i=0;i<2;i++) {
			s.add(new SubPlayer(0, "PINK"));
		}
		HBox root = new PlayerAtSameActionPane(s,true);
		//HBox root1 = new PlayerAtSameActionPane(null, amLeft);
		ChoosePolePane root2 = new ChoosePolePane();
		ChooseNumberPane root3 = new ChooseNumberPane();
		//ActionPane root4= new ActionPane(3);
		Scene scene = new Scene(root2);
		primaryStage.setScene(scene);
		primaryStage.setMaxWidth(1024);
		primaryStage.setMinWidth(1024);
		primaryStage.setMaxHeight(200);
		primaryStage.setMinHeight(200);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
