package com.brunoalves.pacotes.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tb_hotel")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codHotel;
	private String nome;
	private String cidade;
	private BigDecimal diaria;
	
	@OneToMany(mappedBy="hotel")
	@JsonIgnore
	private List<Pacote> pacotes;
	
	public Hotel(){
		pacotes = new ArrayList<>();
	}

	public Hotel(Integer codHotel, String nome, String cidade, BigDecimal diaria) {
		super();
		this.codHotel = codHotel;
		this.nome = nome;
		this.cidade = cidade;
		this.diaria = diaria;
		pacotes = new ArrayList<>();
	}

	public Integer getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(Integer codHotel) {
		this.codHotel = codHotel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public BigDecimal getDiaria() {
		return diaria;
	}

	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
	
	public void addPacote(Pacote x){
		this.pacotes.add(x);
		x.setHotel(this);
	}
	
	public void removePacote(Pacote x){
		this.pacotes.remove(x);
	}
	

	@Override
	public String toString() {
		return "Hotel [codHotel=" + codHotel + ", nome=" + nome + ", cidade=" + cidade + ", diaria=" + diaria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codHotel == null) ? 0 : codHotel.hashCode());
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
		Hotel other = (Hotel) obj;
		if (codHotel == null) {
			if (other.codHotel != null)
				return false;
		} else if (!codHotel.equals(other.codHotel))
			return false;
		return true;
	}
	
	
	
	
	
}
