package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteListagemConta {

	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDAO contaDao = new ContaDAO(manager);
		
		List<Conta> contas = contaDao.listarTodas();
		
		for (Conta conta : contas) {
			System.out.println("Conta encontrada: " + conta.getTitular());
		}
		
		manager.close();
	}
	
}
