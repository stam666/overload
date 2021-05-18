package input;

import java.util.ArrayList;

public class InputUtility {
	private static final int recieve=1,get=2;
	private static int[] atSameAction = {0,0,0,0,0,0,0,0,0,0,0};
	private static boolean atSameActionEntered = false;
	private static boolean rollDice=false;
	private static boolean choosePoleZero=false,choosePoleOne=false;
	private static int numberOfRings=-1;
	public static void setAtSameAction(int idx,int act) {
		atSameAction[idx]=act;
	}
	public static void setAtSameActionEnter(boolean act) {
		atSameActionEntered=act;
	}
	public static int[] getAtSameAction() {
		return atSameAction;
	}
	public static boolean isAtSameActionEntered() {
		return atSameActionEntered;
	}
	public static void afterAtSameAction() {
		for(int i=0;i<=9;i++) {
			atSameAction[i]=0;
		}
		setAtSameActionEnter(false);
	}
	public static boolean isRollDice() {
		return rollDice;
	}
	public static void setRollDice(boolean rollDice) {
		InputUtility.rollDice = rollDice;
	}
	public static void afterRollDice() {
		setRollDice(false);
	}
	
	public static boolean isChoosePoleZero() {
		return choosePoleZero;
	}
	public static void setChoosePoleZero(boolean choosePoleZero) {
		InputUtility.choosePoleZero = choosePoleZero;
	}
	public static boolean isChoosePoleOne() {
		return choosePoleOne;
	}
	public static void setChoosePoleOne(boolean choosePoleOne) {
		InputUtility.choosePoleOne = choosePoleOne;
	}
	public static void afterChoosePole() {
		setChoosePoleOne(false);
		setChoosePoleZero(false);
	}
	public static int getNumberOfRings() {
		return numberOfRings;
	}
	public static void setNumberOfRings(int numberOfRings) {
		InputUtility.numberOfRings = numberOfRings;
	}
}
