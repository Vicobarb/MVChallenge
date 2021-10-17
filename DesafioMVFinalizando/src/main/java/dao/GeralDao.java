package dao;

import java.util.List;

import entidade.Colaborador;
/**
 * 
 * @author Victor Silva Barbosa
 *
 */
public interface GeralDao {

	public void inserir(Object obj);
	public void alterar(Object obj);
	public Object remover(Object obj, Object chavePrimaria);
	public List<Object> listar(Object obj);
	public Object objExiste(Object obj);
	
}
