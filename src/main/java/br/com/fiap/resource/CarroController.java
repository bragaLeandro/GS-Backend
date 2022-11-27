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

import br.com.fiap.bo.CarroBO;
import br.com.fiap.bo.CarroService;
import br.com.fiap.to.CarroTO;

@Path("/carro")
public class CarroController {
	
	CarroService cs = new CarroBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarMotorista(CarroTO carro, @Context UriInfo uriInfo) {

		// INSERIR NA BASE
		if (cs.insert(carro) == null) {
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
	public List<CarroTO> buscar() {
		return cs.buscar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CarroTO buscar(@PathParam("id") Long idCarro ) {
		return cs.buscar(idCarro);
	}
	
	@DELETE
	@Path("/{idCarro}")
	public void excluir(@PathParam("idCarro") Long idCarro) {
		cs.deletar(idCarro);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(CarroTO carro, @PathParam("id") Long id) {
		carro.setIdCarro(id);
		cs.atualizar(carro);
		return Response.ok().build();
	}

}
