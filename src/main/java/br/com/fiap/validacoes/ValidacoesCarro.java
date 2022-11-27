package br.com.fiap.validacoes;

public class ValidacoesCarro {

	/**
	 * Valida que o tamanho de carecteres da marca não seja maior que 25
	 * @author lbraga
	 * @param marca
	 * @return false se for maior que 25
	 */
	public boolean validaMarca(String marca) {
		if(marca.length() > 25) {
			return false;
		}
		return true;
	}
	
	/**
	 * Valida que o tamanho de caracteres do modelo não seja maior que 40
	 * @author lbraga
	 * @param modelo
	 * @return false se for maior que 40
	 */
	public boolean validaModelo(String modelo) {
		if(modelo.length() > 40) {
			return false;
		}
		return true;
	}
}
