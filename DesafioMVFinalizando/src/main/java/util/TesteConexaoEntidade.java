package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.CafeManha;
import entidade.Colaborador;
public class TesteConexaoEntidade {

	public static void main(String[] args) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction t = ent.getTransaction();
		
		t.begin();

		Colaborador cb = new Colaborador();
		CafeManha cf =new CafeManha();
		CafeManha cf1 =new CafeManha();
		
		cb.setCpf("11122233345");
		cb.setNome("teste");
		ent.merge(cb);
		
		cf.setItemCafe("Café");
		cf.setColaborador(cb);
		ent.merge(cf);
		
//		cf1.setItemCafe("Pão");
//		cf1.setColaborador(cb);
//		ent.merge(cf);
		
		t.commit();
		ent.close();

	}

}
