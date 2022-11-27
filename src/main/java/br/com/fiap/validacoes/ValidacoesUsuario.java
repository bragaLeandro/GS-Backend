package br.com.fiap.validacoes;

public class ValidacoesUsuario {

	/**
	 * Valida que o login não seja maior que 20 caracteres
	 * @author lbraga
	 * @param login
	 * @return false se for maior que 20 caracteres
	 */
	public boolean valida(String login) {
		if (login.length() > 20) {
			return false;
		}
		return true;
	}

	/**
	 * Valida que a senha não seja menor que 6 caracteres
	 * @author lbraga
	 * @param senha A senha que será validada
	 * @return false se for menor que 6 caracteres
	 */
	public boolean validaSenha(String senha) {
		if (senha.length() < 6) {
			return false;
		}
		return true;
	}
}
