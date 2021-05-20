package entity;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageHolder;

public class Ring extends Entity{
	
	public Ring() {
		setSprite(ImageHolder.getInstance().ring.get(1));
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	
}
