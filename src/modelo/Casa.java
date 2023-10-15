package modelo;

import util.Constantes;

public class Casa extends Armazem{	
	public Casa() {
		super(Constantes.INICIO_SEMENTES);
	}
	
	/**
	  * Adiciona uma sementes a uma casa
	  * 
	  * @author            Gabriel Sales
	  */
	@Override
	public void adicionarSemente() {
		if(this.sementes <= Constantes.MAX_SEMENTES_CASA)
			this.sementes++;
	}
	
	/**
	  * Remove uma semente de uma casa
	  * 
	  * @return            a quantidade de sementes removidas
	  * @author            Gabriel Sales
	  */
	public int removerSemente() {
		int sementeRemovida = 0;
		if(this.sementes > 0) {
			this.sementes--;
			sementeRemovida = 1;
		}
		
		return sementeRemovida;
	}
	
	/**
	  * Remove todas as sementes de uma casa
	  * 
	  * @return            a quantidade de sementes removidas
	  * @author            Gabriel Sales
	  */
	public int removerTodasAsSementes() {
		int sementesAntigas = this.sementes;
		this.sementes = 0;
		return sementesAntigas;
	}
}
