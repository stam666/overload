package entity;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageHolder;

public class Tile extends Entity {

	private int zForEntity;

	public Tile(int zForEntity) {
		this.zForEntity = zForEntity;
		setZ(-999);
		setSprite(ImageHolder.getInstance().tile);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}

	public int getzForEntity() {
		return zForEntity;
	}

	public void setzForEntity(int zForEntity) {
		this.zForEntity = zForEntity;
	}

}
