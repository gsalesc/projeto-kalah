package modelo;

public class Terreno {
	Proprietario jogador1;
	Proprietario jogador2;
	
	public Terreno() {
		jogador1 = new Proprietario();
		jogador2 = new Proprietario();
	}

	public Proprietario getJogador1() {
		return jogador1;
	}

	public Proprietario getJogador2() {
		return jogador2;
	}
}
