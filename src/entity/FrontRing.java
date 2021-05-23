package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import sharedObject.IRenderable;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class FrontRing extends Entity {
	
	private boolean isGold;
	private WritableImage frontRing;
	private WritableImage frontRingGold;
	
	public FrontRing(int z) {
		setZ(z);
		Image ring = ImageHolder.getInstance().ring;
		Image ringGold = ImageHolder.getInstance().ringGold;
		int w = (int) ring.getWidth();
		int h = (int) ring.getHeight();
		
		PixelReader ringReader = ring.getPixelReader();
		PixelReader ringGoldReader = ringGold.getPixelReader();
		WritableImage frontRing = new WritableImage(ringReader, 0, h / 2, w, h/2);
		WritableImage frontRingGold = new WritableImage(ringGoldReader, 0, h / 2, w, h/2);
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (isGold) {
			gc.drawImage(frontRingGold , getX(), getY(), getSprite().getWidth(), getSprite().getHeight());
		} else {
			gc.drawImage(frontRing , getX(), getY(), getSprite().getWidth(), getSprite().getHeight());
		}
		
	}

	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}
	
}

