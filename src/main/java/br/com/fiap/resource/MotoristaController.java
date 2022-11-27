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

import br.com.fiap.bo.MotoristaBO;
import br.com.fiap.bo.MotoristaService;
import br.com.fiap.to.MotoristaTO;

@Path("/motorista")
public class MotoristaController {

	MotoristaService ms = new MotoristaBO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarMotorista(MotoristaTO motorista, @Context UriInfo uriInfo) {

		// INSERIR NA BASE
		if (ms.insert(motorista) == null) {
			if(motorista.getNome().length() > 20) {
				return Response.status(400, "O nome não pode ter mais de 20 caracteres").build();
			}if (motorista.getIdade() > 99) {
				return Response.status(400, "A idade do motorista não pode ser maior que 99 anos").build();
			}	
		}

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path("Criado");
		
		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MotoristaTO> buscar() {
		return ms.buscar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MotoristaTO buscar(@PathParam("id") Long idMotorista ) {
		return ms.buscar(idMotorista);
	}
	
	@DELETE
	@Path("/{idMotorista}")
	public void excluir(@PathParam("idMotorista") Long idMotorista) {
		ms.deletar(idMotorista);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(MotoristaTO motorista, @PathParam("id") Long id) {
		motorista.setIdMotorista(id);
		ms.atualizar(motorista);
		return Response.ok().build();
	}
}
