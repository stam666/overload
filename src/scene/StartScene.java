package scene;

import gui.start.StartScreen;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StartScene extends Scene {
	private StartScreen start;

	private StartScene(Parent root) {
		super(root);
	}

	public StartScene() {
		this((Parent) new StartScreen());
		//initialize();
	}

	private void initialize() {
		// setCursor(Cursor.NONE);
		setRoot((Parent) (this.start = new StartScreen()));
		// this.start.setPrefSize(1024.0D, 768.0D);
		// this.start.getChildren().addAll((Object[])new Node[] { (Node)new
		// MainMenuGUI() });
	}
}
