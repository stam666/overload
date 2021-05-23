package gui.score;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.GameLogic;
import player.Player;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class PlayerPole extends Pane implements IUpdatable {
	private int idx;
	private Player player;

	public PlayerPole(int idx, Player player) {
		this.idx = idx;
		this.player = player;
		Canvas canvas = new Canvas(200, 130);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		if (GameLogic.getNowState() >= 3 && GameLogic.getPlayer().getName().equals(player.getName())) {
			gc.setFill(Color.GOLD);
			if (GameLogic.getNowSubPlayer().getIdx() == 0) {
				gc.fillRoundRect(6, 0, 90, 130, 15, 15);
			} else if (GameLogic.getNowSubPlayer().getIdx() == 1) {
				gc.fillRect(102, 0, 90, 130);
			}
		}
		draw(gc, player.getSub().get(0).get1D(), 6, 0);
		draw(gc, player.getSub().get(1).get1D(), 102, 0);

		this.getChildren().add(canvas);

	}

	private void draw(GraphicsContext gc, Image img, int x, int y) {
		gc.drawImage(img, x, y, 90, 130);
	}

	public void update() {
		this.getChildren().clear();
		Canvas canvas = new Canvas(200, 130);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		if (GameLogic.getNowState() >= 3 && GameLogic.getPlayer().getName().equals(player.getName())) {
			gc.setFill(Color.GOLD);
			if (GameLogic.getNowSubPlayer().getIdx() == 0) {
				gc.fillRoundRect(6, 0, 90, 130, 15, 15);
			} else if (GameLogic.getNowSubPlayer().getIdx() == 1) {
				gc.fillRect(102, 0, 90, 130);
			}
		}
		draw(gc, player.getSub().get(0).get1D(), 6, 0);
		draw(gc, player.getSub().get(1).get1D(), 102, 0);
		this.getChildren().add(canvas);
	}
}
