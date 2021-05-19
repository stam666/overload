package gui.action;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import player.SubPlayer;
import sharedObject.FontHolder;

public class ActionPane extends VBox {
	private int mode;
	private RollDicePane rollDice;
	private ChoosePolePane choosePole;
	private ChooseNumberPane chooseNumber;
	private PlayerAtSameActionPane atSame;
	public ActionPane() {
		this.mode=0;
		this.setAlignment(Pos.CENTER);
		int width=1024,height=256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		
	}
	public void changeMode(int mode) {
		this.mode=mode;
		this.getChildren().clear();
		if(this.mode==1) {
			//rollDice//update
			this.rollDice=new RollDicePane();
			this.getChildren().addAll(Label(1),this.rollDice);
		}else if(this.mode==2) {
			//choosePole
			this.choosePole=new ChoosePolePane();
			this.getChildren().addAll(Label(2),this.choosePole);
		}else if(this.mode==3) {
			//ChooseNumber
			this.chooseNumber=new ChooseNumberPane();
			this.getChildren().addAll(Label(3),this.chooseNumber);
		}
	}
	public void changeModeAtSame(int mode,ArrayList<SubPlayer> targets,Boolean amLeft) {
		this.mode=mode;
		this.getChildren().clear();
		if(this.mode==4) {
			this.atSame=new PlayerAtSameActionPane(targets, amLeft);
			this.getChildren().addAll(Label(4),this.atSame);
		}
	}
	public void update() {
		if(this.mode==1) {
			this.rollDice.update();
		}
	}
	public void updateAtSame(ArrayList<SubPlayer> targets,Boolean amLeft) {
		if(this.mode==4) {
			this.atSame.update(targets,amLeft);
		}
	}
	private HBox Label(int action) {
		HBox labelPane= new HBox();
		Label label = new Label();
		int width=1024,height=56;
		labelPane.setMinWidth(width);
		labelPane.setMaxWidth(height);
		labelPane.setMinHeight(height);
		labelPane.setMaxHeight(height);
		label.setFont(FontHolder.getInstance().gameFont_40); 
		String direction = "";
		if(action==1) {
			direction="Roll Dice";
		}else if(action==2) {
			direction="Choose Pole You Want to Play";
		}else if(action==3) {
			direction="How Many Rings You Want to Add to Your Pole ?";
		}else if(action==4) {
			//AtSame
			direction="Select Player for Giving from/Sending to?";
		}
		labelPane.setAlignment(Pos.CENTER);
		label.textProperty().setValue(direction);
		labelPane.getChildren().add(label);
		return labelPane;
	}
}
