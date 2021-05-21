package entity;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class Ring extends Entity implements IUpdatable {
	
	private int state;
	
	public Ring() {
		state = 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}

	public void update() {
		if (state == 0) {
			setSprite(ImageHolder.getInstance().ring.get(0));
		} else if (state == 1) {
			setSprite(ImageHolder.getInstance().ring.get(1));
		} else if (state == 2) {
			setSprite(ImageHolder.getInstance().ring.get(2));
		}
	}
		
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
