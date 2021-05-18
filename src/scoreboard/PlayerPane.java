package scoreboard;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import player.Player;

public class PlayerPane extends VBox{
	private Label playerName;
	private PlayerPole poleDisplay;
	private Label point;
	public PlayerPane(Player player) {
		this.setAlignment(Pos.CENTER);
		int width=256,height=256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(15);
		
		this.playerName = new Label();
		this.playerName.setFont(Font.font("Arial",25)); 
		this.playerName.textProperty().setValue(player.getName());
		
		this.point = new Label();
		this.point.setFont(Font.font("Arial",30)); 
		this.point.textProperty().setValue(Integer.toString(player.getPoint()));
		
		this.poleDisplay = new PlayerPole();
		//this.poleDisplay = new PlayerPole(player.getSub().get(0).getCounter(),player.getSub().get(1).getCounter());
		this.getChildren().addAll(this.playerName,this.poleDisplay,this.point);
		
	}
}
