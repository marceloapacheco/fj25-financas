package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CONTA_GENERATOR")
	@TableGenerator (name = "CONTA_GENERATOR", table = "GENERATOR_TABLE", pkColumnValue = "CONTA")
	private Long id;
	
	private String titular;
	private String banco;
	private String agencia;
	private String numero;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getBanco() {
		return banco;
	}
	
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", titular=" + titular + ", banco=" + banco + ", agencia=" + agencia + ", numero="
				+ numero + "]";
	}
	
}
