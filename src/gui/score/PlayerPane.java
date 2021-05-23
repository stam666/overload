package gui.score;

import sharedObject.FontHolder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.GameLogic;
import main.logic;
import player.Player;

public class PlayerPane extends VBox {
	private Label playerName;
	private PlayerPole poleDisplay;
	private Label point;
	private Player player;
	private int idx;

	public PlayerPane(int idx, Player player) {
		this.player = player;
		this.idx = idx;
		this.setAlignment(Pos.CENTER);
		int width = 200, height = 256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(15);
		if (GameLogic.getPlayer().getName().equals(player.getName())) {
			this.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		this.playerName = new Label();
		this.playerName.setFont(FontHolder.getInstance().gameFont_40);
		this.playerName.textProperty().setValue(player.getName());

		this.point = new Label();
		this.point.setFont(FontHolder.getInstance().gameFont_50);
		this.point.textProperty().setValue(Integer.toString(player.getPoint()));

		this.poleDisplay = new PlayerPole(idx, player);

		this.getChildren().addAll(this.playerName, this.poleDisplay, this.point);

	}

	public void update() {
		this.point.textProperty().setValue(Integer.toString(player.getPoint()));
		this.poleDisplay.update();
		if (GameLogic.getPlayer().getName().equals(player.getName())) {
			this.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		} else {
			this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}
}
