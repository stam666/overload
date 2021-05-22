package gui.game;

import java.util.ArrayList;

import gui.action.ActionPane;
import gui.board.BoardCanvas;
import gui.board.BoardPane;
import gui.score.ScoreboardPane;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import main.GameLogic;
import main.logic;
import player.Player;
import player.SubPlayer;
import sharedObject.Constants;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameScreen extends VBox{
	private ScoreboardPane score;
	private ActionPane action;
	private BoardCanvas boardCanvas;
	private Canvas gameCanvas;
	private GraphicsContext gamegc;
	private ArrayList<Player> players;
	private AnimationTimer gameLoop;
	private Boolean updateSame=false,update=false,changeSame=false,change=false;
	private int nextAction;
	public GameScreen() {
		players = new ArrayList<Player>();
		players.add(new Player("BLUE"));
		players.add(new Player("GREEN"));
		players.add(new Player("PINK"));
		players.add(new Player("RED"));
		GameLogic.initialize(players);
		int width = 1024, height = 768;
		this.setMinWidth(width);
		this.setMaxWidth(height);
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.score = new ScoreboardPane(this.players);
		this.action = new ActionPane();
		this.boardCanvas = new BoardCanvas();
		this.getChildren().addAll(this.score, this.action, this.boardCanvas);
		this.loop();
	}
	 private void loop() {
	    this.gameLoop = new AnimationTimer() {
		        public void handle(long now) {
		        	boardCanvas.clearScreen();
					GameLogic.updateLogic();
					RenderableHolder.getInstance().update();
					boardCanvas.drawGameObject();
					
					updateSame=GameLogic.getUpdateSame();
					update=GameLogic.getUpdate();
					changeSame=GameLogic.getChangeSame();
					change=GameLogic.getChange();
					nextAction=GameLogic.getNextAction();
					if(change) {
						//System.out.println(nextAction);
						GameScreen.this.update(true,nextAction);
						
					}else if(changeSame) {
						GameScreen.this.updateAtSame(true,Constants.atSame,GameLogic.getAtSame(),GameLogic.getNowSubPlayer().getRings()>0);
					}else if(update) {
						GameScreen.this.update(false,-1);
					}else if(updateSame) {
						GameScreen.this.updateAtSame(false,Constants.atSame,GameLogic.getAtSame(),GameLogic.getNowSubPlayer().getRings()>0);
					}
		
					/*for(Player e:players) {
						SubPlayer a=e.getSub().get(0),b=e.getSub().get(1);
						System.out.printf("%d  %d %d\n",GameLogic.getNowState(),a.getStage(),b.getStage());
					}
					System.out.println(GameScreen.this.action.getMode());*/
		          
		        }
		      };
		    this.gameLoop.start();
		  }
	private void update(Boolean changeAction, int nextAction) {
		GameScreen.this.score.update();
		if (changeAction) {
			
			GameScreen.this.action.changeMode(nextAction);
		} else {
			GameScreen.this.action.update();
		}
	}

	private void updateAtSame(Boolean changeAction, int nextAction, ArrayList<SubPlayer> targets, Boolean amLeft) {
		GameScreen.this.score.update();
		if (changeAction && nextAction == 4) {
			GameScreen.this.action.changeModeAtSame(nextAction, targets, amLeft);
		} else if (!changeAction) {
			GameScreen.this.action.updateAtSame(targets, amLeft);
		}
	}
}
