package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.conexao.ConexaoSingleton;
import br.com.fiap.to.UsuarioTO;

public class UsuarioDAO {

	/**
	 * Cadastra um usuário na base de dados
	 * @author lbraga
	 * @param usuario Objeto contendo as informações do usuário que será cadastrado
	 * @return O usuário cadastrado
	 */
	public UsuarioTO inserir(UsuarioTO usuario) {
		try {

			String sql = "INSERT INTO USUARIO(" + " LOGIN_USUARIO," + " SENHA_USUARIO," + " TIPO_USUARIO,"
					+ " STATUS_USUARIO)" + "VALUES (?, ?, ?, ?)";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getLoginUsuario());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getTipoUsuario());
			ps.setString(4, String.valueOf(usuario.getStatusUsuario()));

			if (ps.executeUpdate() > 0) {
				conn.close();
				return usuario;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Busca todos os usuários cadastrados na base de dados
	 * @author lbraga
	 * @return A lista de todos os usuários encontrados
	 */
	public List<UsuarioTO> buscar() {
		try {
			List<UsuarioTO> usuarios = new ArrayList<>();

			String sql = "SELECT * FROM USUARIO";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long idUsuario = rs.getLong("ID_USUARIO");
				String loginUsuario = rs.getString("LOGIN_USUARIO");
				String aux = String.valueOf("STATUS_USUARIO");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				Character statusUsuario = aux.charAt(0);
				String tipoUsuario = rs.getString("TIPO_USUARIO");
				String senhaUsuario = rs.getString("SENHA_USUARIO");

				usuarios.add(
						new UsuarioTO(idUsuario, loginUsuario, dataRegistro, statusUsuario, tipoUsuario, senhaUsuario));
			}
			conn.close();
			return usuarios;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	/**
	 * Busca um usuário de acordo com o login dele
	 * @author lbraga
	 * @param lgUsuario Login do usuário a ser buscado
	 * @return O usuário encontrado
	 */
	public UsuarioTO buscar(String lgUsuario) {
		try {

			String sql = "SELECT * FROM USUARIO WHERE LOGIN_USUARIO = ?";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, lgUsuario);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Long idUsuario = rs.getLong("ID_USUARIO");
				String loginUsuario = rs.getString("LOGIN_USUARIO");
				String aux = rs.getString(String.valueOf("STATUS_USUARIO"));
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				Character statusUsuario = aux.charAt(0);
				String tipoUsuario = rs.getString("TIPO_USUARIO");
				String senhaUsuario = rs.getString("SENHA_USUARIO");
				conn.close();
				return new UsuarioTO(idUsuario, loginUsuario, dataRegistro, statusUsuario, tipoUsuario, senhaUsuario);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	/**
	 * Deleta um usuário de acordo com o ID eviado
	 * @author lbraga
	 * @param idUsuario Identificação do usuario que será deletado
	 */
	public void deletar(Long idUsuario) {
		String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, idUsuario);

			ps.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Atualiza as informações do usuário
	 * @author lbraga
	 * @param usuario Objeto contendo as informações a serem atualizadas
	 */
	public void atualizar(UsuarioTO usuario) {
		String sql = "UPDATE USUARIO " + "   SET LOGIN_USUARIO = ?, " + "   SENHA_USUARIO = ?, "
				+ "   STATUS_USUARIO = ?, " + "	  TIPO_USUARIO = ?, " + "   WHERE ID_USUARIO = ? ";

		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, usuario.getLoginUsuario());
			ps.setString(2, String.valueOf(usuario.getStatusUsuario()));
			ps.setString(3, usuario.getTipoUsuario());
			ps.setString(4, usuario.getSenha());
			ps.setLong(5, usuario.getIdUsuario());

			ps.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
