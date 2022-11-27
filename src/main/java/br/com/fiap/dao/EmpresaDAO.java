package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.conexao.ConexaoSingleton;
import br.com.fiap.to.EmpresaTO;

public class EmpresaDAO {

	/**
	 * Cadastra uma empresa na base de dados
	 * @author lbraga
	 * @param empresa Objeto contendo as informações da empresa cadastrada
	 * @return A empresa cadastrada
	 */
	public EmpresaTO inserir(EmpresaTO empresa) {
		try {

			String sql = "INSERT INTO EMPRESA (CNPJ, RAZAO_SOCIAL, NOME_FANTASIA, DATA_FUNDACAO)"
					+ "VALUES (?, ?, ?, ?)";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getRazaoSocial());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setDate(4, new java.sql.Date(empresa.getDataFundacao().getTime()));

			if (ps.executeUpdate() > 0) {
				conn.close();
				return empresa;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Busca todas as empresas cadastradas na base de dados
	 * @author lbraga
	 * @return Todas empresas encontradas
	 */
	public List<EmpresaTO> buscar() {
		try {
			List<EmpresaTO> empresas = new ArrayList<>();

			String sql = "SELECT * FROM EMPRESA";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long idEmpresa = rs.getLong("ID_EMPRESA");
				String cnpj = rs.getString("CNPJ");
				String razaoSocial = rs.getString("RAZAO_SOCIAL");
				String nomeFantasia= rs.getString("NOME_FANTASIA");
				Date dataFundacao = rs.getDate("DATA_FUNDACAO");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				
				empresas.add(
						new EmpresaTO(idEmpresa, cnpj, razaoSocial, nomeFantasia, dataFundacao, dataRegistro));
			}
			conn.close();
			return empresas;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	/**
	 * Busca uma empresa de acordo com o CNPJ informado
	 * @author lbraga
	 * @param cnpjEmpresa CNPJ da empresa que será buscada
	 * @return A empresa encontrada
	 */
	public EmpresaTO buscar(Long idEmpres) {
		try {

			String sql = "SELECT * FROM EMPRESA WHERE ID_EMPRESA = ?";

			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, idEmpres);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Long idEmpresa = rs.getLong("ID_EMPRESA");
				String cnpj = rs.getString("CNPJ");
				String razaoSocial = rs.getString("RAZAO_SOCIAL");
				String nomeFantasia= rs.getString("NOME_FANTASIA");
				Date dataFundacao = rs.getDate("DATA_FUNDACAO");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				
				conn.close();
				return new EmpresaTO(idEmpresa, cnpj, razaoSocial, nomeFantasia, dataFundacao, dataRegistro);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Deleta uma empresa de acordo com o ID enviado
	 * @author lbraga
	 * @param idEmpresa Identificação da empresa que será deletada
	 */
	public void deletar(Long idEmpresa) {
		String sql = "DELETE FROM EMPRESA WHERE ID_EMPRESA = ?";
		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, idEmpresa);

			ps.execute();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Atualiza os dados de uma empresa
	 * @author lbraga
	 * @param empresa Objeto empresa que será atualizado
	 */
	public void atualizar(EmpresaTO empresa) {
		String sql = "UPDATE EMPRESA " + "   SET CNPJ = ?, " + "   RAZAO_SOCIAL = ?, "
				+ "   NOME_FANTASIA = ?, " + "DATA_FUNDACAO = ?" + " WHERE ID_EMPRESA = ? ";

		try {
			Connection conn = ConexaoSingleton.getInstance().abrirConexao();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getRazaoSocial());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setDate(4, new java.sql.Date(empresa.getDataFundacao().getTime()));
			ps.setLong(5, empresa.getIdEmpresa());


			ps.execute();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
