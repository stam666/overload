package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.templates.Constants;

import input.InputUtility;
import javafx.util.Pair;
import player.*;
import sharedObject.*;
public class logic {
	private static ArrayList<Player> players= new ArrayList<Player>();
	private static Scanner kb = new Scanner(System.in);
	private static int stageLength=25,no,nowState,nowNumberSubPlayer,oldStage,nowStage;
	private static SubPlayer nowSubPlayer;
	private static ArrayList<SubPlayer> atSame= new ArrayList<SubPlayer>();
	private static int turnofPlayer =0;
	public static void CheckAtEnd() {	
		if(nowStage>=stageLength) {
			if(nowSubPlayer.getCounter()==8) {
				players.get(turnofPlayer).addPoint(12);
			}
			else {
				players.get(turnofPlayer).addPoint(nowSubPlayer.getCounter());
			}
			nowSubPlayer.reset();
		}
	}
	public static void choosePole() {
		System.out.println("Player "+turnofPlayer+ " turn");
		int idx=turnofPlayer;
		//Random ran = new Random();
	   // int dice = ran.nextInt(8)+1;
		if(players.get(idx).getSub().get(0).getStage()==0) {
			nowState=3;nowNumberSubPlayer=0;
			nowSubPlayer=players.get(turnofPlayer).getSub().get(0);
		}
		else if(players.get(idx).getSub().get(1).getStage()==0) {
			nowState=3;nowNumberSubPlayer=1;
			nowSubPlayer=players.get(turnofPlayer).getSub().get(1);
		}
		else {
			//RenderChoosePole
			test.change=true;
			test.changeNo=sharedObject.Constants.choosePole;
		}
	}
	public static void CheckPassedPole() {
		for(int i=0;i<players.size();i++) {
			for(int j=0;j<=1;j++) {
				if(i==turnofPlayer && j==nowNumberSubPlayer) continue;
				int thisStage= players.get(i).getSub().get(j).getStage();
				if(thisStage>oldStage && thisStage<nowStage) {
					
					players.get(i).getSub().get(j).addCounter(1);
					//RenderAddRing
					if(players.get(i).getSub().get(j).isOverload()) {
						players.get(turnofPlayer).addPoint(1);
					}
				}
				else if(thisStage==nowStage) {
					atSame.add( players.get(i).getSub().get(j));
				}
			}
		}
	}
	public static void setRingsToSubPlayer(int numberOfRings) {
		nowSubPlayer.setCounter(numberOfRings);
	}
	public static void atSameAction(ArrayList<Integer> action) {
		for(int i=0;i<atSame.size();i++) {
			SubPlayer chosenPlayer=atSame.get(i);
			if(action.get(i)==2) { //send
				nowSubPlayer.reduceCounter(1);
				chosenPlayer.addCounter(1);
				if(chosenPlayer.isOverload()) {
					players.get(turnofPlayer).addPoint(1);
				}
			}else if(action.get(i)==1) { //get
				nowSubPlayer.addCounter(1);
				nowSubPlayer.isOverload();
				chosenPlayer.reduceCounter(1);
			}
		}
	}
	public static void updateLogic() {
		if(nowState==1) {
			choosePole();
		}else if(nowState==2) {
			if(InputUtility.isChoosePoleZero()) {
				nowNumberSubPlayer=0;nowState=5;
				nowSubPlayer=players.get(turnofPlayer).getSub().get(0);
				test.change=true;test.changeNo=Constants.noAction;
				InputUtility.afterChoosePole();
			}else if(InputUtility.isChoosePoleOne()) {
				nowNumberSubPlayer=1;nowState=5;
				nowSubPlayer=players.get(turnofPlayer).getSub().get(1);
				test.change=true;test.changeNo=Constants.noAction;
				InputUtility.afterChoosePole();
			}
		}else if(nowState==3) {
			//RenderAskNumberOfRings
			test.change=true;test.changeNo=Constants.chooseNumber;
		}else if(nowState==4) {
			if(InputUtility.getNumberOfRings()!=-1) {
				setRingsToSubPlayer(InputUtility.getNumberOfRings());
				nowState=5;
				//renderRolldice
				test.change=true;test.changeNo=Constants.rollDice;
				InputUtility.setNumberOfRings(-1);
			}
		}else if(nowState==5) {
			if(InputUtility.isStopDice()) {
				int dice=InputUtility.getNumberDice();
				oldStage=nowSubPlayer.getStage();
				nowStage= nowSubPlayer.addStage(Math.min(dice,stageLength-oldStage));
				
				nowState=6;
				InputUtility.setStopDice(false);
			}
		}else if(nowState==6) {
			//renderwalk
//			if(render fin ) {
//				nowState=7;
//			}
		}else if(nowState==7) {
			atSame.clear();
			CheckPassedPole();
			nowState=8;
		}else if(nowState==8) {
			//renderadd pass pole
//			if(render fin ) {
//			nowState=9;
//			}
		}else if(nowState==9) {
			if(atSame.isEmpty()) {
				nowState=12;
			}else {
				//render
				nowState=10;
			}
		}else if(nowStage==10) {
			if(InputUtility.isAtSameActionEntered()) {
				atSameAction(InputUtility.getAtSameAction());
			}
		}else if(nowStage==11) {
//			if(render fin ) {
//			nowState=12;
//			}
		}else if(nowStage==12) {
			CheckEndgame();
			CheckAtEnd();
			turnofPlayer+=1;turnofPlayer%=4;
		}
	}
	private static void CheckEndgame() {
		// TODO Auto-generated method stub
		for(Player e:players) {
			if
		}
	}
}
