package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDAO {

	private EntityManager em;
	
	public ContaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Conta conta) {
		em.persist(conta);
	}
	
	public List<Conta> listarTodas() {
		return this.em.createQuery("select c from Conta c", Conta.class).getResultList();
	}
	
	public Conta buscar(Long id) {
		return em.find(Conta.class, id);
	}
	
	public void remover(Conta conta) {
		em.remove(conta);
	}
	
}
