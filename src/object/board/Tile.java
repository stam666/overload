package object.board;

import javafx.scene.canvas.GraphicsContext;
import object.base.GameObject;
import sharedObject.ImageHolder;

public class Tile extends GameObject {

	public Tile() {
		setZ(-999);
		setSprite(ImageHolder.getInstance().tile);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		
	}
}
