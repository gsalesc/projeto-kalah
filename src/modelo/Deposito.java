package modelo;

import util.Constantes;

public class Deposito extends Armazem{
	public Deposito() {

	}
	/**
	  * Adiciona uma semente ao deposito
	  * 
	  * @author            Gabriel Sales
	  */
	@Override
	public void adicionarSemente() {
		if(this.sementes <= Constantes.MAX_SEMENTES)
			this.sementes++;
	}
	
	/**
	  * Adiciona uma certa quantidade de sementes ao deposito
	  * 
	  * @param			   quantidade de sementes de ser adicionada
	  * @author            Gabriel Sales
	  */
	public void adicionarSementes(int qtd) {
		if((this.sementes+qtd) <= Constantes.MAX_SEMENTES)
			this.sementes = this.sementes + qtd;
	}
}
