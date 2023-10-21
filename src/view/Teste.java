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
		
		while(jogo.verificarVencedor() != 1 && jogo.verificarVencedor() != 2) {
			if(turno == Turno.JOGADOR_UM) {
				printJogo(jogo);
				System.out.print("JOGADOR 1\n");
				System.out.print("Escolha a casa: ");
				casa = scan.nextInt();
				turno = jogo.fazerJogada(casa, turno);
				
			} else if (turno == Turno.JOGADOR_DOIS) {
				printJogo(jogo);
				System.out.print("JOGADOR 2\n");
				System.out.print("Escolha a casa: ");
				casa = scan.nextInt();
				turno = jogo.fazerJogada(casa, turno);				
			}
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		}
		
		if(jogo.verificarVencedor() == 1) {
			System.out.println("JOGADOR 1 VENCEU!!!");
		} else if(jogo.verificarVencedor() == 2) {
			System.out.println("JOGADOR 2 VENCEU!!!");
		}
		
		scan.close();
	
	}
	
	private static void printJogo(Jogo jogo) throws IOException{
		int jg1Dep = jogo.getTerreno().getJogador1().getDeposito().getSementes();
		int jg1C6 = jogo.getTerreno().getJogador1().getCasa(5).getSementes();
		int jg1C5 = jogo.getTerreno().getJogador1().getCasa(4).getSementes();
		int jg1C4 = jogo.getTerreno().getJogador1().getCasa(3).getSementes();
		int jg1C3 = jogo.getTerreno().getJogador1().getCasa(2).getSementes();
		int jg1C2 = jogo.getTerreno().getJogador1().getCasa(1).getSementes();
		int jg1C1 = jogo.getTerreno().getJogador1().getCasa(0).getSementes();
		
		int jg2Dep = jogo.getTerreno().getJogador2().getDeposito().getSementes();
		int jg2C6 = jogo.getTerreno().getJogador2().getCasa(5).getSementes();
		int jg2C5 = jogo.getTerreno().getJogador2().getCasa(4).getSementes();
		int jg2C4 = jogo.getTerreno().getJogador2().getCasa(3).getSementes();
		int jg2C3 = jogo.getTerreno().getJogador2().getCasa(2).getSementes();
		int jg2C2 = jogo.getTerreno().getJogador2().getCasa(1).getSementes();
		int jg2C1 = jogo.getTerreno().getJogador2().getCasa(0).getSementes();
		
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
