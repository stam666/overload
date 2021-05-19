package gui.score;

import sharedObject.FontHolder;
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
	public PlayerPane(int idx,Player player) {
		this.setAlignment(Pos.CENTER);
		int width=200,height=256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(15);
		
		this.playerName = new Label();
		this.playerName.setFont(FontHolder.getInstance().gameFont_40); 
		this.playerName.textProperty().setValue(player.getName());
		
		this.point = new Label();
		this.point.setFont(FontHolder.getInstance().gameFont_50); 
		this.point.textProperty().setValue(Integer.toString(player.getPoint()));
		
		this.poleDisplay = new PlayerPole(idx,player);
		//this.poleDisplay = new PlayerPole(player.getSub().get(0).getCounter(),player.getSub().get(1).getCounter());
		this.getChildren().addAll(this.playerName,this.poleDisplay,this.point);
		
	}
}
