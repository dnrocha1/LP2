/**
 * Classe Loja, com ela vai ocorrer praticamente tudo, por isso ela ้ chamada de Fa็ade do projeto.
 * 
 * @author Daniyel Negromonte Nascimento Rocha
 */
package steam;

import java.util.ArrayList;
import java.util.Collections;

import exceptions.LoginInvalidoException;

public class Loja {

	private ArrayList<Usuario> usuarios;
	private ArrayList<Jogo> jogos;
	private double totalArrecado;

	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.jogos = new ArrayList<Jogo>();
		this.totalArrecado = 0;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}

	/**
	 * Metodo que vai realizar o upgrade de um usuario, se possivel.
	 * 
	 * @param login
	 *            Campo com o login do usuario que vai tentar realizar o
	 *            upgrade.
	 */
	/*public void upgrade(String login) throws Exception {//noob vira veterano
		Usuario user;
		user = this.buscaUsuario(login);
		//user.upgrade();
		user.getJogador().upgrade(user.getX2p());
		int index = usuarios.indexOf(user);
		//Usuario novoVeterano = new Veterano(user);
		Usuario novoVeterano = new Usuario(user);
		usuarios.set(index, novoVeterano);
	}*/
	
	/**
	 * Metodo que vai realizar o downgrade de um usuario, se possivel.
	 * 
	 * @param login
	 *            Campo com o login do usuario que vai tentar realizar o
	 *            downgrade.
	 */
	/*public void downgrade(String login) throws Exception {//veterano vira noob
		Usuario user;
		user = this.buscaUsuario(login);
		//user.downgrade();
		user.getJogador().downgrade(user.getX2p());
		int index = usuarios.indexOf(user);
		Usuario novoNoob = new Usuario(user);
		usuarios.set(index, novoNoob);
	}*/

	protected Usuario buscaUsuario(String login) throws Exception {
		Usuario user = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login))
				user = usuario;
		}
		if (user == null)
			throw new LoginInvalidoException();
		return user;
	}

	protected Jogo buscaJogo(String nomeJogo) throws Exception {
		Jogo jogo = null;
		for (Jogo outroJogo : jogos) {
			if (outroJogo.getNome().equalsIgnoreCase(nomeJogo))
				jogo = outroJogo;
		}
		if (jogo == null)
			throw new Exception("Jogo invalido.");
		return jogo;
	}

	public void adicionaUsuario(Usuario novoUsuario) {
		this.usuarios.add(novoUsuario);
	}

	public void adicionaJogo(Jogo novoJogo) {
		this.jogos.add(novoJogo);
	}

	protected void atualizaArrecadado(double valorVenda) {
		this.totalArrecado += valorVenda;
	}
	
	public void ordenaUsuarios() {
		Collections.sort(usuarios);
	}

	public void imprimeInformacoes() {
		System.out.print("=== Central P2-CG ===");
		System.out.println();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getNome());
			if (usuario.getJogador() instanceof Noob) {
				System.out
						.println("Jogador Noob: " + usuario.getX2p() + " x2p");
			}
			if (usuario.getJogador() instanceof Veterano) {
				System.out.println("Jogador Veterano: " + usuario.getX2p()
						+ " x2p");
			}
			System.out.println("Lista de Jogos:");
			usuario.listaJogosComprados();
			System.out.println("Total de preco dos jogos: R$ "
					+ usuario.totalJogosComprados());
			System.out.println();
		}
		System.out.println("ญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญ");
		System.out.println("Total arrecadado com vendas de jogos: R$ "
				+ this.totalArrecado);
		System.out.println();
	}

}
