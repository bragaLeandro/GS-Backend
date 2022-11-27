package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.to.CarroTO;

public interface CarroService {

	CarroTO insert(CarroTO carro);
	List<CarroTO> buscar();
	CarroTO buscar(Long idCarro);
	void deletar(Long idCarro);
	void atualizar(CarroTO carro);
}
