package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import gui.game.GameScreen;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;
import player.*;
import scene.SceneHolder;
import sharedObject.Constants;
import sharedObject.ImageHolder;
import sharedObject.RenderableHolder;

public class test extends Application {
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	public static  boolean updateSame=false,update=false,changeSame=false;
	public static boolean change=false;
	static int a=0,b=0,changeNo;
	public static SceneHolder sceneHolder;
 
	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("BULE"));
		players.add(new Player("GREEN"));
		players.add(new Player("PINK"));
		players.add(new Player("RED"));
		logic.initialize(players);
		GameScreen g= new GameScreen(players);
		
	    Scene s= new Scene(g);
	    primaryStage.setScene(s);
	    primaryStage.getIcons().add(ImageHolder.getInstance().redPole1D.get(8));
	    primaryStage.setTitle("OverLoad");
	    primaryStage.show();
	    
	    AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				//g.update(true,3);
				updateSame=false;
				update=false;
				changeSame=false;
				change=false;
				logic.updateLogic();
				if(change) {
					g.update(true,changeNo);
				}else if(changeSame) {
					g.updateAtSame(true,Constants.atSame,logic.atSame,logic.nowSubPlayer.getRings()>0);
				}else if(update) {
					g.update(false,-1);
				}else if(updateSame) {
					g.updateAtSame(false,Constants.atSame,logic.atSame,logic.nowSubPlayer.getRings()>0);
				}
	
				for(Player e:players) {
					SubPlayer a=e.getSub().get(0),b=e.getSub().get(1);
					System.out.printf("%d  %d %d\n",logic.nowState,a.getStage(),b.getStage());
				}
				System.out.println("///////////////////////////////////////////////////");
				
			}
		};
		animation.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}
}