package player;

import javafx.scene.image.Image;
import sharedObject.ImageHolder;

public class SubPlayer {
	private int stage;
	private int rings;
	private String name="RED";
	private int idx;
	
	public SubPlayer(int idx,String name) {
		this.rings=0;
		this.stage=0;
		this.idx=idx;
		this.name=name;
	}
	public int getStage() {
		return stage;
	}

	public int getRings() {
		return rings;
	}

	public int addStage(int add) {
		this.stage+=add;
		return this.stage;
	}
	public int addRings(int add) {
		this.rings+=add;
		return this.rings;
	}
	public int reduceRings(int reduce) {
		this.rings-=reduce;
		return this.rings;
	}
	public boolean isOverload() {
		if(this.rings>8) {
			this.reset();
			return true;
		}
		return false;
	}
	public void reset() {
		this.rings=0;
		this.stage=0;
	}
	public void setRings(int counter) {
		this.rings = counter;
	}
	public String getName() {
		return name;
	}
	public Image get1D() {
		if(idx==0) {
			if(getName().equals("RED")) {
				return ImageHolder.getInstance().darkRedPole1D.get(getRings());
			}else if(getName().equals("BULE")) {
				return ImageHolder.getInstance().darkBluePole1D.get(getRings());
			}else if(getName().equals("GREEN")) {
				return ImageHolder.getInstance().darkGreenPole1D.get(getRings());
			}else if(getName().equals("PINK")) {
				return ImageHolder.getInstance().darkGreenPole1D.get(getRings());
			}
		}else if(idx==1) {
			if(getName().equals("RED")) {
				return ImageHolder.getInstance().lightRedPole1D.get(getRings());
			}else if(getName().equals("BULE")) {
				return ImageHolder.getInstance().lightBluePole1D.get(getRings());
			}else if(getName().equals("GREEN")) {
				return ImageHolder.getInstance().lightGreenPole1D.get(getRings());
			}else if(getName().equals("PINK")) {
				return ImageHolder.getInstance().lightPinkPole1D.get(getRings());
			}
		}
		return null;
	
	}
	public int getIdx() {
		return idx;
	}
	
}
