package gui.board;

import java.util.ArrayList;

import gui.score.ScoreboardPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import player.Player;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class testBoard extends Application {	
	private Canvas gameCanvas;
	private GraphicsContext gamegc;
	
	public void start(Stage primaryStage) {
		// TODO
		BoardPane root = new BoardPane(4, 18);
		this.gameCanvas = new Canvas(1024, 400);
		gamegc = this.gameCanvas.getGraphicsContext2D();
		root.getChildren().add(gameCanvas);
		RenderableHolder.getInstance().getEntities();
		RenderableHolder.getInstance().update();
		for (IRenderable entity: RenderableHolder.getInstance().getEntities()) {
			entity.draw(gamegc);
		}
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
		primaryStage.setMaxHeight(400);
		primaryStage.setMinHeight(400);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
