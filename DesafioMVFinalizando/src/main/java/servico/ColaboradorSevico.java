package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.GeralDao;
import dao.GeralDaoImpl;
import entidade.CafeManha;
import entidade.Colaborador;
import entidade.RetornoColaborador;


@Path("/colaborador")
public class ColaboradorSevico {

	private GeralDao geralDao = new GeralDaoImpl();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String texto() {
		return "Colaborador do Café";
	}
	
	@POST
	@Path("/inserirCliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoColaborador inserirCliente(Colaborador colaborador) {
		RetornoColaborador retorno = new RetornoColaborador();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso!!");
		if (geralDao.objExiste(colaborador) == null) {
			if (colaborador.getListaCafe() != null && colaborador.getListaCafe().size() > 0) {
				for (CafeManha cafe : colaborador.getListaCafe()) {
					cafe.setColaborador(colaborador);
				}
			}
			geralDao.inserir(colaborador);
			
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("Erro: Cliente já existente!");
		}

		return retorno;
	}
	
	@GET
	@Path("/pesquisarCliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoColaborador pesquisarCliente(@QueryParam("cpf") String cpf) {
		RetornoColaborador retorno = new RetornoColaborador();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso!");
		
		Colaborador colaborador = new Colaborador();
		colaborador.setCpf(cpf);
		
//		retorno.setListaColaborador(geralDao.consulta(colaborador));
		
		
		if(retorno.getListaColaborador() != null && retorno.getListaColaborador().size() > 0) {
			for (Colaborador c : retorno.getListaColaborador()) {
				if(c.getListaCafe() != null && c.getListaCafe().size() > 0) {
					for (CafeManha cafe : c.getListaCafe()) {
						cafe.setColaborador(null);
					}
				}
			}
		}
		
		return retorno;
	}

}
