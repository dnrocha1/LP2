package sp2fy;

public class Musica {
	
	private String nome;
	private int duracao;
	private String tipo;
	
	public Musica(String nome, int duracao, String tipo) {
		if (nome.equals(null) || nome.equals("")) {
			throw new UnsupportedOperationException("Titulo da musica nao pode ser vazio.");
		} else {
			this.nome = nome;
		}
		if(duracao < 0){
			throw new UnsupportedOperationException("Duracao da musica nao pode ser negativa.");
		}else{
			this.duracao = duracao;
		}
		if (tipo.equals(null) || tipo.equals("")) {
			throw new UnsupportedOperationException("Genero da musica nao pode ser vazio.");
		} else {
			this.tipo = tipo;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (duracao != other.duracao)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	/*
	 * public boolean equals(Musica musica) { if (this == musica) return true;
	 * if (musica == null) return false; if (getClass() != musica.getClass())
	 * return false; if (duracao != musica.duracao) return false; if (nome ==
	 * null) { if (musica.nome != null) return false; } else if
	 * (!nome.equals(musica.nome)) return false; if (tipo == null) { if
	 * (musica.tipo != null) return false; } else if (!tipo.equals(musica.tipo))
	 * return false; return true; }
	 */

}
