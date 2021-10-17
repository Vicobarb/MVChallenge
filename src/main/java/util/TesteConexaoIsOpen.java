package util;

import javax.persistence.EntityManager;

import util.JpaUtil;

public class TesteConexaoIsOpen {

	public static void main(String[] args) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		
		System.out.println(ent.isOpen());
	}

}
