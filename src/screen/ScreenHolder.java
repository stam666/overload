package screen;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenHolder {
	private Stage bindStage;
	public StartScene startScene;
	
	public ScreenHolder(Stage bindStage) {
		this.bindStage = bindStage;
	}
	
	public void initialize() {
		startScene = new StartScene();
		switchScreen(startScene);
	}
	
	
	public void switchScreen(Scene nextScreen) {
		bindStage.setResizable(false);
		bindStage.setScene(nextScreen);
		bindStage.sizeToScene();
	}
	
}
