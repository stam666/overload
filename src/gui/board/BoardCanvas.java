package gui.board;

import java.util.ArrayList;
import java.util.List;

import entity.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class BoardCanvas extends Canvas {
    private GraphicsContext gc;
    private static final List<List<Tile>> board = new ArrayList<List<Tile>>();

    public BoardCanvas() {
        setup();
        buildBoard();
    }

    public void setup() {
        this.gc = getGraphicsContext2D();
        setWidth(1024.0D);
        setHeight(256.0D);
    }

    public void buildBoard() {
        int player = 4;
        int length = 18;
        for (int i = 0; i < player * 2; i++) {
            List<Tile> lane = new ArrayList<Tile>(length);
            for (int j = 0; j < length; j++) {
                Tile tile = new Tile(i * 20);
                tile.setX((i * tile.getWidth() * 105 / 450) + ((j+1.7) * tile.getWidth() * 345 / 450));
                tile.setY(40 + i * tile.getHeight());
                lane.add(tile);
                RenderableHolder.getInstance().add(tile);
            }
            board.add(lane);
        }
    }

    public void clearScreen() {
        this.gc.clearRect(0.0D, 0.0D, 1024.0D, 256.0D);
    }

    public void drawGameObject() {
        for (IRenderable entity: RenderableHolder.getInstance().getEntities()) {
        	if (entity.isVisible()) {
        		entity.draw(gc);
        	}
        } 
    }

	public static List<List<Tile>> getBoard() {
		return board;
	}
    
}
