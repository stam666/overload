package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import sharedObject.IRenderable;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class RearRing extends Entity {
	
	private boolean isGold;
	private WritableImage rearRing;
	private WritableImage rearRingGold;
	
	public RearRing(int z) {
		setZ(z - 10);
		Image ring = ImageHolder.getInstance().ring;
		Image ringGold = ImageHolder.getInstance().ringGold;
		int w = (int) ring.getWidth();
		int h = (int) ring.getHeight();
		
		PixelReader ringReader = ring.getPixelReader();
		PixelReader ringGoldReader = ringGold.getPixelReader();
		WritableImage rearRing = new WritableImage(ringReader, 0, 0, w, h/2);
		WritableImage rearRingGold = new WritableImage(ringGoldReader, 0, 0, w, h/2);
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (isGold) {
			gc.drawImage(rearRingGold , getX(), getY(), getSprite().getWidth(), getSprite().getHeight());
		} else {
			gc.drawImage(rearRing , getX(), getY(), getSprite().getWidth(), getSprite().getHeight());
		}
	}
	
	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}
	
}
