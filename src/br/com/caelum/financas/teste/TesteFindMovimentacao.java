package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFindMovimentacao {

	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setAgencia("4981");
		conta.setBanco("Banco Itaú");
		conta.setNumero("03690-1");
		conta.setTitular("Roger Federer");
		
		//manager.persist(conta);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("conta de luz - 06/18");
		movimentacao.setTipoMotiventacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("34.23"));
		
		manager.persist(movimentacao);
	
		manager.getTransaction().commit();
		manager.close();
		
	}
	
}
