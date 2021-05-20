package scene;

import java.util.ArrayList;
import java.util.List;

import gui.game.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import main.logic;
import player.Player;
import player.SubPlayer;
import sharedObject.Constants;

public class GameScene extends Scene {
	private GameScreen gameScreen;
	public static  boolean updateSame=false,update=false,changeSame=false;
	public static boolean change=false;
	static int a=0,b=0,changeNo;
	private ArrayList<Player> players;

	public GameScene(Parent root) {
		super(root);
	}

	public GameScene() {
		this((Parent) new GameScreen(players));
		initialize();
	}

	private void initialize() {
		GameScreen gameScreen = new GameScreen(players);
		logic.initialize(players);
		
		setRoot((Parent) (this.gameScreen = gameScreen));
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				//g.update(true,3);
				updateSame=false;
				update=false;
				changeSame=false;
				change=false;
				logic.updateLogic();
				if(change) {
					gameScreen.update(true,changeNo);
				}else if(changeSame) {
					gameScreen.updateAtSame(true,Constants.atSame,logic.atSame,logic.nowSubPlayer.getRings()>0);
				}else if(update) {
					gameScreen.update(false,-1);
				}else if(updateSame) {
					gameScreen.updateAtSame(false,Constants.atSame,logic.atSame,logic.nowSubPlayer.getRings()>0);
				}
	
				for(Player e:players) {
					SubPlayer a=e.getSub().get(0),b=e.getSub().get(1);
					System.out.printf("%d  %d %d %d %d\n",logic.nowState,a.getRings(),a.getStage(),b.getRings(),b.getStage());
				}
				System.out.println("///////////////////////////////////////////////////");
				
			}
		};
		animation.start();
		
	}

}
