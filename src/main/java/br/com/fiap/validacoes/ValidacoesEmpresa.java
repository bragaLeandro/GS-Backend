package br.com.fiap.validacoes;

public class ValidacoesEmpresa {
	
	/**
	 * Valida que o cnpj não seja maior que 18 caracteres
	 * @author lbraga
	 * @param cnpj
	 * @return
	 */
	public boolean valida(String cnpj) {
		if(cnpj.length() > 18) {
			return false;
		}
		return true;
	}
}
