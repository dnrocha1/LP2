package exceptions;

public class ScoreNegativoException extends Exception {

	public ScoreNegativoException() {
		super("Score nao pode ser negativo.");
	}
}
