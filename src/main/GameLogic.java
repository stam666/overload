package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import input.InputUtility;
import javafx.util.Pair;
import player.*;
import sharedObject.*;

public class GameLogic {
	private static ArrayList<Player> players;
	private static Scanner kb = new Scanner(System.in);
	private static final int scoreToWin = 35;
	static int nowState = 1;
	private static int stageLength = 18, nowNumberSubPlayer, oldStage, nowStage;
	protected static SubPlayer nowSubPlayer;
	protected static ArrayList<SubPlayer> atSame = new ArrayList<SubPlayer>();
	private static int turnofPlayer = 0, nextAction;
	private static Boolean update = false, updateSame = false, change = false, changeSame = false;
	private static double factor = 1024.0D / 18.0D / 450.0D;
	
	public static int getNextAction() {
		return nextAction;
	}
	
	public static Boolean getUpdate() {
		return update;
	}

	public static Boolean getUpdateSame() {
		return updateSame;
	}

	public static Boolean getChange() {
		return change;
	}

	public static Boolean getChangeSame() {
		return changeSame;
	}

	public static int getNowState() {
		return nowState;
	}

	public static SubPlayer getNowSubPlayer() {
		return nowSubPlayer;
	}

	public static Player getPlayer() {
		return players.get(turnofPlayer);
	}

	public static void setTurnofPlayer(int turnofPlayer) {
		GameLogic.turnofPlayer = turnofPlayer;
	}

	public static ArrayList<SubPlayer> getAtSame() {
		return atSame;
	}

	public static void initialize(ArrayList<Player> player) {
		players = player;
		nowState = 1;turnofPlayer=0;
	}

	public static void CheckAtEnd() {
		if (nowStage >= stageLength) {
			if (nowSubPlayer.getRings() == 8) {
				players.get(turnofPlayer).addPoint(12);
			} else {
				players.get(turnofPlayer).addPoint(nowSubPlayer.getRings());
			}
			nowSubPlayer.reset();
		}
	}

	public static void choosePole() {
		System.out.println("Player " + turnofPlayer + " turn");
		int idx = turnofPlayer;
		// Random ran = new Random();
		// int dice = ran.nextInt(8)+1;
		if (players.get(idx).getSub().get(0).getStage() == 0) {
			nowState = 3;
			nowNumberSubPlayer = 0;
			nowSubPlayer = players.get(turnofPlayer).getSub().get(0);
		} else if (players.get(idx).getSub().get(1).getStage() == 0) {
			nowState = 3;
			nowNumberSubPlayer = 1;
			nowSubPlayer = players.get(turnofPlayer).getSub().get(1);
		} else {
			// RenderChoosePole
			change = true;
			nextAction = Constants.choosePole;
			nowState = 2;
		}
	}
	
