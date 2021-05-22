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

		Image imagePole =ImageHolder.getInstance().ring;
		int w = (int) imagePole.getWidth();
		int h = (int) imagePole.getHeight();
		
		PixelReader reader = imagePole.getPixelReader();
		WritableImage rearPole = new WritableImage(reader, 0, 0, w, h/2);
		setSprite(rearPole);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getSprite().getWidth(), getSprite().getHeight());
		
	}
}
