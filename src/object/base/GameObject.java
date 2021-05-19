package object.base;

import javafx.scene.image.Image;
import sharedObject.IRenderable;
import sharedObject.ImageHolder;

public abstract class GameObject implements IRenderable {
	
	protected double x,y;
	protected int z;
	protected boolean isVisible, isDestroyed;
	protected Image sprite = ImageHolder.getInstance().nothing;
	
	//SystemCache
	int factor;
	
	
	protected GameObject(){
		isVisible = true;
		isDestroyed = false;
	}

	@Override
	public boolean isDestroyed(){
		return isDestroyed();
	}
	
	@Override
	public boolean isVisible(){
		return isVisible();
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
	    return getSprite().getWidth() * factor;
	}

	  public double getHeight() {
	    return getSprite().getHeight() * factor;
	}
}