	public static void CheckPassedPole() {
		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j <= 1; j++) {
				if (i == turnofPlayer && j == nowNumberSubPlayer)
					continue;
				int thisStage = players.get(i).getSub().get(j).getStage();
				if (thisStage > oldStage && thisStage < nowStage) {

					players.get(i).getSub().get(j).addRings(1);
					// RenderAddRing
					if (players.get(i).getSub().get(j).isOverload()
							&& !(players.get(i).getName().equals(players.get(turnofPlayer).getName()))) {
						players.get(turnofPlayer).addPoint(1);
					}
				} else if (thisStage == nowStage) {
					atSame.add(players.get(i).getSub().get(j));
				}
			}
		}
	}

	public static void setRingsToSubPlayer(int numberOfRings) {
		nowSubPlayer.setRings(numberOfRings);
	}

	public static void atSameAction(int idx, int action) {
		SubPlayer chosenPlayer = atSame.get(idx);
		if (action == Constants.give) { // give
			nowSubPlayer.reduceRings(1);
			chosenPlayer.addRings(1);
			if (chosenPlayer.isOverload() && !(chosenPlayer.getName().equals(nowSubPlayer.getName()))) {
				players.get(turnofPlayer).addPoint(1);
			}
		} else if (action == Constants.get) { // get
			nowSubPlayer.addRings(1);
			nowSubPlayer.isOverload();
			chosenPlayer.reduceRings(1);
		}
		atSame.remove(idx);
	}
	private static void setUpdate() {
		update = false;
		updateSame = false;
		change = false;
		changeSame = false;
	}
	private static Boolean allAtSameIsZero() {
		for(SubPlayer e : atSame) {
			if(e.getRings()!=0) {
				return false;
			}
		}
		return true;
	}
	public static void updateLogic() {
		setUpdate();
		if (nowState == 1) {
			choosePole();
		} else if (nowState == 2) {
			if (InputUtility.isChoosePoleZero()) {
				nowNumberSubPlayer = 0;
				nowState = 5;
				nowSubPlayer = players.get(turnofPlayer).getSub().get(0);
				change = true;
				nextAction = Constants.rollDice;
				InputUtility.afterChoosePole();
			} else if (InputUtility.isChoosePoleOne()) {
				nowNumberSubPlayer = 1;
				nowState = 5;
				nowSubPlayer = players.get(turnofPlayer).getSub().get(1);
				change = true;
				nextAction = Constants.rollDice;
				InputUtility.afterChoosePole();
			}
		} else if (nowState == 3) {
			// RenderAskNumberOfRings
			change = true;
			nextAction = Constants.chooseNumber;

			nowState = 4;
		} else if (nowState == 4) {
			if (InputUtility.getNumberOfRings() != -1) {
				setRingsToSubPlayer(InputUtility.getNumberOfRings());
				
				// renderRolldice
				change = true;
				nextAction = Constants.rollDice;
				nowState = 5;
				InputUtility.setNumberOfRings(-1);
			}
		} else if (nowState == 5) {
			update = true;
			if (InputUtility.isStopDice()) {
				update = true;
				int dice = InputUtility.getNumberDice();
				oldStage = nowSubPlayer.getStage();
				nowStage = nowSubPlayer.addStage(dice);
				nowState = 6;
				InputUtility.setStopDice(false);
			}
		} else if (nowState == 6) {
			// renderwalk
			
			nowState = 7;
//			if(render fin ) {
//				nowState=7;
//			}
		} else if (nowState == 7) {
			atSame.clear();
			CheckPassedPole();
			nowState = 8;
		} else if (nowState == 8) {
			// renderadd pass pole
//			if(render fin ) {
//			nowState=9;
//			}
			nowState = 9;
		} else if (nowState == 9) {
			if (atSame.isEmpty()) {
				nowState = 12;
			} else {
				// render
				changeSame = true;
				nowState = 10;
			}
		} else if (nowState == 10) {
			if (atSame.isEmpty() || (nowSubPlayer.getRings()==0 && allAtSameIsZero())) {
				nowState = 12;
			} else if (InputUtility.isAtSameActionEntered()) {
				for (int i = 0; i < atSame.size(); i++) {
					if (InputUtility.getAtSameAction()[i] != 0) {
						atSameAction(i, InputUtility.getAtSameAction()[i]);
						nowState = 11;
						updateSame = true;
						InputUtility.afterAtSameAction();
						break;
					}
				}
			}
		} else if (nowState == 11) {
//			if(render fin ) {
//			nowState=12;
//			}
			if (!atSame.isEmpty()) {
				nowState = 10;
			} else {
				nowState = 12;
			}
		} else if (nowState == 12) {
			CheckEndgame();
			CheckAtEnd();
			// System.out.println("hi");
			turnofPlayer += 1;
			turnofPlayer %= 4;
			nowState = 1;
		}
	}

	private static void CheckEndgame() {
		// TODO Auto-generated method stub
		for (Player e : players) {
			if (e.getPoint() >= scoreToWin) {

			}
		}
	}

	public static double getFactor() {
		return factor;
	}

	public static int getStageLength() {
		return stageLength;
	}
	
	
	
}