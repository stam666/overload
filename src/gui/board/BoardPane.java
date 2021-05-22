package gui.board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import entity.Pole;
import entity.Tile;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import main.GameLogic;
import sharedObject.Constants;
import sharedObject.RenderableHolder;

public class BoardPane extends Pane {
	
	private int player;
	private int length;
	
	private List<List<Tile>> board = new ArrayList<List<Tile>>();
	
	public BoardPane(int player, int length) {
		this.player = player;
		this.length = length;
		int width=1024,height=256;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		initializeBoard();
		initializePole();
	}
	
	public void initializeBoard() {
		for (int i = 0; i < player * 2; i++) {
			List<Tile> lane = new ArrayList<Tile>(length);
			for (int j = 0; j < length; j++) {
				Tile tile = new Tile((player * 2 - i) * 10);
				tile.setX((i * tile.getWidth() * 105 / 450) + ((j+1.7) * tile.getWidth() * 345 / 450));
				tile.setY(30 + i * tile.getHeight());
				lane.add(tile);
				RenderableHolder.getInstance().add(tile);
			}
			board.add(lane);
		}
	}
	
	
	public void initializePole() {
		for (int i = 0; i < player; i++) {
			String dark = "dark" + Constants.colorList[i];
			String light = "light" + Constants.colorList[i];
			System.out.println(dark.toString());
			Pole darkPole = new Pole(dark.toString());
			Pole lightPole = new Pole(light.toString());
			board.get(i * 2).get(0).setPole(darkPole);
			board.get(i * 2 + 1).get(0).setPole(lightPole);
			RenderableHolder.getInstance().add(darkPole);
			RenderableHolder.getInstance().add(lightPole);
			
			
//			for (List<Tile> list : board) {
//				for (Tile tile : list) {
//					if (tile.getPole() != null) {
//						System.out.println(tile.getPole());
//					}
//				}
//			}
			
		}
	}
}
