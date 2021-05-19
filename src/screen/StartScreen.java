package screen;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import sharedObject.FontHolder;
import sharedObject.ImageHolder;

public class StartScreen extends VBox {
	Button playButton,exitButton;
	public StartScreen() {
		//this.setAlignment(Pos.CENTER);
		int width=1024,height=768;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		Canvas canvas = new Canvas(1024,768);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawBackground(gc);
		this.getChildren().add(canvas);
		playButton=new Button("Play");
		playButton.setFont(FontHolder.getInstance().gameFont_50);
		playButton.setPrefSize(150,100);
		exitButton=new Button("Exit");
		this.getChildren().addAll(playButton,exitButton);
	}
	private void drawBackground(GraphicsContext gc) {
		gc.drawImage(ImageHolder.getInstance().startBackground, 0, 0,1024,768);
		gc.drawImage(ImageHolder.getInstance().bluePole1D.get(8),100, 57,124,180);
		gc.setFont(FontHolder.getInstance().gameFont_200);
		gc.setFill(Color.BLUE);
		gc.setStroke(Color.WHITE);
		gc.fillText("Overload",306,190 );
	//	gc.setLineWidth(2);
		gc.strokeText("Overload",306,190 );
	}
}
