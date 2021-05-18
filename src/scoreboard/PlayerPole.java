package scoreboard;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class PlayerPole extends Pane{
	public PlayerPole() {
		Canvas canvas = new Canvas(256,130);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		String img_path=ClassLoader.getSystemResource("res/test.jpg").toString();
		draw(gc,img_path,0,0);
		draw(gc,img_path,128,0);
		this.getChildren().add(canvas);
		
	}
	private void draw(GraphicsContext gc,String img_path,int x,int y) {
		Image pole= new Image(img_path);
		gc.drawImage(pole, x, y,128,130);
	}
}
