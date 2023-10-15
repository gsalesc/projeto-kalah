package view;

import java.util.Scanner;

import logica.Jogo;
import util.Turno;

public class Teste {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Jogo jogo = new Jogo();
					
		for(int i = 1; i <= 7; i++) {
			if(i != 7)
				System.out.println("Casa " + i + " - sementes: " + String.valueOf(jogo.getTerreno().getJogador1().getCasa(i-1).getSementes()));
			else System.out.println("Deposito - sementes: " + String.valueOf(jogo.getTerreno().getJogador1().getDeposito().getSementes()));
		}
		
		Turno turno = Turno.JOGADOR_UM;
		int casa = scan.nextInt();
		
		while(casa != 0) {

			jogo.fazerJogada(casa, turno);
			
			for(int i = 1; i <= 7; i++) {
				if(i != 7)
					System.out.println("Casa " + i + " - sementes: " + String.valueOf(jogo.getTerreno().getJogador1().getCasa(i-1).getSementes()));
				else System.out.println("Deposito - sementes: " + String.valueOf(jogo.getTerreno().getJogador1().getDeposito().getSementes()));
			}
			
			casa = scan.nextInt();
		}
		
		scan.close();
		
		new Tabuleiro();
	}
}
