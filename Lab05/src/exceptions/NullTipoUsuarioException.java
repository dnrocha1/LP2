package exceptions;

public class NullTipoUsuarioException extends Exception {

	public NullTipoUsuarioException() {
		super("Tipo de usuario nao pode ser null.");
	}
}
