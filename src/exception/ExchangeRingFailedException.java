package exception;

public class ExchangeRingFailedException extends Exception{
	public String message;
	
	public ExchangeRingFailedException(String message) {
		this.message = message;
		//(AudioHolder.getInstance()
	}
}
