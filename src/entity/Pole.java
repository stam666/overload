package entity;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class Pole extends Entity {
	
	private List<Ring> ringStack;
	private int stackCount;

	public Pole(String color) {
		if (color.equals("darkBLUE")) {
			setSprite(ImageHolder.getInstance().darkBluePole);
		} else if (color.equals("darkGREEN")) {
			setSprite(ImageHolder.getInstance().darkGreenPole);
		} else if (color.equals("darkPINK")) {
			setSprite(ImageHolder.getInstance().darkPinkPole);
		} else if (color.equals("darkRED")) {
			setSprite(ImageHolder.getInstance().darkRedPole);
		} else if (color.equals("darkYELLOW")) {
			setSprite(ImageHolder.getInstance().darkYellowPole);
		} else if (color.equals("lightBLUE")) {
			setSprite(ImageHolder.getInstance().lightBluePole);
		} else if (color.equals("lightGREEN")) {
			setSprite(ImageHolder.getInstance().lightGreenPole);
		} else if (color.equals("lightPINK")) {
			setSprite(ImageHolder.getInstance().lightPinkPole);
		} else if (color.equals("lightRED")) {
			setSprite(ImageHolder.getInstance().lightRedPole);
		} else if (color.equals("lightYELLOW")) {
			setSprite(ImageHolder.getInstance().lightYellowPole);
		}		

		List<Ring> ringStack = new ArrayList<>(7);
		setStackCount(0);
	
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	public void setRing(Ring ring) {
		ring.setZ(getZ() + stackCount);
		ring.setCenterX(getCenterX());
		ring.setCenterY(getY() + getHeight() * 4.0D / 5.62D - ring.getHeight() * stackCount * 45.0D / 165.0D);
		this.ringStack.add(ring);
		stackCount += 1;
	}
	
	public void setRingStack(List<Ring> ringStack) {
		this.ringStack = ringStack;
	}

	public int getStackCount() {
		return stackCount;
	}

	public void setStackCount(int ringCount) {
		this.stackCount = ringCount;
	}

	public List<Ring> getRingStack() {
		return ringStack;
	}

}
