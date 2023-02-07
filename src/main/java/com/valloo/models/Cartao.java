package com.valloo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cartao {

	@GeneratedValue
	@Id
	private int id;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="nome_usuario")
	private String nomeUsuario;
	
	@Column(name="codigo_seguranca")
	private String codigoSeguranca;
	
	@Column(name="data_validade")
	private Date dataValidade;

	public Cartao() {}
	public Cartao(int id, String numero, String nomeUsuario, Date dataValidade) {
		super();
		this.id = id;
		this.numero = numero;
		this.nomeUsuario = nomeUsuario;
		this.dataValidade = dataValidade;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	@Override
	public String toString() {
		return "Cartao [id=" + id + ", numero=" + numero + ", nomeUsuario=" + nomeUsuario + ", dataValidade="
				+ dataValidade + "]";
	}
	

}
