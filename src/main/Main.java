package main;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.SceneHolder;
import sharedObject.ImageHolder;

public class Main extends Application {
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	public static SceneHolder sceneHolder;

	@Override
	public void start(Stage primaryStage) throws Exception {
		sceneHolder = new SceneHolder(primaryStage);
		sceneHolder.initialize();
		primaryStage.getIcons().add(ImageHolder.getInstance().lightRedPole1D.get(8));
		primaryStage.setTitle("OverLoad");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
