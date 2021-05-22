package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class Ring extends Entity {

	private FrontRing front;
	private RearRing rear;
	private boolean isGold;

	public Ring() {
		front =  new FrontRing(getZ());
		front.setCenterX(getCenterX());
		front.setY(getY() + getHeight() * 120.0D / 165.0D);
		rear =  new RearRing(getZ());
		rear.setCenterX(getCenterX());
		rear.setY(getY());
		isGold = false;
	}

	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public void draw(GraphicsContext gc) {
	}

}
