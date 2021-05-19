package gui.game;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class GameScreen extends VBox{
	public GameScreen() {
		int width = 1024, height = 768;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
	  
	}
}

