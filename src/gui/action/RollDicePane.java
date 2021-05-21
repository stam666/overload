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

public class RollDicePane extends HBox{
	private int nowNumber;
	private Random ran = new Random();
	private Button stopButton;
	private Canvas canvas;
	private GraphicsContext gc;
	public RollDicePane() {
		this.setAlignment(Pos.CENTER);
		int width = 1024, height = 200;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setSpacing(15);
		this.nowNumber=ran.nextInt(6)+1;
		this.canvas = new Canvas(200,200);
		this.gc= canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.fillRoundRect(50, 50, 100, 100,5,5);
		gc.setFill(Color.BLACK);
		gc.setFont(FontHolder.getInstance().gameFont_70);
		gc.fillText(String.valueOf(this.nowNumber) ,90, 115 );
		stopButton = new  Button(String.valueOf(this.nowNumber));
		stopButton.setFont(FontHolder.getInstance().gameFont_100);
		stopButton.setPrefSize(150, 150);
		setBtnStyle(stopButton);
		stopButton.setOnAction((ActionEvent event) -> {
			AudioHolder.getInstance().playPressed();
			InputUtility.setNumberDice(this.nowNumber);
			InputUtility.setStopDice(true);
		});
		this.getChildren().addAll(stopButton);
	}
	private void setBtnStyle(Button btn) {
		btn.setId("dice-roll");
		btn.getStylesheets().add(ClassLoader.getSystemResource("styleSheet.css").toString());
	}
	public void update() {
		if(!InputUtility.isStopDice()) {
			this.nowNumber=ran.nextInt(6)+1;
		}
			stopButton.setText(String.valueOf(this.nowNumber));
			/*gc.setFill(Color.RED);
			gc.fillRoundRect(50, 50, 100, 100,5,5);
			gc.setFill(Color.BLACK);
			gc.setFont(FontHolder.getInstance().gameFont_70);
			gc.fillText(String.valueOf(this.nowNumber) ,90 ,115 );*/

	}
}
