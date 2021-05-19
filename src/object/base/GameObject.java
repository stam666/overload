package object.base;

import javafx.scene.image.Image;
import sharedObject.IRenderable;
import sharedObject.ImageHolder;

public abstract class GameObject implements IRenderable {
	
	protected double x,y;
	protected int z;
	protected boolean visible,destroyed;
	protected Image sprite = ImageHolder.getInstance().nothing;
	
	protected GameObject(){
		visible = true;
		destroyed = false;
	}

	@Override
	public boolean isDestroyed(){
		return destroyed;
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}
	
	@Override
	public int getZ(){
		return z;
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
	
	
}
