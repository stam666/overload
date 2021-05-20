package player;

import java.util.ArrayList;

public class Player {
	private int point;
	private String name;
	ArrayList<SubPlayer> sub;
	
	public Player(String name) {
		this.point=0;
		SubPlayer first= new SubPlayer(0,name),second =new SubPlayer(1,name);
		sub = new ArrayList<SubPlayer>();
		sub.add(first);
		sub.add(second);
		this.name=name;
	}
	public int getPoint() {
		return point;
	}
	public void addPoint(int point) {
		this.point += point;
	}
	public ArrayList<SubPlayer> getSub() {
		return sub;
	}
	public String getName() {
		return name;
	}
	
}

