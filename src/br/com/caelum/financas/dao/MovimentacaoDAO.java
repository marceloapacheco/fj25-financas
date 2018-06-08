package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDAO {

	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Movimentacao movimentacao) {
		em.persist(movimentacao);
	}
	
	public List<Movimentacao> listarTodas() {
		return this.em.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
	}
	
	public Movimentacao buscar(Long id) {
		return em.find(Movimentacao.class, id);
	}
	
	public void remover(Movimentacao movimentacao) {
		em.remove(movimentacao);
	}
	
}
