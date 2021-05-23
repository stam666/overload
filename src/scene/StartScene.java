package scene;

import gui.start.StartScreen;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StartScene extends Scene {

	private StartScene(Parent root) {
		super(root);
	}

	public StartScene() {
		this((Parent) new StartScreen());
	}

}
