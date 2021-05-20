package scene;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneHolder {
	private Stage bindStage;
	public StartScene startScene;
	
	public SceneHolder(Stage bindStage) {
		this.bindStage = bindStage;
	}
	
	public void initialize() {
		startScene = new StartScene();
		switchScene(startScene);
	}
	
	
	public void switchScene(Scene nextScene) {
		bindStage.setResizable(false);
		bindStage.setScene(nextScene);
		bindStage.sizeToScene();
	}
	
}
