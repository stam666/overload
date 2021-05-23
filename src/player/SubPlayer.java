package player;

import java.util.List;

import entity.Pole;
import entity.Tile;
import javafx.scene.image.Image;
import sharedObject.ImageHolder;

public class SubPlayer {
	private int stage;
	private int rings;
	private String name;
	private int idx;
	private Pole pole;

	public SubPlayer(int idx, String name) {
		this.rings = 0;
		this.stage = 0;
		this.idx = idx;
		this.name = name;
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
		this.stage += add;
		return this.stage;
	}

	public int addRings(int add) {
		this.rings += add;
		// System.out.println("tt");
		for (int i = 0; i < add; i++) {
			this.pole.addRing();
		}
		return this.rings;
	}

	public int reduceRings(int reduce) {
		this.rings -= reduce;
		for (int i = 0; i < reduce; i++) {
			this.pole.removeRing();
		}
		return this.rings;
	}

	public boolean isOverload() {
		if (this.rings > 8) {
			this.reset();

			return true;
		}
		return false;
	}

	public void reset() {
		int back = this.stage;
		this.stage = 0;
		while (this.rings > 0) {
			this.reduceRings(1);
		}
		this.pole.move(back, "left");
	}

	public String getName() {
		return name;
	}

	public Image get1D() {
		if (idx == 0) {
			if (getName().equals("RED")) {
				return ImageHolder.getInstance().darkRedPole1D.get(getRings());
			} else if (getName().equals("BLUE")) {
				return ImageHolder.getInstance().darkBluePole1D.get(getRings());
			} else if (getName().equals("GREEN")) {
				return ImageHolder.getInstance().darkGreenPole1D.get(getRings());
			} else if (getName().equals("YELLOW")) {
				return ImageHolder.getInstance().darkYellowPole1D.get(getRings());
			}
		} else if (idx == 1) {
			if (getName().equals("RED")) {
				return ImageHolder.getInstance().lightRedPole1D.get(getRings());
			} else if (getName().equals("BLUE")) {
				return ImageHolder.getInstance().lightBluePole1D.get(getRings());
			} else if (getName().equals("GREEN")) {
				return ImageHolder.getInstance().lightGreenPole1D.get(getRings());
			} else if (getName().equals("YELLOW")) {
				return ImageHolder.getInstance().lightYellowPole1D.get(getRings());
			}
		}
		return null;

	}

	public int getIdx() {
		return idx;
	}

}
