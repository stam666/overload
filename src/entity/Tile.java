package entity;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageHolder;

public class Tile extends Entity {
	
	private Pole pole;

	public Tile() {
		setZ(-999);
		setSprite(ImageHolder.getInstance().tile);
		setPole(null);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}

	public Pole getPole() {
		return pole;
	}

	public void setPole(Pole pole) {
		this.pole = pole;
	}
}
