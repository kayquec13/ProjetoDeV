package br.com.controleFuncionarios.exercicio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="TB_FUNCIONARIOS")
public class Funcionario {
	@Id
	@Column(name="ID_FUNCIONARIO")
	private Integer id;
	@Column(name="NOME")
	private String nome;
	@ManyToOne
	@JoinColumn(name="ID_CARGO")
	private Cargo cargo;

	public Funcionario() {
	}

	public Funcionario(String nome, Cargo cargo) {
		this.nome = nome;
		this.cargo = cargo;
	}

	public Funcionario(Integer id, String nome, Cargo cargo) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Funcionario ID: " + id + " Nome: " + nome + cargo;
	}

}
