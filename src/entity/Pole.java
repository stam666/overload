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
	private boolean isMove;
	private double desX;

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
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		if(isMove) {
			if (Math.abs(desX - getX()) > speed) {
				setX(getX() + speed);
			} else {
				setX(desX);
				setMove(false);
			}
		}
	}

	public void move(int n) {
		setMove(true);
		desX = getX() + n * ImageHolder.getInstance().tile.getWidth() * GameLogic.getFactor() * 345 / 450;	
	}

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

	public double getDesX() {
		return desX;
	}

	public void setDesX(double desX) {
		this.desX = desX;
	}
	
	
	
}
