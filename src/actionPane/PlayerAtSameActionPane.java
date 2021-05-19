package actionPane;


import java.util.ArrayList;

import input.InputUtility;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import player.Player;
import player.SubPlayer;
import scoreboard.PlayerPole;

public class PlayerAtSameActionPane extends VBox{
	ArrayList<SubPlayer> targets;
	public PlayerAtSameActionPane(ArrayList<SubPlayer> targets,Boolean amLeft) {
		this.targets=targets;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		int width=1024,height=200;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		for(int i=0;i<this.targets.size();i++) {
			SubPlayerAtSameActionPane r = new SubPlayerAtSameActionPane(i,targets.get(i),amLeft);
			
			this.getChildren().add(r);
		}
		Button enterButton =new Button("Enter");
		enterButton.setPrefSize(100,151);
		this.getChildren().add(enterButton);
	}
	
	public void update(ArrayList<SubPlayer> targets,Boolean amLeft) {
		this.getChildren().clear();
		this.targets=targets;
		for(int i=0;i<this.targets.size();i++) {
			SubPlayerAtSameActionPane r = new SubPlayerAtSameActionPane(i,targets.get(i),amLeft);
			this.getChildren().add(r);
		}
	}
}
