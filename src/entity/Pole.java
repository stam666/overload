package entity;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.ImageHolder;

public class Pole extends Entity {
	
	private List<Ring> ringStack;
	private int ringCount;
	private boolean isFull;

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
		setRingCount(0);
		setFull(false);
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		update();
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		if (ringCount > 8) {
			setFull(true);
		} else {
			setFull(false);
		}
	}
	
	public void move() {
		
	}
	
	public void addNewRing() {
		Ring newRing = new Ring();
		ringStack.add(newRing);
		this.ringCount += 1;
	}
	
	public void setRingStack(List<Ring> ringStack) {
		this.ringStack = ringStack;
	}

	public int getRingCount() {
		return ringCount;
	}

	public void setRingCount(int ringCount) {
		this.ringCount = ringCount;
	}

	public List<Ring> getRingStack() {
		return ringStack;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

}
