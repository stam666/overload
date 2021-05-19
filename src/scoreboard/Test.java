package scoreboard;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.Player;
import sharedObject.ImageHolder;

public class Test extends Application {
	public void start(Stage primaryStage) {
		// TODO
		ArrayList<Player> s= new ArrayList<Player>();
		s.add(new Player("AA"));
		s.add(new Player("AS"));
		s.add(new Player("ADD"));
		s.add(new Player("CC"));
		s.add(new Player("CCd"));
		HBox root = new ScoreboardPane(s);
	
		/*HBox root = new HBox();
		Canvas canvas = new Canvas(200,130);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		
		String img_path=ClassLoader.getSystemResource("pole/1D/blue/light/8.png").toString();
		Image sa =new Image(img_path);
		gc.drawImage(sa, 0, 0);
		root.getChildren().add(canvas);*/
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
