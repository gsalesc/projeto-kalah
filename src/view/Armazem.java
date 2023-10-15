package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

public class Armazem extends JPanel{
	public Armazem() {
		this.setSize(300, 300);
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        
        // Calcule o raio do círculo externo
        int radius = Math.min(width, height) / 2;

        // Defina o centro do painel como o centro do círculo externo
        int centerX = width / 2;
        int centerY = height / 2;
        
        g.setColor(Color.ORANGE);
        g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, 10, 10);
        
        
        //List<String> pontas = Arrays.asList("")
        List<String> lados = Arrays.asList("CIMA, BAIXO, ESQUERDA, DIREITA");
        int indexLados = 0;
        int indexPontas = 0;
        
        for(int i = 0 ; i <= 5; i++) {
        	
        	if(i == 0) {
        		g.setColor(Color.BLUE);
                g.fillOval(centerX, centerY, 10, 10);
        	}
        	else if(i % 2 == 0) {
        		int diff = 10 * i;
        		g.setColor(Color.BLUE);
        		g.fillOval(centerX+diff, centerY+diff, 10, 10);
                g.setColor(Color.BLUE);
                g.fillOval(centerX-diff, centerY+diff, 10, 10);
                g.setColor(Color.BLUE);
                g.fillOval(centerX+diff, centerY-diff, 10, 10);
                g.setColor(Color.BLUE);
                g.fillOval(centerX-diff, centerY-diff, 10, 10);
        	} else {
        		g.fillOval(centerX, centerY+20, 10, 10);
                g.setColor(Color.BLUE);
                g.fillOval(centerX, centerY-20, 10, 10);
                g.setColor(Color.BLUE);
                g.fillOval(centerX+20, centerY, 10, 10);
                g.setColor(Color.BLUE);
                g.fillOval(centerX-20, centerY, 10, 10);
                g.setColor(Color.BLUE);
        	}
        }
        
        g.fillOval(centerX+10, centerY+10, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX-10, centerY+10, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX+10, centerY-10, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX-10, centerY-10, 10, 10);
        
        g.fillOval(centerX, centerY+20, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY-20, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX+20, centerY, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX-20, centerY, 10, 10);
        g.setColor(Color.BLUE);
        
        g.fillOval(centerX+30, centerY+30, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX-30, centerY+30, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX+30, centerY-30, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX-30, centerY-30, 10, 10);
        
        g.fillOval(centerX, centerY+40, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY-40, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX+40, centerY, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(centerX-40, centerY, 10, 10);
        g.setColor(Color.BLUE);
        
        
        // Desenhe círculos menores do centro para fora
        int numCircles = 10; // Defina o número de círculos menores
        
        for (int i = numCircles; i > 0; i--) {
            
        }
        
        // Desenhe o círculo externo por cima dos círculos menores

    }
}
