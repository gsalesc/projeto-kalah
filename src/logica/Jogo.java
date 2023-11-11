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
		int contadorCasas = casaEscolhida+1; //a proxima casa

		Casa proximaCasa = null;
		Turno turnoOponente = retornaProximoAJogar(jogador);

			for(int i = 1; i <= sementesCasa; i++) {
				
				//SEMEAR CASAS
				if(i != sementesCasa) {
					//1, 2, 3, 4, 5, 6, 7 => jogador
					
					if(contadorCasas <= 7) { //jogador atual
						if(contadorCasas == Constantes.DEPOSITO) {
							colocarSemente(depositoJogador);
							contadorCasas++;
							
						} else {
							proximaCasa = retornarCasaJogador(contadorCasas, jogador);
							colocarSemente(proximaCasa);
							contadorCasas++;
						}
					}
					
					else { //oponente
						if(contadorCasas <= 13) { 
							Casa oponente = retornarCasaJogador(contadorCasas-7, turnoOponente);
							colocarSemente(oponente);
							contadorCasas++;
							
						} else { //deposito inimigo é pulado
							contadorCasas = 1;
							proximaCasa = retornarCasaJogador(contadorCasas, jogador);
							colocarSemente(proximaCasa);
							contadorCasas++;
						}
					}
				} 
				
				//VERIFICAR ULTIMA SEMENTE
				else { 
					
					if(contadorCasas <= 7) { //jogador
						if(contadorCasas == Constantes.DEPOSITO) { //JOGA NOVAMENTE
							colocarSemente(depositoJogador);
							return jogador;
						} 
						
						//SE CAIR NUMA CASA VAZIA E A DO LADO OPOSTO (OPONENTE) TIVER SEMENTES 
						else if(retornarCasaJogador(contadorCasas, jogador).getSementes() == 0) { 
							Turno verificarOponente = retornaProximoAJogar(jogador);
							
							int casaOposta = Constantes.MAX_CASAS - (contadorCasas-1);
	
							Casa casaOponente = retornarCasaJogador(casaOposta, verificarOponente);
							
							if(casaOponente.getSementes() > 0) {
								int sementesOponente = casaOponente.removerTodasAsSementes();
								
								colocarSemente(depositoJogador); //COLOCANDO ULTIMA SEMENTE NO DEPOSITO
								colocarSementesNoDeposito(depositoJogador, sementesOponente); //COLOCANDO SEMENTES COLHIDAS
							}
							
						} else {
							proximaCasa = retornarCasaJogador(contadorCasas, jogador);
							colocarSemente(proximaCasa);
						}
					} else { //inimigo
						Casa oponente = retornarCasaJogador(contadorCasas-7, turnoOponente);
						colocarSemente(oponente);
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
		
		boolean jogador1Venceu = false;
		boolean jogador2Venceu = false;
		int vencedor = 0;
		
		if(jogador1.getCasa(0).getSementes() == 0
				&& jogador1.getCasa(1).getSementes() == 0
				&& jogador1.getCasa(2).getSementes() == 0
				&& jogador1.getCasa(3).getSementes() == 0
				&& jogador1.getCasa(4).getSementes() == 0
				&& jogador1.getCasa(5).getSementes() == 0) 
			jogador1Venceu = true;
		else jogador1Venceu = false;
		
		
		if(jogador2.getCasa(0).getSementes() == 0
				&& jogador2.getCasa(1).getSementes() == 0
				&& jogador2.getCasa(2).getSementes() == 0
				&& jogador2.getCasa(3).getSementes() == 0
				&& jogador2.getCasa(4).getSementes() == 0
				&& jogador2.getCasa(5).getSementes() == 0) 
			jogador2Venceu = true;
		else jogador2Venceu = false;
		
		if(jogador1Venceu || jogador2Venceu) {
			
			for(Casa casa : jogador1.getCasas()) {
				int sementes = casa.removerTodasAsSementes();
				jogador1.getDeposito().adicionarSementes(sementes);
			}
			
			for(Casa casa : jogador2.getCasas()) {
				int sementes = casa.removerTodasAsSementes();
				jogador2.getDeposito().adicionarSementes(sementes);
			}
			
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
