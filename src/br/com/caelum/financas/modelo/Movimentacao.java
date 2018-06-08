package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.TableGenerator;

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MOVIMENTACAO_GENERATOR")
	@TableGenerator (name = "MOVIMENTACAO_GENERATOR", table = "GENERATOR_TABLE", pkColumnValue = "MOVIMENTACAO")
	private Long id;
	
	private String descricao;
	
	private LocalDateTime data;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private Conta conta;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMotiventacao;
	
	private BigDecimal valor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoMovimentacao getTipoMotiventacao() {
		return tipoMotiventacao;
	}

	public void setTipoMotiventacao(TipoMovimentacao tipoMotiventacao) {
		this.tipoMotiventacao = tipoMotiventacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@PrePersist
	public void atualizaData() {
		this.data =  LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", descricao=" + descricao + ", data=" + data + ", conta=" + conta
				+ ", tipoMotiventacao=" + tipoMotiventacao + ", valor=" + valor + "]";
	}
	
	
	
}
