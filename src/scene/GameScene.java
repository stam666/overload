package scene;

import java.util.ArrayList;
import java.util.List;

import gui.game.GameScreen;
import gui.game.GameScreen1;
import gui.start.StartScreen;
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import main.logic;
import player.Player;
import player.SubPlayer;
import sharedObject.Constants;

public class GameScene extends Scene {

	private GameScene(Parent root) {
		super(root);
	}

	public GameScene() {
		this((Parent) new GameScreen());
	
	}
}