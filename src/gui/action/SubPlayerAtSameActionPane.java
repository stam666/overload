package gui.action;




import exception.PlayerNoRingEception;
import exception.TargetNoRingOrPlayerFullException;
import gui.score.PlayerPole;
import input.InputUtility;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import main.GameLogic;
import player.Player;
import player.SubPlayer;
import sharedObject.AudioHolder;
import sharedObject.FontHolder;

public class SubPlayerAtSameActionPane extends VBox{
	private boolean amLeft;
	private SubPlayer target;
	private Button getButton;
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
		this.setSpacing(2);
		Canvas canvas = new Canvas(100,100);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		gc.drawImage(target.get1D(), 15, 0,70,100);
		this.getChildren().add(canvas);
		//////////////////////////////////////////////////////////
		getButton = new Button("GET");//I recieve from this
		getButton.setPrefSize(100, 25);
		getButton.setFont(FontHolder.getInstance().gameFont_20);
		getButton.setOnAction((ActionEvent event) -> {
			AudioHolder.getInstance().playPressed();
			InputUtility.setAtSameAction(idx, sharedObject.Constants.get);
			InputUtility.setAtSameActionEnter(true);
		});
		this.getChildren().add(getButton);
		//////////////////////////////////////////////////////////////////////
		giveButton = new Button("GIVE");
		giveButton.setPrefSize(100, 25);
		giveButton.setFont(FontHolder.getInstance().gameFont_20);
		giveButton.setOnAction((ActionEvent event) -> {
			AudioHolder.getInstance().playPressed();
			InputUtility.setAtSameActionEnter(true);
			InputUtility.setAtSameAction(idx, sharedObject.Constants.give);
		});
		this.getChildren().add(giveButton);
		try {
			if(this.target.getRings()==0 || GameLogic.getNowSubPlayer().getRings()==8) {
				throw new TargetNoRingOrPlayerFullException();
			}
			if(!this.amLeft) {
				throw new PlayerNoRingEception();
				
			}
		}catch(TargetNoRingOrPlayerFullException egnE) {
			System.out.println(egnE.toString());
			getButton.setDisable(true);
		}catch(PlayerNoRingEception egnE) {
			System.out.println(egnE.toString());
			giveButton.setDisable(true);
		}
		
	}
	
	/*public void update(Boolean amLeft) {
		this.amLeft=amLeft;
		
		if(!this.amLeft) {
			giveButton.setDisable(true);
		}else {
			giveButton.setDisable(true);
		}
	}*/
}
