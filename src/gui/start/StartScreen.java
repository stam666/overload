package gui.start;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import sharedObject.FontHolder;
import sharedObject.ImageHolder;

public class StartScreen extends StackPane {

	public StartScreen() {
		this.setAlignment(Pos.BOTTOM_CENTER);
		int width = 1024, height = 768;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		Canvas canvas = new Canvas(1024, 768);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawBackground(gc);
		this.getChildren().add(canvas);
		ButtonStart button = new ButtonStart();
		this.getChildren().add(button);
		/*Media media = new Media(ClassLoader.getSystemResource("effectButtonPressed.mp3").toString());
		MediaPlayer mediaPlayer1 = new MediaPlayer(media);
		mediaPlayer1.setOnEndOfMedia(new Runnable() {
		       public void run() {
		    	   mediaPlayer1.seek(Duration.ZERO);
		       }
		   });
		mediaPlayer1.play();*/

	}

	private void drawBackground(GraphicsContext gc) {
		gc.drawImage(ImageHolder.getInstance().startBackground, 0, 0, 1024, 768);
		gc.drawImage(ImageHolder.getInstance().lightRedPole1D.get(6), 100, 57, 124, 180);
		gc.setFont(FontHolder.getInstance().gameFont_200);
		gc.setFill(Color.BLUE);
		gc.setStroke(Color.WHITE);
		gc.fillText("Overload", 306, 190);
		// gc.setLineWidth(2);
		gc.strokeText("Overload", 306, 190);
	}
}
