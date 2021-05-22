package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import sharedObject.IRenderable;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class FrontRing extends Entity {
	
	public FrontRing(int z) {
		setZ(z);
		
		Image imagePole =ImageHolder.getInstance().ring;
		int w = (int) imagePole.getWidth();
		int h = (int) imagePole.getHeight();
		
		PixelReader reader = imagePole.getPixelReader();
		WritableImage frontPole = new WritableImage(reader, 0, h / 2, w, h/2);
		setSprite(frontPole);
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image imagePole = getSprite();
		int w = (int) imagePole.getWidth();
		int h = (int) imagePole.getHeight();
		
		PixelReader reader = imagePole.getPixelReader();
		WritableImage frontPole = new WritableImage(reader, 0, h / 2, w, h/2);
		setSprite(frontPole);
		gc.drawImage(getSprite(), getX(), getY(), getSprite().getWidth(), getSprite().getHeight());
	}
}

