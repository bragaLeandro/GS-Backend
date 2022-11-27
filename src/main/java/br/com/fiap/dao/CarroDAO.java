package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.conexao.ConexaoSingleton;
import br.com.fiap.to.CarroTO;

public class CarroDAO {
	
	/**
	 * Insere um objeto carro na base de dados
	 * @author lbraga
	 * @param carro Objeto que será inserido na base de dados
	 * @return O objeto carro.
	 */

	public CarroTO inserir(CarroTO carro) {
		try {

			String sql = "INSERT INTO CARRO (EMPRESA_ID_EMPRESA, MARCA, MODELO, ANO)"
					+ "VALUES (?, ?, ?, ?)";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, carro.getIdEmpresa());
			ps.setString(2, carro.getMarca());
			ps.setString(3, carro.getModelo());
			ps.setInt(4, carro.getAno());

			if (ps.executeUpdate() > 0) {
				conn.close();
				return carro;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Busca todos os carros cadastrados na base de dados
	 * @author lbraga
	 * @return Todos carros cadastrados
	 */
	public List<CarroTO> buscar() {
		try {
			List<CarroTO> carros = new ArrayList<>();

			String sql = "SELECT * FROM CARRO";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long idEmpresa = rs.getLong("EMPRESA_ID_EMPRESA");
				Long idCarro = rs.getLong("ID_CARRO");
				String marca = rs.getString("MARCA");
				String modelo = rs.getString("MODELO");
				Integer ano = rs.getInt("ANO");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				
				carros.add(
						new CarroTO(idEmpresa, idCarro, marca, modelo, ano, dataRegistro));
			}
			conn.close();
			return carros;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	/**
	 * Busca um carro de acordo com o ID cadastrado do mesmo
	 * @author lbraga
	 * @param identCarro Id do carro, que é a primary key da base de dados
	 * @return O carro encontrado
	 */
	public CarroTO buscar(Long identCarro) {
		try {

			String sql = "SELECT * FROM CARRO WHERE ID_CARRO = ?";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, identCarro);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Long idEmpresa = rs.getLong("EMPRESA_ID_EMPRESA");
				Long idCarro = rs.getLong("ID_CARRO");
				String marca = rs.getString("MARCA");
				String modelo = rs.getString("MODELO");
				Integer ano = rs.getInt("ANO");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				
				conn.close();
				return new CarroTO(idEmpresa, idCarro, marca, modelo, ano, dataRegistro);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	/**
	 * Deleta um carro da base de dados de acordo com o ID enviado
	 * @author lbraga
	 * @param idCarro
	 */
	public void deletar(Long idCarro) {
		String sql = "DELETE FROM CARRO WHERE ID_CARRO = ?";
		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, idCarro);

			ps.execute();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Atualiza a empresa na qual o carro pertence
	 * @author lbraga
	 * @param carro Objeto que será enviado com a informação que será atualizada
	 */
	public void atualizar(CarroTO carro) {
		String sql = "UPDATE CARRO " 
					+ "SET EMPRESA_ID_EMPRESA = ?," 
					+ "MARCA = ?,"
					+ "MODELO = ?," 
					+ "ANO = ?" 
					+" WHERE ID_CARRO = ? ";

		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, carro.getIdEmpresa());
			ps.setString(2, carro.getMarca());
			ps.setString(3, carro.getModelo());
			ps.setInt(4, carro.getAno());
			ps.setLong(5, carro.getIdCarro());

			ps.execute();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
