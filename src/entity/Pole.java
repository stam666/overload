package entity;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.ImageHolder;

public class Pole extends Entity {
	
	private List<Ring> ringStack;
	private int ring;

	public Pole(String color) {
		if (color == "blue") {
			setSprite(ImageHolder.getInstance().bluePole);
		} else if (color == "green") {
			setSprite(ImageHolder.getInstance().greenPole);
		} else if (color == "pink") {
			setSprite(ImageHolder.getInstance().pinkPole);
		} else if (color == "red") {
			setSprite(ImageHolder.getInstance().redPole);
		} else if (color == "yellow") {
			setSprite(ImageHolder.getInstance().yellowPole);
		}

		List<Ring> ringStack = new ArrayList<>(7);
		setRing(0);
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	
	public void update() {}

	public List<Ring> getRingStack() {
		return ringStack;
	}

	public void setRingStack(List<Ring> ringStack) {
		this.ringStack = ringStack;
	}

	public int getRing() {
		return ring;
	}
	
	public void setRing(int ring) {
		this.ring = ring;
	}

	public void addRing(int ring) {
		ring += 1;
	}
	
	public void removeRing(int ring) {
		ring -= 1;
	}

}
