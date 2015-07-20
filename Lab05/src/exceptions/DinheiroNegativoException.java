package exceptions;

public class DinheiroNegativoException extends Exception {

	public DinheiroNegativoException() {
		super("Dinheiro nao pode ser negativo.");
	}
}
