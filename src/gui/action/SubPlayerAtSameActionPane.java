package gui.action;


import gui.score.PlayerPole;
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

public class SubPlayerAtSameActionPane extends HBox{
	private boolean amLeft;
	private SubPlayer target;
	private Button recieveButton;
	private Button giveButton;
	public SubPlayerAtSameActionPane(int idx,SubPlayer target,Boolean amLeft) {
		this.amLeft=amLeft;
		this.target=target;
		this.setAlignment(Pos.CENTER);
		int width=102,height=200;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(25);
		Canvas canvas = new Canvas(100,50);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		if(this.target.getColor().equals("RED")) {
			gc.setFill(javafx.scene.paint.Color.RED);
		}
		gc.fillRect(0, 0, 100, 50);
		this.getChildren().add(canvas);
		//////////////////////////////////////////////////////////
		recieveButton = new Button("I recieve from this");
		recieveButton.setPrefSize(100, 25);
		recieveButton.setOnAction((ActionEvent event) -> {
			InputUtility.setAtSameAction(idx, 1);
		});
		this.getChildren().add(recieveButton);
		//////////////////////////////////////////////////////////////////////
		giveButton = new Button("I give to this");
		giveButton.setPrefSize(100, 25);
		giveButton.setOnAction((ActionEvent event) -> {
			InputUtility.setAtSameAction(idx, 2);
		});
		this.getChildren().add(giveButton);
		
		if(this.target.getRings()==0) {
			recieveButton.setDisable(true);
		}
		if(!this.amLeft) {
			giveButton.setDisable(true);
		}
	}
	
	public void update(Boolean amLeft) {
		this.amLeft=amLeft;
		if(!this.amLeft) {
			giveButton.setDisable(true);
		}else {
			giveButton.setDisable(true);
		}
	}
}
