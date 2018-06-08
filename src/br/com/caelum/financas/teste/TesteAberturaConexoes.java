package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TesteAberturaConexoes {

	public static void main(String args[]) {
			
		for (int i=0; i<20; i++) {
			EntityManager manager = new JPAUtil().getEntityManager();
			manager.getTransaction().begin();
			System.out.println("Criado Entity Manager número " + i);
		}
		
		try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
