package entity;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
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
		} else if (color.equals("darkRED")) {
			setSprite(ImageHolder.getInstance().darkRedPole);
		} else if (color.equals("darkYELLOW")) {
			setSprite(ImageHolder.getInstance().darkYellowPole);
		} else if (color.equals("lightBLUE")) {
			setSprite(ImageHolder.getInstance().lightBluePole);
		} else if (color.equals("lightGREEN")) {
			setSprite(ImageHolder.getInstance().lightGreenPole);
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
		double d = ImageHolder.getInstance().tile.getWidth() * GameLogic.getFactor() * 345 / 450;
		if (dir.toString().equals("right")) {
			setMoveRight(true);
			desX = getX() + n * d;
		} else if (dir.toString().equals("left")) {
			setMoveLeft(true);
			desX = getX() - n * d;
		}

		for (Ring ring : stackRing) {
			ring.moveX(n * d, dir);
		}
	}

	public void addRing() {
		Ring newRing = new Ring(getZ() + stackCount + 1);
		// start add top of the pole
		newRing.setCenterX(getCenterX());
		// newRing.setY(getY() + (getHeight() * 3.0D / 5.62D) - (stackCount *
		// newRing.getHeight() * 45.0D / 165.0D));
		newRing.setY(getY() - 30);
		RenderableHolder.getInstance().add(newRing);
		newRing.initialSubRing();

		// animation
		double desY = 30 + (getHeight() * 3.0D / 5.62D) - (stackCount * newRing.getHeight() * 45.0D / 165.0D);
		newRing.moveY(desY, "down");

		stackCount += 1;
		stackRing.add(newRing);

		if (stackCount >= 8) {
			for (Ring ring : stackRing) {
				ring.setGold(true);
			}
		}
	}

	public void removeRing() {
		stackRing.get(stackCount - 1).setDestroyed(true);
		stackRing.get(stackCount - 1).getFront().setDestroyed(true);
		stackRing.get(stackCount - 1).getRear().setDestroyed(true);
		stackRing.remove(stackCount - 1);
		stackCount -= 1;

		if (stackCount < 8) {
			for (Ring ring : stackRing) {
				ring.setGold(false);
			}
		}
	}

	public void moveRing(Pole p) {
		double upY = 30 + stackRing.get(stackCount - 1).getY() - getY();
		stackRing.get(stackCount - 1).moveY(upY, "up");
		double x1 = stackRing.get(stackCount - 1).getX();
		double y1 = stackRing.get(stackCount - 1).getY();
		int z1 = p.getZ() + p.stackCount + 1;

		double x2 = p.getX();
		double y2 = p.getY();

		double dx = Math.abs(x1 - x2);
		double dy = Math.abs(y1 - y2);

		stackRing.remove(stackCount - 1);

		Ring animation = new Ring(1000);
		RenderableHolder.getInstance().add(animation);

		if (x2 > x1) {
			animation.moveX(dx, "right");
		} else {
			animation.moveX(dx, "left");
		}

		if (y2 > y1) {
			animation.moveY(dy, "down");
		} else {
			animation.moveY(dy, "up");
		}

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
