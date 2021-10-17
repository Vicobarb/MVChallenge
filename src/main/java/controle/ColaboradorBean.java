package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.GeralDaoImpl;
import entidade.CafeManha;
import entidade.Colaborador;

@ManagedBean(name = "colaboradorBean")
@RequestScoped
public class ColaboradorBean {

	private Colaborador colaborador;
	private CafeManha cafe;
	private GeralDaoImpl geralDao;
	private List<Object> listaColaborador;
	
	public ColaboradorBean() {
		this.colaborador =new Colaborador();
		this.cafe= new CafeManha();
		this.geralDao = new GeralDaoImpl();
		this.listaColaborador = new ArrayList<Object>();
	}
	
	//metodos
	public void adicionar() {
		this.geralDao.inserir(this.colaborador);
		cafe.setColaborador(colaborador);
		this.geralDao.inserir(this.cafe);
	}

	public void pesquisar() {
		this.listaColaborador = geralDao.listar((Object) this.colaborador);
	}

	public void editar() {
		this.geralDao.alterar(this.colaborador);
	}

	public void remover() {
		this.geralDao.remover(this.colaborador, getColaborador());
	}
	
	//get set
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public CafeManha getCafe() {
		return cafe;
	}
	public void setCafe(CafeManha cafe) {
		this.cafe = cafe;
	}

	public GeralDaoImpl getGeralDao() {
		return geralDao;
	}
	public void setGeralDao(GeralDaoImpl geralDao) {
		this.geralDao = geralDao;
	}

	public List<Object> getListaColaborador() {
		return listaColaborador;
	}

	public void setListaColaborador(List<Object> listaColaborador) {
		this.listaColaborador = listaColaborador;
	}




		
}
