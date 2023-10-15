package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Tabuleiro extends JFrame{
	public Tabuleiro() {
		Armazem teste = new Armazem();
		
		this.setLayout(new BorderLayout());
		this.setSize(300, 300);
		this.add(teste, BorderLayout.WEST);
		this.setVisible(true);
	}
}
