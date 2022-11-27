package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.to.EmpresaTO;
import br.com.fiap.validacoes.ValidacoesEmpresa;

public class EmpresaBO implements EmpresaService{

	ValidacoesEmpresa validacoes = new ValidacoesEmpresa();
	
	/**
	 * Cadastra uma empresa se passar pelas validações
	 * @author lbraga
	 * @param empresa Objeto contendo as informações da empresa que será cadastrada
	 * @return A empresa cadastrada
	 */
	@Override
	public EmpresaTO insert(EmpresaTO empresa) {
		if(!validacoes.valida(empresa.getCnpj())) {
			return null;
		}
		EmpresaDAO ed = new EmpresaDAO();
		return ed.inserir(empresa);
	}

	/**
	 * Busca todas as empresas cadastradas na base de dados
	 * @author lbraga
	 * @return A lista de todas empresas encontradas
	 */
	@Override
	public List<EmpresaTO> buscar() {
		EmpresaDAO ed = new EmpresaDAO();
		return ed.buscar();
	}

	/**
	 * Busca uma empresa específica de acordo com o CNPJ dela
	 * @author lbraga
	 * @param cnpjEmpresa CNPJ da empresa que será buscada
	 * @return A empresa encontrada
	 */
	@Override
	public EmpresaTO buscar(Long idEmpresa) {
		EmpresaDAO ed = new EmpresaDAO();
		return ed.buscar(idEmpresa);
	}

	/**
	 * Deleta uma empresa de acordo com o ID enviado
	 * @author lbraga
	 * @param idEmpresa Identificação da empresa que será deletada
	 */
	@Override
	public void deletar(Long idEmpresa) {
		EmpresaDAO ed = new EmpresaDAO();
		ed.deletar(idEmpresa);
	}

	/**
	 * Atualiza informações de uma empresa
	 * @author lbraga
	 * @param empresa Objeto contendo informações da empresa que srerá atualizada
	 */
	@Override
	public void atualizar(EmpresaTO empresa) {
		EmpresaDAO ed = new EmpresaDAO();
		ed.atualizar(empresa);
	}

}
