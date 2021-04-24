package player;

public class SubPlayer {
	private int stage;
	private int counter;
	public SubPlayer() {
		this.counter=0;
		this.stage=0;
	}
	public int getStage() {
		return stage;
	}

	public int getCounter() {
		return counter;
	}

	public int addStage(int add) {
		this.stage+=add;
		return this.stage;
	}
	public int addCounter(int add) {
		this.counter+=add;
		return this.counter;
	}
	public int reduceCounter(int reduce) {
		this.counter-=reduce;
		return this.counter;
	}
	public boolean isOverload() {
		if(this.counter>8) {
			this.reset();
			return true;
		}
		return false;
	}
	public void reset() {
		this.counter=0;
		this.stage=0;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
}
