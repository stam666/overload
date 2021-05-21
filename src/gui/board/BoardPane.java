package gui.board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.Tile;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import main.GameLogic;
import sharedObject.RenderableHolder;

public class BoardPane extends Pane {
	
	private int player;
	private int length;
	
	public BoardPane(int player, int length) {
		this.player = player;
		this.length = length;
		int width=1024,height=256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		initializeBoard();
	}
	
	public void initializeBoard() {
		for (int i = player; i > 0; i--) {
			List<Tile> lane = new ArrayList<Tile>(length);
			for (int j = 0; j < length; j++) {
				Tile tile = new Tile(i * 10);
				tile.setX(0 + j * tile.getWidth() * GameLogic.getFactor());
				tile.setY(0 + i * tile.getHeight() * GameLogic.getFactor());
				lane.add(tile);
				RenderableHolder.getInstance().add(tile);
			}
			
		}
		
	}
	
}
