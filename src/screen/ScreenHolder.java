package screen;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenHolder {
	private Stage bindStage;
	public StartScreen startScreen;
	
	public ScreenHolder(Stage bindStage) {
		this.bindStage = bindStage;
	}
	
	public void initialize() {
		startScreen = new StartScreen();
		switchScreen(startScreen);
	}
	
	
	public void switchScreen(Scene nextScreen) {
		bindStage.setResizable(false);
		bindStage.setScene(nextScreen);
		bindStage.sizeToScene();
	}
	
}
