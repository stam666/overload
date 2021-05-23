package entity;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.GameLogic;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;
import sharedObject.RenderableHolder;

public class Pole extends Entity implements IUpdatable {
	
	private double speed = 5.0D;
	private boolean isMoveRight, isMoveLeft;
	private double desX;
	private List<Ring> stackRing;
	private int stackCount;

	public Pole(String color) {
		setMoveRight(false);
		setMoveLeft(false);
		stackRing = new ArrayList<Ring>(8);
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
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		if (isMoveRight) {
			if (Math.abs(desX - getX()) > speed) {
				setX(getX() + speed);
			} else {
				setX(desX);
				setMoveRight(false);
			}
		} else if (isMoveLeft) {
			if (Math.abs(desX - getX()) > speed) {
				setX(getX() - speed);
			} else {
				setX(desX);
				setMoveLeft(false);
			}
		}
	}

	public void move(int n, String dir) {
		if (dir.toString() == "right") {
			setMoveRight(true);
			desX = getX() + n * ImageHolder.getInstance().tile.getWidth() * GameLogic.getFactor() * 345 / 450;
		} else if (dir.toString() == "left") {
			setMoveLeft(true);
			desX = getX() - n * ImageHolder.getInstance().tile.getWidth() * GameLogic.getFactor() * 345 / 450;
		}
	}
	
	public void addRing() {
		Ring newRing = new Ring(getZ() + stackCount);
		newRing.setCenterX(getCenterX());
		newRing.setCenterY(getY() + getHeight() * 4.0D / 5.62D - newRing.getHeight() * stackCount * 45.0D / 165.0D);
		newRing.setVisible(false);
		newRing.initializeMove(getY());
		stackCount += 1;
	}


	public boolean isMoveRight() {
		return isMoveRight;
	}

	public void setMoveRight(boolean isMoveRight) {
		this.isMoveRight = isMoveRight;
	}

	public boolean isMoveLeft() {
		return isMoveLeft;
	}

	public void setMoveLeft(boolean isMoveLeft) {
		this.isMoveLeft = isMoveLeft;
	}

	public double getDesX() {
		return desX;
	}

	public void setDesX(double desX) {
		this.desX = desX;
	}
	
	
	
}
