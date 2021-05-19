package object.entity;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import object.base.GameObject;
import object.board.Tile;

public class Pole extends GameObject {
	
	private List<Ring> ringStack;
	private String color;
	private Image image;

	public Pole(String color) {
		this.color = color;
		List<Ring> ringStack = new ArrayList<>(8);
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	
}
