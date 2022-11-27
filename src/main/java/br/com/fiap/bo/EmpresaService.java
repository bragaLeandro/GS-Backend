package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.to.EmpresaTO;

public interface EmpresaService {

	EmpresaTO insert(EmpresaTO empresa);
	List<EmpresaTO> buscar();
	EmpresaTO buscar(Long idEmpresa);
	void deletar(Long idEmpresa);
	void atualizar(EmpresaTO empresa);
}
