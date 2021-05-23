package gui.action;

import java.util.Random;

import input.InputUtility;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import sharedObject.AudioHolder;
import sharedObject.FontHolder;
import javafx.event.ActionEvent;

public class RollDicePane extends HBox {
	private int nowNumber,count;
	private Random ran = new Random();
	private Button stopButton;
	private static final int[] number= {1,2,3,4,5};
	public RollDicePane() {
		this.setAlignment(Pos.CENTER);
		int width = 1024, height = 180;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(15);
		this.nowNumber = number[count];
		stopButton = new Button(String.valueOf(this.nowNumber));
		stopButton.setFont(FontHolder.getInstance().gameFont_100);
		stopButton.setPrefSize(150, 150);
		stopButton.setOnAction((ActionEvent event) -> {
			AudioHolder.getInstance().playPressed();
			InputUtility.setNumberDice(this.nowNumber);
			InputUtility.setStopDice(true);
		});
		this.getChildren().addAll(stopButton);
	}

	public void update() {
		if (!InputUtility.isStopDice()) {
			count+=1;count%=5;
			this.nowNumber = number[count];
		}
		stopButton.setText(String.valueOf(this.nowNumber));
		/*
		 * gc.setFill(Color.RED); gc.fillRoundRect(50, 50, 100, 100,5,5);
		 * gc.setFill(Color.BLACK); gc.setFont(FontHolder.getInstance().gameFont_70);
		 * gc.fillText(String.valueOf(this.nowNumber) ,90 ,115 );
		 */

	}
}
