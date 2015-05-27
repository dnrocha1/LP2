package steam;

public enum Jogabilidade {
	ONLINE("Online"), OFFLINE("Offline"), MULTIPLAYER("Multiplayer"), COOPERATIVO(
			"Cooperativo"), COMPETITIVO("Competitivo");
	
	private final String valorJogabilidade;
	Jogabilidade(String valor){
		valorJogabilidade = valor;
	}
}
