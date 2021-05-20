package gui.game;

import java.util.ArrayList;

import gui.action.ActionPane;
import gui.score.ScoreboardPane;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import player.Player;
import player.SubPlayer;
import sharedObject.FontHolder;
import sharedObject.ImageHolder;

public class GameScreen extends VBox {
	private ScoreboardPane score;
	private ActionPane action;
	private ArrayList<Player> players;

	public GameScreen(ArrayList<Player> players) {
		this.players = players;
		int width = 1024, height = 768;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.score = new ScoreboardPane(this.players);
		this.action = new ActionPane();
		this.getChildren().addAll(this.score, this.action);
	}

	public void update(Boolean changeAction, int nextAction) {
		this.score.update();
		if (changeAction) {
			this.action.changeMode(nextAction);
		} else {
			this.action.update();
		}
	}

	public void updateAtSame(Boolean changeAction, int nextAction, ArrayList<SubPlayer> targets, Boolean amLeft) {
		this.score.update();
		if (changeAction && nextAction == 4) {
			this.action.changeModeAtSame(nextAction, targets, amLeft);
		} else if (!changeAction) {
			this.action.updateAtSame(targets, amLeft);
		}
	}
}
