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
import sharedObject.ImageHolder;
import sharedObject.RenderableHolder;

public class test extends Application {
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	public static  boolean updateSame=false,update=false,changeSame=false;
	public static boolean change=false;
	static int a=0,b=0,changeNo;
	public static SceneHolder sceneHolder;
	private static GameScreen g;  
	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("BLUE"));
		players.add(new Player("GREEN"));
		players.add(new Player("PINK"));
		players.add(new Player("RED"));
		g= new GameScreen(players);
	    Scene s= new Scene(g);
	    primaryStage.setScene(s);
	    primaryStage.getIcons().add(ImageHolder.getInstance().redPole1D.get(8));
	    primaryStage.setTitle("OverLoad");
	    primaryStage.show();
	    
	    AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				
			}
		};
		animation.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}
}