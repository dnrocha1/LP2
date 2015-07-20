package exceptions;

public class DinheiroInsuficienteException extends Exception {

	public DinheiroInsuficienteException() {
		super("O usuario nao tem dinheiro suficiente.");
	}
}
