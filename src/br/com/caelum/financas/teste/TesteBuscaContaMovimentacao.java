package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaContaMovimentacao {

	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(manager);
		
		Movimentacao movimentacao = movimentacaoDao.buscar(new Long(1));
		
		System.out.println("Titular da Conta: " + movimentacao.getConta().getTitular());
		manager.close();
		
	}
	
}
