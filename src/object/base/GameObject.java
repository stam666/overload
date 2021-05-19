package object.base;

import sharedObject.IRenderable;

public abstract class GameObject implements IRenderable {
	
	protected double x,y;
	protected int z;
	protected boolean visible,destroyed;
	
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
}
