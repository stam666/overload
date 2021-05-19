package scoreboard;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import player.Player;
import scoreboard.PlayerPane;
public class ScoreboardPane extends HBox {
	private ArrayList<PlayerPane> playerPanes;
	private ArrayList<Player> players;
	public ScoreboardPane(ArrayList<Player> players) {
		this.players=players;
		int width=1024,height=256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.playerPanes = new ArrayList<PlayerPane>();
		int count=0;
		for(Player e :this.players) {
			playerPanes.add(new PlayerPane(count,e));
			count++;
		}
		for(VBox e :playerPanes) {
			this.getChildren().add(e);
		}
	}
	public void update() {
		this.getChildren().clear();
		this.playerPanes.clear();
		int count=0;
		for(Player e :players) {
			playerPanes.add(new PlayerPane(count,e));
			count++;
		}
		for(VBox e :playerPanes) {
			this.getChildren().add(e);
		}
	}
}
