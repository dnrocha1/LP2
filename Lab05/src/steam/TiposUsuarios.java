package steam;

public enum TiposUsuarios {
	
	NOOB(1), VETERANO(2);
	
	private final int valorTipo;
	public int valorTipo(){
		return this.valorTipo;
	}
	private TiposUsuarios(int valorTipo){
		this.valorTipo = valorTipo;
	}
}
