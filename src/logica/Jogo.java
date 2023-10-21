package logica;

import modelo.Armazem;
import modelo.Casa;
import modelo.Deposito;
import modelo.Proprietario;
import modelo.Terreno;
import util.Constantes;
import util.Turno;

public class Jogo {
	Terreno terreno;
	
	public Jogo() {
		terreno = new Terreno();
	}
	
	/**
	  * Realiza uma jogada
	  * 
	  * @param 			   o número da casa escolhida
	  * @param             jogador que realizou a jogada
	  * @return            o próximo jogador a jogar
	  * @author            Gabriel Sales
	  */
	public Turno fazerJogada(int casaEscolhida, Turno jogador) {
		Casa casaJogador = retornarCasaJogador(casaEscolhida, jogador);
		Deposito depositoJogador = retornarDepositoJogador(jogador);

		int sementesCasa = casaJogador.removerTodasAsSementes();
		
		int proximaCasaNum = casaEscolhida+1;
		Casa proximaCasa = null;
		
		for(int i = 1; i <= sementesCasa; i++) {
			//SEMEAR CASAS
			if(i != sementesCasa) {
				if(proximaCasaNum == Constantes.DEPOSITO) {
					colocarSemente(depositoJogador);
					proximaCasaNum=1;
				} else {
					proximaCasa = retornarCasaJogador(proximaCasaNum, jogador);
					colocarSemente(proximaCasa);
					proximaCasaNum++;
				}
			} else { //VERIFICAR ULTIMA SEMENTE
				if(proximaCasaNum == Constantes.DEPOSITO) { //JOGA NOVAMENTE
					colocarSemente(depositoJogador);
					return jogador;
				} 
				
				//SE CAIR NUMA CASA VAZIA E A DO LADO OPOSTO (OPONENTE) TIVER SEMENTES 
				else if(retornarCasaJogador(proximaCasaNum, jogador).getSementes() == 0) { 
					Turno verificarOponente = retornaProximoAJogar(jogador);
					
					int casaOposta = Constantes.MAX_CASAS - (proximaCasaNum-1);
							
							//1 -> 6
							//2 -> 5
							//3 -> 4
							//4 -> 3
							//5 -> 2
							//6 -> 1
			
					Casa casaOponente = retornarCasaJogador(casaOposta, verificarOponente);
					
					if(casaOponente.getSementes() > 0) {
						int sementesOponente = casaOponente.removerTodasAsSementes();
						
						colocarSemente(depositoJogador); //COLOCANDO ULTIMA SEMENTE NO DEPOSITO
						colocarSementesNoDeposito(depositoJogador, sementesOponente); //COLOCANDO SEMENTES COLHIDAS
					}
					
				} else {
					proximaCasa = retornarCasaJogador(proximaCasaNum, jogador);
					colocarSemente(proximaCasa);
				}
			}
		}
		
		return this.retornaProximoAJogar(jogador);
	}
	
	/**
	  * Verifica se tem e quem é o vencedor
	  * 
	  * @return            o vencedor
	  * @author            Gabriel Sales
	  */
	
	public int verificarVencedor() {
		
		Proprietario jogador1 = this.terreno.getJogador1();
		Proprietario jogador2 = this.terreno.getJogador2();
		
		boolean temVencedor = false;
		int vencedor = 0;
		
		for(Casa casa : jogador1.getCasas()) {
			if(casa.getSementes() == 0) temVencedor = true;
			else temVencedor = false;
		}
		
		for(Casa casa : jogador2.getCasas()) {
			if(casa.getSementes() == 0) temVencedor = true;
			else temVencedor = false;
		}
		
		if(temVencedor == true) {
			if(jogador1.getDeposito().getSementes() > jogador2.getDeposito().getSementes())
				vencedor = 1;
			else vencedor = 2;
		}
		
		return vencedor;
	}
	
	private void colocarSemente(Armazem lugarEscolhido) {
		lugarEscolhido.adicionarSemente();
	}
	
	private void colocarSementesNoDeposito(Deposito deposito, int sementes) {
		deposito.adicionarSementes(sementes);
	}
	
	private Casa retornarCasaJogador(int casa, Turno jogador) {
		Casa escolhida = null;
		
		if(jogador == Turno.JOGADOR_UM) {
			escolhida = terreno.getJogador1().getCasa(casa-1);
		}
		else {
			escolhida = terreno.getJogador2().getCasa(casa-1);
		}
		
		return escolhida;
	}
	
	private Deposito retornarDepositoJogador(Turno jogador) {
		Deposito escolhido = null;
		
		if(jogador == Turno.JOGADOR_UM) {
			escolhido = terreno.getJogador1().getDeposito();
		}
		else {
			escolhido = terreno.getJogador2().getDeposito();
		}
		
		return escolhido;
	}
	
	private Turno retornaProximoAJogar(Turno jogador) {
		Turno proximoJogador = null;
		
		if(jogador == Turno.JOGADOR_UM) proximoJogador = Turno.JOGADOR_DOIS;
		else proximoJogador = Turno.JOGADOR_UM;
		
		return proximoJogador;
	}
	
	public Terreno getTerreno() {
		return terreno;
	}
}
