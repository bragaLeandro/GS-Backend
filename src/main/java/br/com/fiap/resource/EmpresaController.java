package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.EmpresaBO;
import br.com.fiap.bo.EmpresaService;
import br.com.fiap.to.EmpresaTO;

@Path("/empresa")
public class EmpresaController {

	EmpresaService es = new EmpresaBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarMotorista(EmpresaTO empresa, @Context UriInfo uriInfo) {

		// INSERIR NA BASE
		if (es.insert(empresa) == null) {
			return Response.status(400).build();
		}

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path("Criado");
		
		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmpresaTO> buscar() {
		return es.buscar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpresaTO buscar(@PathParam("id") Long idEmpresa ) {
		return es.buscar(idEmpresa);
	}
	
	@DELETE
	@Path("/{idEmpresa}")
	public void excluir(@PathParam("idEmpresa") Long idEmpresa) {
		es.deletar(idEmpresa);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(EmpresaTO empresa, @PathParam("id") Long id) {
		empresa.setIdEmpresa(id);
		es.atualizar(empresa);
		return Response.ok().build();
	}
}
