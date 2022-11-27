package br.com.fiap.validacoes;

public class ValidacoesMotorista {

	/**
	 * Garante que a idade do motorista não seja maior que 99 anos
	 * @author lbraga
	 * @param idade Idade que será validada
	 * @return false se for maior que 99 anos. true se for menor ou igual que 99 anos
	 */
	public boolean valida(Integer idade) {
		if (idade > 99) {
			return false;
		}
		return true;
	}

	/**
	 * Garante que o nome do motorista não terá mais de 20 caracteres
	 * @author lbraga
	 * @param nome Nome que será validado
	 * @return false se estiver incorreto. true se estiver correto
	 */
	public boolean valida(String nome) {
		if (nome.length() > 20) {
			return false;
		}
		return true;
	}

	/**
	 * Faz uma validação simples sobre o tamanho do cpf
	 * @author lbraga
	 * @param cpf
	 * @return true se tiver correto. false se tiver incorreto
	 */
	public boolean validaCpf(String cpf) {
		if (cpf.length() < 11) {
			return false;
		}
		if (cpf.length() > 15) {
			return false;
		}
		return true;
	}
}
