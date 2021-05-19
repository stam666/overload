package player;

public class SubPlayer {
	private int stage;
	private int rings;
	private String Color="RED";
	public SubPlayer() {
		this.rings=0;
		this.stage=0;
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
	public String getColor() {
		return Color;
	}
}
