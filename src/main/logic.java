package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import input.InputUtility;
import javafx.util.Pair;
import player.*;
public class logic {
	private static ArrayList<Player> players= new ArrayList<Player>();
	private static Scanner kb = new Scanner(System.in);
	private static int stageLength,no,nowState,nowNumberSubPlayer,oldStage,nowStage;
	private static SubPlayer nowSubPlayer;
	private static ArrayList<Pair<Integer, Integer>> atSame= new ArrayList<Pair<Integer, Integer>>();
	private static ArrayList<String> getName(int players){
		ArrayList<String> name= new ArrayList<String>();
		for(int i=1;i<=players;i++) {
			System.out.println("Player "+(i-1)+" Name:");
			name.add(kb.nextLine());
		}
		return name;
	}
	private static ArrayList<String> startScreen() {
		System.out.println("How many players?");
		System.out.println("0 ->3 players");
		System.out.println("1 ->4 players");
		System.out.println("2 ->5 players");
		String choice = kb.nextLine();
		int choiceNumber = Integer.parseInt(choice);
		switch (choiceNumber) {
		case 0:
			stageLength=10;no=3;
			return getName(3);
		case 1:
			stageLength=25;no=4;
			return getName(4);
		case 2:
			stageLength=30;no=5;
			return getName(5);
		}
		return getName(0);
	}
	
	private static int askFirstNum() {
		System.out.println("Enter First Number of this:");
		String choice = kb.nextLine();
		return Integer.parseInt(choice);
	}
	private static ArrayList<Integer> chooseSame(ArrayList<Pair<Integer, Integer>> atSame){
		ArrayList<Integer> s= new ArrayList<Integer>();
		System.out.println("Please Choose one of these to send(1) or get(2)");
		int cnt=0;
		for(Pair<Integer, Integer> p : atSame) {
			System.out.println(cnt+"-> Player "+ p.getKey()+" Piece "+p.getValue());
			
		}
		System.out.println("Choose Number:");
		String choice = kb.nextLine();
		s.add(atSame.get(Integer.parseInt(choice)).getKey());
		s.add(atSame.get(Integer.parseInt(choice)).getValue());
		System.out.println("Choose send(1) or get(2):");
		choice = kb.nextLine();
		s.add(Integer.parseInt(choice));
		return s;
	}
	
	private static void walk(int idx,int dice,int piece,boolean isAtStart) {
		System.out.println("Your dice is" + dice);
		if(!isAtStart) {
			System.out.println("Choose Piece to walk (0,1):");
			String choice = kb.nextLine();
			piece = Integer.parseInt(choice);
		}
		int oldStage=players.get(idx).getSub().get(piece).getStage();
		int nowStage= players.get(idx).getSub().get(piece).addStage(dice);
		
		ArrayList<Pair<Integer, Integer>> atSame= new ArrayList<Pair<Integer, Integer>>();
		for(int i=0;i<players.size();i++) {
			
			for(int j=0;j<=1;j++) {
				if(i==idx && j==piece) continue;
				int thisStage= players.get(i).getSub().get(j).getStage();
				if(thisStage>oldStage && thisStage<nowStage) {
					
					players.get(i).getSub().get(j).addCounter(1);
					if(players.get(i).getSub().get(j).isOverload()) {
						players.get(idx).addPoint(1);
					}
				}
				else if(thisStage==nowStage) {
					atSame.add( new Pair<Integer, Integer>(i,j));
				}
			}
		}
		if(!atSame.isEmpty()) {
			ArrayList<Integer> quest= chooseSame(atSame);
			int chosenPlayer=quest.get(0),chosenPiece=quest.get(1),action=quest.get(2);
			if(action==1) { //send
				players.get(idx).getSub().get(piece).reduceCounter(1);
				players.get(chosenPlayer).getSub().get(chosenPiece).addCounter(1);
				if(players.get(chosenPlayer).getSub().get(chosenPiece).isOverload()) {
					players.get(idx).addPoint(1);
				}
			}else if(action==2) { //get
				players.get(idx).getSub().get(piece).addCounter(1);
				players.get(idx).getSub().get(piece).isOverload();
				players.get(chosenPlayer).getSub().get(chosenPiece).reduceCounter(1);
			}
		}
		
		if(nowStage>=stageLength) {
			if(players.get(idx).getSub().get(piece).getCounter()==8) {
				players.get(idx).addPoint(12);
			}
			else {
				players.get(idx).addPoint(players.get(idx).getSub().get(piece).getCounter());
			}
			players.get(idx).getSub().get(piece).reset();
		}
	}
	private static void print() {
		int[][] a=new int[35][15];
		for(int i=0;i<no*2;i++) {
			for(int j=0;j<=stageLength;j++) {
				a[j][i]=999;
			}
		}
		int cnt=0;
		for(int i=0;i<players.size();i++) {
			for(int j=0;j<=1;j++) {
				a[players.get(i).getSub().get(j).getStage()][cnt]=players.get(i).getSub().get(j).getCounter();
				cnt++;
			}
		}
		for(int i=stageLength;i>=0;i--) {
			for(int j=0;j<players.size()*2;j++) {
				System.out.printf("%3d ",a[i][j]);
			}
			System.out.println();
		}
		for(int j=0;j<players.size();j++) {
			System.out.printf("%s: %d\n",players.get(j).getName(),players.get(j).getPoint());
		}
	}
	static int turnofPlayer=0;
	//public static void main(String[] args) {
	public static ArrayList<Player> initial() {
		ArrayList<String> name = startScreen();
		//System.out.println(name);
		for(String e: name) {
			players.add(new Player(e));
		}
		return players;
	}
	
