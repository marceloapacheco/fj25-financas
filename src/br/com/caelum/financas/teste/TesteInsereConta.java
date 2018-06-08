package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInsereConta {

	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDAO contaDao = new ContaDAO(manager);
		
		Conta conta = new Conta();
		conta.setTitular("Daniele Rocha");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		manager.getTransaction().begin();
		contaDao.salvar(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Conta gravada com sucesso!");
		
	}
	
}
