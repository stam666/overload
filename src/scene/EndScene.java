package scene;

import gui.end.EndScreen;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EndScene extends Scene {
	private EndScreen end;

	private EndScene(Parent root) {
		super(root);
	}

	public EndScene(String name) {
		this((Parent) new EndScreen(name));
	}

}
