package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.to.MotoristaTO;

public interface MotoristaService {

	MotoristaTO insert(MotoristaTO motorista);
	List<MotoristaTO> buscar();
	MotoristaTO buscar(Long idMotorista);
	void deletar(Long idMotorista);
	void atualizar(MotoristaTO motorista);
}
