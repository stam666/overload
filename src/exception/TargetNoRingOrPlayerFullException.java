package exception;

public class TargetNoRingOrPlayerFullException extends Exception{

	public TargetNoRingOrPlayerFullException() {
		super("Target dont have ring left!!!");
	}
}
