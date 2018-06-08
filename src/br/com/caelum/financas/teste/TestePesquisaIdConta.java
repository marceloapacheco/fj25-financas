package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestePesquisaIdConta {

	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO contaDao = new ContaDAO(manager);
		Conta conta = contaDao.buscar(new Long(1));
		System.out.println("Conta encontrada: " + conta.getTitular());
		manager.close();
		
	}
	
}
