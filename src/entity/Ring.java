package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import main.GameLogic;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;

public class Ring extends Entity implements IUpdatable {

	private FrontRing front;
	private RearRing rear;
	private boolean isGold;
	private boolean isMoveRight, isMoveLeft, isMoveUp, isMoveDown;
	private double desX, desY;
	private double speed = 5.0D;

	public Ring(int z) {
		setVisible(false);
		setMoveRight(false);
		setMoveLeft(false);
		setMoveUp(false);
		setMoveDown(false);
		front =  new FrontRing(getZ());
		front.setCenterX(getCenterX());
		front.setY(getY() + getHeight() * 120.0D / 165.0D);
		rear =  new RearRing(getZ());
		rear.setCenterX(getCenterX());
		rear.setY(getY());
		isGold = false;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
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
		
		if (isMoveDown) {
			if (Math.abs(desY - getY()) > speed) {
				setY(getY() + speed);
			} else {
				setY(desY);
				setMoveDown(false);
			}
		} else if (isMoveUp) {
			if (Math.abs(desY - getY()) > speed) {
				setY(getY() - speed);
			} else {
				setY(desY);
				setMoveUp(false);
			}
		}
		
		front.setX(getX());
		front.setY(getY());
		rear.setX(getX());
		rear.setY(getY());
	}
	
	public void initializeMove(double y) {
		desY = getY();
		setY(y);
		setVisible(true);
		moveY(desY, "down");
	}
	
	public void moveX(double x, String dir) {
		if (dir.toString() == "right") {
			setMoveRight(true);
			desX = getX() + x;
		} else if (dir.toString() == "left") {
			setMoveLeft(true);
			desX = getX() - x;
		}
	}
	
	public void moveY(double y, String dir) {
		if (dir.toString() == "up") {
			setMoveUp(true);
			desY = getY() - y; 
		} else if (dir.toString() == "down") {
			setMoveDown(true);
			desY = getY() + y;
		}
	}
	
	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
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

	public boolean isMoveUp() {
		return isMoveUp;
	}

	public void setMoveUp(boolean isMoveUp) {
		this.isMoveUp = isMoveUp;
	}

	public boolean isMoveDown() {
		return isMoveDown;
	}

	public void setMoveDown(boolean isMoveDown) {
		this.isMoveDown = isMoveDown;
	}

	public double getDesX() {
		return desX;
	}

	public void setDesY(double desY) {
		this.desY = desY;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
}
