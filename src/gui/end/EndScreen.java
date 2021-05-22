package gui.end;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import sharedObject.FontHolder;
import sharedObject.ImageHolder;

public class EndScreen extends StackPane{
	public EndScreen(String name) {
		this.setAlignment(Pos.BOTTOM_CENTER);
		int width = 1024, height = 768;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		Canvas canvas = new Canvas(1024, 768);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawBackground(gc,name);
		this.getChildren().add(canvas);
		ButtonEnd button = new ButtonEnd();
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

	private void drawBackground(GraphicsContext gc,String name) {
		gc.drawImage(ImageHolder.getInstance().endBackground, 0, 0, 1024, 768);
		gc.setFont(FontHolder.getInstance().gameFont_200);
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.BLACK);
		gc.fillText(name, 270+30, 360);
		// gc.setLineWidth(2);
		gc.strokeText(name, 270+30, 360);
		//gc.setFont(FontHolder.getInstance().gameFont_150);
		gc.fillText("wins",460, 490);
		gc.strokeText("wins", 460, 490);
	}
}
