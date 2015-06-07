package exceptions;

public class NullNomeException extends Exception {
	
	public NullNomeException() {
		super("Nome nao pode ser null.");
	}
}
