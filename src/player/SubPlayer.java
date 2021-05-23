package player;

import java.util.ArrayList;
import java.util.List;

import entity.Pole;
import entity.Tile;
import javafx.scene.image.Image;
import sharedObject.ImageHolder;

public class SubPlayer {
	private int stage;
	private int rings;
	private String name="RED";
	private int idx;
	private List<Tile> lane;
	private Pole pole;
	public SubPlayer(int idx,String name) {
		this.rings=0;
		this.stage=0;
		this.idx=idx;
		this.name=name;
	}
	
	public List<Tile> getLane() {
		return lane;
	}

	public void setLane(List<Tile> list) {
		this.lane = list;
	}

	public Pole getPole() {
		return pole;
	}

	public void setPole(Pole pole) {
		this.pole = pole;
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
		//System.out.println("tt");
		for(int i=0;i<add;i++) {	
			this.pole.addRing();
		}
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
		int back=this.stage;
		this.stage=0;
		this.pole.move(back, "left");
	}
	public void setRings(int counter) {
		this.rings = counter;
		for(int i=0;i<counter;i++) {
			
			this.pole.addRing();
		}
	}
	public String getName() {
		return name;
	}
	public Image get1D() {
		if(idx==0) {
			if(getName().equals("RED")) {
				return ImageHolder.getInstance().darkRedPole1D.get(getRings());
			}else if(getName().equals("BLUE")) {
				return ImageHolder.getInstance().darkBluePole1D.get(getRings());
			}else if(getName().equals("GREEN")) {
				return ImageHolder.getInstance().darkGreenPole1D.get(getRings());
			}else if(getName().equals("PINK")) {
				return ImageHolder.getInstance().darkPinkPole1D.get(getRings());
			}
		}else if(idx==1) {
			if(getName().equals("RED")) {
				return ImageHolder.getInstance().lightRedPole1D.get(getRings());
			}else if(getName().equals("BLUE")) {
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
