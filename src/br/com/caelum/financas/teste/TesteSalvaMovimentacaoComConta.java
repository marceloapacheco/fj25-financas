package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteSalvaMovimentacaoComConta {

	public static void main(String args[]) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(manager);
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setTitular("Daniele Rocha");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		//movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Conta de Água");
		movimentacao.setTipoMotiventacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("50"));
		
		movimentacaoDao.salvar(movimentacao);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
}
