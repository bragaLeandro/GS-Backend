package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.to.CarroTO;
import br.com.fiap.validacoes.ValidacoesCarro;

public class CarroBO implements CarroService{
	
	ValidacoesCarro validacoes = new ValidacoesCarro();

	/**
	 * Faz o cadastro de um carro se passar das validacoes
	 * @author lbraga
	 * @param carro Carro que será cadastrado
	 * @return O carro cadastrado
	 */
	@Override
	public CarroTO insert(CarroTO carro) {
		if(!validacoes.validaMarca(carro.getMarca())) {
			return null;
		} if(!validacoes.validaModelo(carro.getModelo())) {
			return null;
		}
		CarroDAO cd = new CarroDAO();
		return cd.inserir(carro);
	}
	
	/**
	 * Busca todos os carros cadastrados
	 * @author lbraga
	 * @return Todos carros encontrados
	 */
	@Override
	public List<CarroTO> buscar() {
		CarroDAO cd = new CarroDAO();
		return cd.buscar();
	}

	/**
	 * Busca um carro de acordo com a identificação dele
	 * @author lbraga
	 * @param Id do carro
	 * @return O carro encontrado
	 */
	@Override
	public CarroTO buscar(Long idCarro) {
		CarroDAO cd = new CarroDAO();
		return cd.buscar(idCarro);
	}

	/**
	 * Deleta um carro cadastrado de acordo com o id dele
	 * @author lbraga
	 * @param idCarro Id do carro
	 */
	@Override
	public void deletar(Long idCarro) {
		CarroDAO cd = new CarroDAO();
		cd.deletar(idCarro);
	}

	/**
	 * Atualiza as informações de um carro
	 * @author lbraga
	 * @param carro Objeto contendo as informações do carro que será atualizado
	 */
	@Override
	public void atualizar(CarroTO carro) {
		CarroDAO cd = new CarroDAO();
		cd.atualizar(carro);
	}

}
