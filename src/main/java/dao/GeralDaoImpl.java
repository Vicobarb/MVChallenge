package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Colaborador;
import util.JpaUtil;

public class GeralDaoImpl implements GeralDao {

	@Override
	public void inserir(Object obj) {
		EntityManager entM = JpaUtil.getEntityManager();
		EntityTransaction entT = entM.getTransaction();

		entT.begin();
		entM.persist(obj);
		entT.commit();
		entM.close();

	}

	@Override
	public void alterar(Object obj) {

		EntityManager entM = JpaUtil.getEntityManager();
		EntityTransaction entT = entM.getTransaction();

		entT.begin();
		entM.merge(obj);
		entT.commit();
		entM.close();
	}

	@Override
	public Object remover(Object obj, Object chavePrimaria) {
		EntityManager entM = JpaUtil.getEntityManager();
		EntityTransaction entT = entM.getTransaction();
		Object retorno = null;

		entT.begin();
		retorno = entM.find(obj.getClass(), chavePrimaria);
		entM.remove(retorno);
		System.out.println("Deletado com sucesso");
		entT.commit();
		entM.close();
		return retorno;

	}

	@Override
	public List<Object> listar(Object obj) {
		EntityManager entM = JpaUtil.getEntityManager();
		Query query = entM.createQuery("from " + obj.getClass().getSimpleName());
		List<Object> lista = query.getResultList();
		entM.close();
		return lista;
	}
	
	@Override
	public Object objExiste(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();

		Object existe = ent.find(Object.class, obj.equals(obj));

		ent.close();

		return existe;
	}

}
