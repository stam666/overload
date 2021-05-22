package entity;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class Ring extends Entity implements IUpdatable {
	
	private boolean isGold;
	
	public Ring() {
		isGold = false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}

	public void update() {
		if (isGold) {
			setSprite(ImageHolder.getInstance().ring.get(0));
		} else {
			setSprite(ImageHolder.getInstance().ring.get(1));
		}
	}
		
	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}

}
