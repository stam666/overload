package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.ImageHolder;

public class FrontRing extends Entity {

	private boolean isGold;
	private Image ring = ImageHolder.getInstance().frontRing;
	private Image goldRing = ImageHolder.getInstance().frontGoldRing;
	private double gap = 5.688888888888889D;

	public FrontRing(int z) {
		setSprite(ImageHolder.getInstance().frontRing);
		setGold(false);
		setZ(z);
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (isGold) {
			gc.drawImage(goldRing, getX(), getY() + gap, getWidth(), getHeight());
		} else {
			gc.drawImage(ring, getX(), getY() + gap, getWidth(), getHeight());
		}
	}

	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}

}
