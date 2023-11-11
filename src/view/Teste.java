package view;

import java.io.IOException;
import java.util.Scanner;

import logica.Jogo;
import util.Turno;

public class Teste {
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		Jogo jogo = new Jogo();
					
		Turno turno = Turno.JOGADOR_UM;
		int casa = 0;
		
		int vencedor = jogo.verificarVencedor();
		String novamente = "";
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		while(vencedor != 1 && vencedor != 2) {
			if(turno == Turno.JOGADOR_UM) {
				printJogo(jogo);
				
				if(novamente.equals("")) {
					System.out.print("JOGADOR 1\n");
				} else {
					System.out.print("JOGADOR 1" + novamente + "\n");
				}
				
				novamente = "";
				System.out.print("Escolha a casa: ");
				casa = scan.nextInt();
				turno = jogo.fazerJogada(casa, turno);
				
				if(turno == Turno.JOGADOR_UM) {
					novamente = " - Jogue novamente";
				}
				
			} else if (turno == Turno.JOGADOR_DOIS) {
				printJogo(jogo);
				
				if(novamente.equals("")) {
					System.out.print("JOGADOR 2\n");
				} else {
					System.out.print("JOGADOR 2" + novamente + "\n");
				}
				
				novamente = "";
				System.out.print("Escolha a casa: ");
				casa = scan.nextInt();
				turno = jogo.fazerJogada(casa, turno);
				
				if(turno == Turno.JOGADOR_DOIS) {
					novamente = " - Jogue novamente";
				}
			}
			
			vencedor = jogo.verificarVencedor();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		}
		
		if(vencedor == 1) {
			System.out.println("JOGADOR 1 VENCEU!!!");
		} else if(vencedor == 2) {
			System.out.println("JOGADOR 2 VENCEU!!!");
		}
		
		System.out.println("Jogador 1 - Sementes no depósito: " + jogo.getTerreno().getSementesDepositoJogador(Turno.JOGADOR_UM));
		System.out.println("Jogador 2 - Sementes no depósito: " + jogo.getTerreno().getSementesDepositoJogador(Turno.JOGADOR_DOIS));
		
		scan.close();
		
	
	}
	
	private static void printJogo(Jogo jogo) throws IOException{
		int jg1Dep = jogo.getTerreno().getSementesDepositoJogador(Turno.JOGADOR_UM);
		int jg1C6 = jogo.getTerreno().getSementesCasaJogador(5, Turno.JOGADOR_UM);
		int jg1C5 = jogo.getTerreno().getSementesCasaJogador(4, Turno.JOGADOR_UM);
		int jg1C4 = jogo.getTerreno().getSementesCasaJogador(3, Turno.JOGADOR_UM);
		int jg1C3 = jogo.getTerreno().getSementesCasaJogador(2, Turno.JOGADOR_UM);
		int jg1C2 = jogo.getTerreno().getSementesCasaJogador(1, Turno.JOGADOR_UM);
		int jg1C1 = jogo.getTerreno().getSementesCasaJogador(0, Turno.JOGADOR_UM);
		
		int jg2Dep = jogo.getTerreno().getSementesDepositoJogador(Turno.JOGADOR_DOIS);
		int jg2C6 = jogo.getTerreno().getSementesCasaJogador(5, Turno.JOGADOR_DOIS);
		int jg2C5 = jogo.getTerreno().getSementesCasaJogador(4, Turno.JOGADOR_DOIS);
		int jg2C4 = jogo.getTerreno().getSementesCasaJogador(3, Turno.JOGADOR_DOIS);
		int jg2C3 = jogo.getTerreno().getSementesCasaJogador(2, Turno.JOGADOR_DOIS);
		int jg2C2 = jogo.getTerreno().getSementesCasaJogador(1, Turno.JOGADOR_DOIS);
		int jg2C1 = jogo.getTerreno().getSementesCasaJogador(0, Turno.JOGADOR_DOIS);
		
		System.out.println("              <-----------          ");
		System.out.println("       **************************          ");
		System.out.println("               Jogador 2                    ");
		System.out.println("        | " + jg2C6 + " | " + jg2C5 + " | " + jg2C4 + " | " + jg2C3 + " | " + jg2C2 + " | " + jg2C1 + " | ");
		System.out.println("     "+jg2Dep + " --------------------------- " + jg1Dep);
		System.out.println("        | " + jg1C1 + " | " + jg1C2 + " | " + jg1C3 + " | " + jg1C4 + " | " + jg1C5 + " | " + jg1C6 + " | ");
		System.out.println("               Jogador 1                    ");
		System.out.println("       **************************          ");
		System.out.println("              ------------>          ");	
	}
}
