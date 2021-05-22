package exception;

public class PlayerNoRingEception extends Exception{
	public PlayerNoRingEception() {
		super("Player dont have ring left!!!");
	}
}
