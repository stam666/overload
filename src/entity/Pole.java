package entity;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class Pole extends Entity implements IUpdatable {
	
	private List<Ring> ringStack;
	private int ringCount;
	private boolean isFull;

	public Pole(String color) {
		if (color == "darkBlue") {
			setSprite(ImageHolder.getInstance().darkBluePole);
		} else if (color == "darkGreen") {
			setSprite(ImageHolder.getInstance().darkGreenPole);
		} else if (color == "darkPink") {
			setSprite(ImageHolder.getInstance().darkPinkPole);
		} else if (color == "darkRed") {
			setSprite(ImageHolder.getInstance().darkRedPole);
		} else if (color == "darkYellow") {
			setSprite(ImageHolder.getInstance().darkYellowPole);
		} else if (color == "lightBlue") {
			setSprite(ImageHolder.getInstance().lightBluePole);
		} else if (color == "lightGreen") {
			setSprite(ImageHolder.getInstance().lightGreenPole);
		} else if (color == "lightPink") {
			setSprite(ImageHolder.getInstance().lightPinkPole);
		} else if (color == "lightRed") {
			setSprite(ImageHolder.getInstance().lightRedPole);
		} else if (color == "lightYellow") {
			setSprite(ImageHolder.getInstance().lightYellowPole);
		}		

		List<Ring> ringStack = new ArrayList<>(7);
		setRingCount(0);
		setFull(false);
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		if (ringCount > 8) {
			setFull(true);
		} else {
			setFull(false);
		}
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
