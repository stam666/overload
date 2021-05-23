package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import sharedObject.IRenderable;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class RearRing extends Entity {
	
	public RearRing(int z) {
		setZ(z - 10);
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image imagePole = getSprite();
		
		int w = (int) imagePole.getWidth();
		int h = (int) imagePole.getHeight();
		PixelReader reader = imagePole.getPixelReader();
		WritableImage rearPole = new WritableImage(reader, 0, 0, w, h/2);
		setSprite(rearPole);
		gc.drawImage(getSprite(), getX(), getY(), getSprite().getWidth(), getSprite().getHeight());
	}
	
	public void update() {
		
	}
}
