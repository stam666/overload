package actionPane;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sharedObject.FontHolder;

public class ActionPane extends VBox {
	public ActionPane(int action) {
		this.setAlignment(Pos.CENTER);
		int width=1024,height=256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		if(action==1) {
			//rollDice
			this.getChildren().addAll(Label(1),new RollDicePane());
		}else if(action==2) {
			//choosePole
			
		}else if(action==3) {
			//ChooseNumber
			this.getChildren().addAll(Label(3),new ChooseNumberPane());
		}else if(action==4) {
			//AtSame
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
