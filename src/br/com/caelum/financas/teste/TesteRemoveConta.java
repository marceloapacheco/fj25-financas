package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteRemoveConta {

	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDAO contaDao = new ContaDAO(manager);
		
		manager.getTransaction().begin();
		Conta conta = contaDao.buscar(new Long(1));
		contaDao.remover(conta);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
}
