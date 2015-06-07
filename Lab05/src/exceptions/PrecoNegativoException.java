package exceptions;

public class PrecoNegativoException extends Exception {
	
	public PrecoNegativoException(){
		super("Preco nao pode ser negativo.");
	}

}
