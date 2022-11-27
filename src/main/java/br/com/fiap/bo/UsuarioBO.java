package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;
import br.com.fiap.validacoes.ValidacoesUsuario;

public class UsuarioBO implements UsuarioService {
		
	ValidacoesUsuario validacoes = new ValidacoesUsuario();
	
	/**
	 * Faz o cadastro de um usuário se ele passar pelas validações
	 * @author lbraga
	 * @param usuario Objeto contendo as informações do usuário que será criado
	 * @return O usuário criado
	 */
	@Override
    public UsuarioTO insert(UsuarioTO usuario) {
		
		if(!validacoes.valida(usuario.getLoginUsuario())) {
			return null;
		} if(!validacoes.validaSenha(usuario.getSenha())) {
			return null;
		}
        UsuarioDAO ud = new UsuarioDAO();
        return ud.inserir(usuario);
    }
    
	/**
	 * Busca todos os usuários cadastrados
	 * @author lbraga
	 * @return Todos usuários cadastrados
	 */
    public List<UsuarioTO> buscar() {
    	UsuarioDAO ud = new UsuarioDAO();
    	return ud.buscar();
    }
    
    /**
     * Busca um usuário de acordo com o login
     * @author lbraga
     * @param usuario login do usuário
     * @return O usuário encontrado
     */
    public UsuarioTO buscar(String usuario) {
    	UsuarioDAO ud = new UsuarioDAO();
    	return ud.buscar(usuario);
    }
    
    /**
     * Deleta um usuario de acordo com o id enviado
     * @author lbraga
     * @param idUsuario Identificação do usuario que será deletado
     */
    public void deletar(Long idUsuario) {
    	UsuarioDAO ud = new UsuarioDAO();
    	ud.deletar(idUsuario);
    }
    
    /**
     * Atualiza um usuário no banco de dados
     * @author lbraga
     * @param usuario Objeto contendo as informações do usuário que será cadastrado
     */
    public void atualizar(UsuarioTO usuario) {
    	UsuarioDAO ud = new UsuarioDAO();
    	ud.atualizar(usuario);
    }
    
    /**
     * Valida o login e senha de um usuário ao realizar login
     * @author lbraga
     * @param usuario Usuario que será validado
     * @return false se o usuário não for autenticado
     */
    public boolean validaSenha(UsuarioTO usuario) {
    	UsuarioDAO ud = new UsuarioDAO();
    	UsuarioTO usuarioBanco = ud.buscar(usuario.getLoginUsuario());
    	
    	if (!usuarioBanco.getSenha().equals(usuario.getSenha())) {
    		return false;
    	}
    	return true;
    }
}
