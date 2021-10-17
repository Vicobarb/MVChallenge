package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import antlr.collections.List;
import dao.GeralDao;
import dao.GeralDaoImpl;
import entidade.CafeManha;
import entidade.Colaborador;

public class TesteConexaoDao {

	public static void main(String[] args) {

		GeralDao dao = new GeralDaoImpl();
		Colaborador cb = new Colaborador();
		CafeManha cf =new CafeManha();
		CafeManha cf1 =new CafeManha();
		
		cb.setCpf("12345678900");
		cb.setNome("teste0");
		
		cf.setItemCafe("Mortadela");
		cf.setColaborador(cb);
		
		cf1.setItemCafe("Ovo");
		cf1.setColaborador(cb);
		
		dao.inserir(cb);
		dao.inserir(cf);
		dao.inserir(cf1);
		
		//listar todos os colaboradores
		System.out.println(dao.listar(cb));
		
	}

}
