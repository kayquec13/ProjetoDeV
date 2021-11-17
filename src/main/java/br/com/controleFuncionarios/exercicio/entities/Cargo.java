package br.com.controleFuncionarios.exercicio.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARGO")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CARGO")
	private Integer idCargo;
	@Column(name="NOME_CARGO")
	private String nomeCargo;
	@Column(name="SALARIO")
	private BigDecimal salario;

	public Cargo() {
	}

	public Cargo(String nomeCargo, BigDecimal salario) {
		super();
		this.nomeCargo = nomeCargo;
		this.salario = salario;
	}

	public Cargo(Integer idCargo, String nomeCargo, BigDecimal salario) {
		super();
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
		this.salario = salario;
	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return " | Cargo: " + nomeCargo + " Salario: " + salario + " ID: " + idCargo;
	}

}
