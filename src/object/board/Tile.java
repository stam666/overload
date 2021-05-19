package object.board;

import javafx.scene.canvas.GraphicsContext;
import object.base.GameObject;
import sharedObject.ImageHolder;

public class Tile extends GameObject {
	
	private int i;

	public Tile() {
		setZ(-999);
		setSprite(ImageHolder.getInstance().floor);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		
	}
}
