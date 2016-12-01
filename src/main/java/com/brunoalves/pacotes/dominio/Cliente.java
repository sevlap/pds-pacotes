package com.brunoalves.pacotes.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCliente;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private BigDecimal rendaMensal;
	
	@OneToMany(mappedBy="cliente")
	@JsonIgnore
	private List<Contrato> contratos;
	
	
	public Cliente(){
		contratos = new ArrayList<>();
	}

	public Cliente(Integer codCliente, String nome, String email, String telefone, String cpf, Date nascimento,
			BigDecimal rendaMensal) {
		super();
		this.codCliente = codCliente;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.rendaMensal = rendaMensal;
		contratos = new ArrayList<>();
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	
	public void addContrato(Contrato x){
		this.contratos.add(x);
		x.setCliente(this);
	}
	
	public void removeContrato(Contrato x){
		this.contratos.remove(x);
	}
	

	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", cpf=" + cpf + ", nascimento=" + nascimento + ", rendaMensal=" + rendaMensal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codCliente == null) {
			if (other.codCliente != null)
				return false;
		} else if (!codCliente.equals(other.codCliente))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
