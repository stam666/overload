package entity;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageHolder;

public class Tile extends Entity {
	
	private Pole pole;
	private int zForEntity;

	public Tile(int zForEntity) {
		this.zForEntity = zForEntity;
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

	public int getzForEntity() {
		return zForEntity;
	}

	public void setzForEntity(int zForEntity) {
		this.zForEntity = zForEntity;
	}
	
}
