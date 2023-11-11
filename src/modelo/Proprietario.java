package modelo;

import util.Constantes;

public class Proprietario {
	private Casa casas[];
	private Deposito deposito;
	
	public Proprietario() {
		casas = new Casa[Constantes.MAX_CASAS];
		deposito = new Deposito();
		
		for(int i = 0; i < casas.length; i++) {
			casas[i] = new Casa();
		}
	}
	
	public Casa[] getCasas() {
		return this.casas;
	}
	
	public Deposito getDeposito() {
		return this.deposito;
	}
	
	public Casa getCasa(int index) {
		return this.casas[index];
	}
	
	public int getSementesCasa(int casa) {
		return this.casas[casa].getSementes();
	}
	
	public int getSementesDeposito() {
		return this.deposito.getSementes();
	}
}
