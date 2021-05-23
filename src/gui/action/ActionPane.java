package gui.action;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import player.SubPlayer;
import sharedObject.Constants;
import sharedObject.FontHolder;

public class ActionPane extends VBox {
	private int mode;
	private RollDicePane rollDice;
	private ChoosePolePane choosePole;
	private ChooseNumberPane chooseNumber;
	private PlayerAtSameActionPane atSame;

	public ActionPane() {
		this.mode = 0;
		this.setAlignment(Pos.CENTER);
		int width = 1024, height = 256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.getStylesheets().add(ClassLoader.getSystemResource("styleSheet.css").toString());
		// this.setStyle("-fx-background-color: linear-gradient(#adff2f, #B06AB3);");
	}

	public void changeMode(int mode) {
		this.mode = mode;
		this.getChildren().clear();
		if (this.mode == Constants.rollDice) {
			// rollDice//update
			this.rollDice = new RollDicePane();
			this.getChildren().addAll(Label(Constants.rollDice), this.rollDice);
		} else if (this.mode == Constants.choosePole) {
			// choosePole

			this.choosePole = new ChoosePolePane();
			this.getChildren().addAll(Label(Constants.choosePole), this.choosePole);
		} else if (this.mode == Constants.chooseNumber) {
			// ChooseNumber

			this.chooseNumber = new ChooseNumberPane();
			this.getChildren().addAll(Label(Constants.chooseNumber), this.chooseNumber);
		}
	}

	public void changeModeAtSame(int mode, ArrayList<SubPlayer> targets, Boolean amLeft) {
		this.mode = mode;
		this.getChildren().clear();
		if (this.mode == Constants.atSame) {
			this.atSame = new PlayerAtSameActionPane(targets, amLeft);
			this.getChildren().addAll(Label(4), this.atSame);
		}
	}

	public void update() {
		if (this.mode == Constants.rollDice) {
			this.rollDice.update();
		}
	}

	public void updateAtSame(ArrayList<SubPlayer> targets, Boolean amLeft) {
		if (this.mode == Constants.atSame) {
			this.atSame.update(targets, amLeft);
		}
	}

	private HBox Label(int action) {
		HBox labelPane = new HBox();
		Label label = new Label();
		int width = 1024, height = 56;
		labelPane.setMinWidth(width);
		labelPane.setMaxWidth(height);
		labelPane.setMinHeight(height);
		labelPane.setMaxHeight(height);
		label.setFont(FontHolder.getInstance().gameFont_40);
		String direction = "";
		if (action == Constants.rollDice) {
			direction = "Roll Dice";
		} else if (action == Constants.choosePole) {
			direction = "Choose Pole You Want to Play";
		} else if (action == Constants.chooseNumber) {
			direction = "How Many Rings You Want to Add ?";
		} else if (action == Constants.atSame) {
			// AtSame
			direction = "Select Getting from/Giving to Each Pole";
		}
		labelPane.setAlignment(Pos.CENTER);
		label.textProperty().setValue(direction);
		labelPane.getChildren().add(label);
		return labelPane;
	}

	public int getMode() {
		return mode;
	}

}
