package entity;

import javafx.scene.image.Image;
import main.GameLogic;
import sharedObject.IRenderable;
import sharedObject.ImageHolder;

public abstract class Entity implements IRenderable {
	
	protected double x,y;
	protected int z;
	protected boolean isVisible, isDestroyed;
	protected Image sprite = ImageHolder.getInstance().nothing;
	
	protected Entity(){
		isVisible = true;
		isDestroyed = false;
	}

	@Override
	public boolean isDestroyed(){
		return this.isDestroyed;
	}
	
	@Override
	public boolean isVisible(){
		return this.isVisible;
	}
	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}	
	
	public void setDestroyed(boolean destroyed) {
		this.isDestroyed = destroyed;
	}

	@Override
	public int getZ(){
		return z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	
	public double getWidth() {
		return getSprite().getWidth() * GameLogic.getFactor();
	}

	public double getHeight() {
		return getSprite().getHeight() * GameLogic.getFactor();
	}

	public double getCenterX() {
		return getX() + getWidth() / 2.0D;
	}
	
	public double getCenterY() {
		return getY() + getWidth() / 2.0D;
	}
	
	public void setCenterX(double center) {
		setX(center - getWidth() / 2);
	}
	
	public void setCenterY(double center) {
		setY(center - getHeight() / 2);
	}
}
