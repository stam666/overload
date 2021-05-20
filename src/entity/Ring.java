package entity;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageHolder;

public class Ring extends Entity{
	
	private int state;
	
	public Ring() {
		setSprite(ImageHolder.getInstance().ring.get(1));
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