		//while(true) {
	public static void update() {
			System.out.println("Player "+turnofPlayer+ " turn");
			int idx=turnofPlayer;
			Random ran = new Random();
		    int dice = ran.nextInt(8)+1;
			if(players.get(idx).getSub().get(0).getStage()==0) {
				players.get(idx).getSub().get(0).setCounter(askFirstNum());
				walk(idx,dice,0,true);
			}
			else if(players.get(idx).getSub().get(1).getStage()==0) {
				players.get(idx).getSub().get(1).setCounter(askFirstNum());
				walk(idx,dice,1,true);
			}
			else {
				walk(idx,dice,2,false);
			}
			print();
			turnofPlayer+=1;
			turnofPlayer%=no;
	//	}
	}
	public static void choosePole() {
		System.out.println("Player "+turnofPlayer+ " turn");
		int idx=turnofPlayer;
		//Random ran = new Random();
	   // int dice = ran.nextInt(8)+1;
		if(players.get(idx).getSub().get(0).getStage()==0) {
			players.get(idx).getSub().get(0).setCounter(askFirstNum());
			nowState=3;nowNumberSubPlayer=0;
			nowSubPlayer=players.get(turnofPlayer).getSub().get(0);
		}
		else if(players.get(idx).getSub().get(1).getStage()==0) {
			players.get(idx).getSub().get(1).setCounter(askFirstNum());
			nowState=3;nowNumberSubPlayer=1;
			nowSubPlayer=players.get(turnofPlayer).getSub().get(1);
		}
		else {
			//RenderChoosePole
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
					atSame.add( new Pair<Integer, Integer>(i,j));
				}
			}
		}
	}
	public static void setRingsToSubPlayer(int numberOfRings) {
		nowSubPlayer.setCounter(numberOfRings);
	}
	public static void updateLogic() {
		if(nowState==1) {
			choosePole();
		}else if(nowState==2) {
			if(InputUtility.isChoosePoleZero()) {
				nowNumberSubPlayer=0;nowState=3;
				nowSubPlayer=players.get(turnofPlayer).getSub().get(0);
				InputUtility.afterChoosePole();
			}else if(InputUtility.isChoosePoleOne()) {
				nowNumberSubPlayer=1;nowState=3;
				nowSubPlayer=players.get(turnofPlayer).getSub().get(1);
				InputUtility.afterChoosePole();
			}
		}else if(nowState==3) {
			//RenderAskNumberOfRings
		}else if(nowState==4) {
			if(InputUtility.getNumberOfRings!=-1) {
				setRingsToSubPlayer(InputUtility.getNumberOfRings);
				nowState=5;
				//renderRolldice
				InputUtility.setNumberOfRings(-1);
			}
		}else if(nowState==5) {
			if(InputUtility.isRollDice()) {
				//int dice=...
				oldStage=nowSubPlayer.getStage();
				nowStage= nowSubPlayer.addStage(dice);
				nowState=6;
				InputUtility.setRollDice(false);
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
				
			}
		}else if(nowStage==11) {
//			if(render fin ) {
//			nowState=12;
//			}
		}else if(nowStage==12) {
			isFin
		}
	}
}
