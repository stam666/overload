package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import main.GameLogic;
import sharedObject.IRenderable;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;
import sharedObject.RenderableHolder;

public class RearRing extends Entity {
	
	private boolean isGold;
	private Image ring = ImageHolder.getInstance().rearRing;
	private Image goldRing = ImageHolder.getInstance().rearGoldRing; 
	
	public RearRing(int z) {
		setSprite(ImageHolder.getInstance().rearRing);
		setGold(false);
		setZ(z - 10);
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (isGold) {
			gc.drawImage(goldRing , getX(), getY(), getWidth() , getHeight());
		} else {
			gc.drawImage(ring , getX(), getY(), getWidth() , getHeight());
		}
	}
	
	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}
	
}
