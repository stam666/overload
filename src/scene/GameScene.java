package scene;

import gui.game.GameScreen;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {

	private GameScene(Parent root) {
		super(root);
	}

	public GameScene() {
		this((Parent) new GameScreen());

	}
}