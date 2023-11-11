package modelo;

import util.Turno;

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
	
	public int getSementesCasaJogador(int casa, Turno jogador) {
		if(jogador == Turno.JOGADOR_UM)
			return this.jogador1.getSementesCasa(casa);
		else if (jogador == Turno.JOGADOR_DOIS)
			return this.jogador2.getSementesCasa(casa);
		else return 0;
	}
	
	public int getSementesDepositoJogador(Turno jogador) {
		if(jogador == Turno.JOGADOR_UM)
			return this.jogador1.getSementesDeposito();
		else if (jogador == Turno.JOGADOR_DOIS)
			return this.jogador2.getSementesDeposito();
		else return 0;
	}
}
