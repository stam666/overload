package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import main.GameLogic;
import sharedObject.IRenderable;
import sharedObject.IUpdatable;
import sharedObject.ImageHolder;
import sharedObject.RenderableHolder;

public class Ring extends Entity implements IUpdatable {

	private FrontRing front;
	private RearRing rear;
	private boolean isGold;
	private boolean isMoveRight, isMoveLeft, isMoveUp, isMoveDown;
	private double desX, desY;
	private double speed = 5.0D;

	public Ring(int z) {
		setSprite(ImageHolder.getInstance().ring);
		setZ(z);;
		//setVisible(false);
		setFront(new FrontRing(z));
		setRear(new RearRing(z));
		setMoveRight(false);
		setMoveLeft(false);
		setMoveUp(false);
		setMoveDown(false);
		isGold = false;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		if (isMoveRight) {
			if (Math.abs(desX - getX()) > speed) {
				setX(getX() + speed);
				getFront().setX(getFront().getX() + speed);
				getRear().setX(getRear().getX() + speed);
			} else {
				setX(desX);
				getFront().setX(desX);
				getRear().setX(desX);
				setMoveRight(false);
			}
		} else if (isMoveLeft) {
			if (Math.abs(desX - getX()) > speed) {
				setX(getX() - speed);
				getFront().setX(getFront().getX() - speed);
				getRear().setX(getRear().getX() - speed);
			} else {
				setX(desX);
				getFront().setX(desX);
				getRear().setX(desX);
				setMoveLeft(false);
			}
		}
		if (isMoveDown) {
			if (Math.abs(desY - getY()) > speed) {
				setY(getY() + speed);
				getFront().setY(getFront().getY() + speed);
				getRear().setY(getRear().getY() + speed);
			} else {
				setY(desY);
				getFront().setY(desY);
				getRear().setY(desY);
				setMoveDown(false);
			}
		} else if (isMoveUp) {
			if (Math.abs(desY - getY()) > speed) {
				setY(getY() - speed);
				getFront().setY(getFront().getY() - speed);
				getRear().setY(getRear().getY() - speed);
			} else {
				setY(desY);
				getFront().setY(desY);
				getRear().setY(desY);
				setMoveUp(false);
			}
		}
		
		getFront().setX(this.getX());
		getRear().setX(this.getX());
		getFront().setY(this.getY());
		getRear().setY(this.getY());
	}
	
	public void initialSubRing() {
		front = new FrontRing(getZ());
		front.setX(getX());
		front.setY(getY());
		rear =  new RearRing(getZ());
		rear.setX(getX());
		rear.setY(getY());
		setFront(front);
		setRear(rear);
		
		RenderableHolder.getInstance().add(front);
		RenderableHolder.getInstance().add(rear);
	}
	
	public void initializeMove(double y) {
		moveY(y, "down");
	}
	
	public void moveX(double x, String dir) {
		if (dir.toString().equals("right")) {
			setMoveRight(true);
			desX = getX() + x;
		} else if (dir.toString().equals("left")) {
			setMoveLeft(true);
			desX = getX() - x;
		}
	}
	
	public void moveY(double y, String dir) {
		if (dir.toString().equals("up")) {
			setMoveUp(true);
			desY = getY() - y; 
		} else if (dir.toString().equals("down")) {
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

	public FrontRing getFront() {
		return front;
	}

	public RearRing getRear() {
		return rear;
	}

	public void setFront(FrontRing front) {
		this.front = front;
	}

	public void setRear(RearRing rear) {
		this.rear = rear;
	}
	
}
