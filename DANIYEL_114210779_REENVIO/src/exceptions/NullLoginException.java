package exceptions;

public class NullLoginException extends Exception {

	public NullLoginException() {
		super("Login nao pode ser null.");
	}
}
