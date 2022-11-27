package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.to.MotoristaTO;
import br.com.fiap.validacoes.ValidacoesMotorista;

public class MotoristaBO implements MotoristaService {
	
	ValidacoesMotorista validacoes = new ValidacoesMotorista();
	
	/**
	 * Método que insere um motorista na base de dados
	 * @author lbraga
	 * @param motorista É o objeto necessário para colocar no banco de dados
	 * @return MotoristaTO Retorna o objeto motorista
	 */
	@Override
	public MotoristaTO insert(MotoristaTO motorista) {
		if(!validacoes.valida(motorista.getIdade())) {
			return null;
		}if(!validacoes.valida(motorista.getNome().length())) {
			return null;
		}if (!validacoes.validaCpf(motorista.getCpf())) {
			return null;
		}
		MotoristaDAO mt = new MotoristaDAO();
		return mt.inserir(motorista);
	}

	/**
	 * Método que busca todos os motoristas cadastrados na base de dados
	 * @author lbraga
	 * @return List<MotoristaTO> retorna uma lista com todos os motoristas encontrados no banco.
	 */
	@Override
	public List<MotoristaTO> buscar() {
		MotoristaDAO mt = new MotoristaDAO();
		return mt.buscar();
	}

	/**
	 * Método que busca um motorista específico de acordo com o CPF
	 * @author lbraga
	 * @param cpfMotorista CPF do motorista que está sendo buscado
	 * @return MotoristaTO retorna o motorista encontrado na base de dados
	 */
	@Override
	public MotoristaTO buscar(Long idMotorista) {
		MotoristaDAO mt = new MotoristaDAO();
		return mt.buscar(idMotorista);
	}

	/**
	 * Método que deleta um motorista específico de acordo com o ID dele
	 * @param idMotorista identificação do motorista que será deletado
	 * @author lbraga
	 */
	@Override
	public void deletar(Long idMotorista) {
		MotoristaDAO mt = new MotoristaDAO();
		mt.deletar(idMotorista);
	}

	/**
	 * Método que atualiza o cadastro de um motorista
	 * @author lbraga
	 * @param motorista Objeto com as informações do motorista que será atualizado
	 */
	@Override
	public void atualizar(MotoristaTO motorista) {
		MotoristaDAO mt = new MotoristaDAO();
		mt.atualizar(motorista);
	}
}
