package modelo;

public class Armazem {
	protected int sementes;
	
	public Armazem() {
	}
	
	public Armazem(int sementes) {
		this.sementes = sementes;
	}
	
	/**
	  * Adiciona uma sementes a uma casa
	  * 
	  * @author            Gabriel Sales
	  */
	public void adicionarSemente() {
		this.sementes++;
	}
	
	/**
	  * Adiciona uma sementes a uma casa
	  * 
	  * @return			   a quantidade de sementes de uma casa
	  * @author            Gabriel Sales
	  */
	public int getSementes() {
		return this.sementes;
	}
}
