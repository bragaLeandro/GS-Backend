package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.conexao.ConexaoSingleton;
import br.com.fiap.to.MotoristaTO;

public class MotoristaDAO {

	/**
	 * Cadastra um motorista na base de dados
	 * @author lbraga
	 * @param motorista Objeto contendo as informações do motorista que será cadastrado
	 * @return O motorista cadastrado
	 */
	public MotoristaTO inserir(MotoristaTO motorista) {
		try {
			String sqlMotorista = "INSERT INTO MOTORISTA (NOME, SOBRENOME, CNH, CPF, RG, IDADE)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();
			
			PreparedStatement ps = conn.prepareStatement(sqlMotorista);

			ps.setString(1, motorista.getNome());
			ps.setString(2, motorista.getSobrenome());
			ps.setString(3, motorista.getCnh());
			ps.setString(4, motorista.getCpf());
			ps.setString(5, motorista.getRg());
			ps.setInt(6, motorista.getIdade());


			if (ps.executeUpdate() > 0) {
				return motorista;
			}
			
			conn.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * Busca todas os motoristas cadastrados na base de dados
	 * @author lbraga
	 * @return A lista de todos os motoristas encontrados
	 */
	public List<MotoristaTO> buscar() {
		try {
			List<MotoristaTO> motoristas = new ArrayList<>();

			String sql = "SELECT * FROM MOTORISTA";
			
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long idMotorista = rs.getLong("ID_MOTORISTA");
				String nome = rs.getString("NOME");
				String sobrenome = rs.getString("SOBRENOME");
				String cnh = rs.getString("CNH");
				String cpf = rs.getString("CPF");
				String rg = rs.getString("RG");
				Integer idade = rs.getInt("IDADE");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");

				motoristas.add(new MotoristaTO(idMotorista, nome, sobrenome, cnh, cpf, rg, idade, dataRegistro));
			}
			
			conn.close();
			return motoristas;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Deleta um motorista de acordo com o ID dele
	 * @author lbraga
	 * @param idMotorista Identificação do motorista a ser deletado
	 */
	public void deletar(Long idMotorista) {
		String sql = "DELETE FROM MOTORISTA WHERE ID_MOTORISTA = ?";
		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, idMotorista);
			
			ps.execute();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Atualiza as informações do motorista
	 * @author lbraga
	 * @param motorista Objeto contendo as informações a serem atualizadas
	 */
	public void atualizar(MotoristaTO motorista) {
		String sql = "UPDATE MOTORISTA "
				+ "   SET NOME = ?, "
				+ "   SOBRENOME = ?, "
				+ "	  CNH = ?, "
				+ "   CPF = ?, "
				+ "   RG = ?, "
				+ "   IDADE = ?"
				+ "   WHERE ID_MOTORISTA = ?"; 
		
		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, motorista.getNome());
			ps.setString(2, motorista.getSobrenome());
			ps.setString(3, motorista.getCnh());
			ps.setString(4, motorista.getCpf());
			ps.setString(5, motorista.getRg());	
			ps.setInt(6, motorista.getIdade());
			ps.setLong(7, motorista.getIdMotorista());
			
			ps.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Busca um motorista de acordo com o CPF dele
	 * @author lbraga
	 * @param cpfMotorista CPF do motorista a ser buscado
	 * @return O motorista encontrado
	 */
	public MotoristaTO buscar(Long idMotoris) {
		
		String sql = "SELECT * FROM MOTORISTA WHERE ID_MOTORISTA = ?";
		
		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, idMotoris);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Long idMotorista = rs.getLong("ID_MOTORISTA");
				String nome = rs.getString("NOME");
				String sobrenome = rs.getString("SOBRENOME");
				String cnh = rs.getString("CNH");
				String cpf = rs.getString("CPF");
				String rg = rs.getString("RG");
				Integer idade = rs.getInt("IDADE");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				
				conn.close();
				return new MotoristaTO(idMotorista, nome, sobrenome, cnh, cpf, rg, idade, dataRegistro);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
