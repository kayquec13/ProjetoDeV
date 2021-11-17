package br.com.controleFuncionarios.exercicio.controller;

import java.util.List;

import br.com.controleFuncionarios.exercicio.entities.Funcionario;
import br.com.controleFuncionarios.exercicio.service.FuncionarioService;

public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	public FuncionarioController() {
		this.funcionarioService = new FuncionarioService();
	}

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void findAll() {
		List<Funcionario> funcionarios = this.funcionarioService.findAll();
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}

	public void findById(Integer id) {
		Funcionario funcionario = this.funcionarioService.findById(id);
		System.out.println(funcionario);
	}

	public void inserirFuncionario(String nome, Integer idCargo) {
		this.funcionarioService.inserindoFuncionario(nome, idCargo);
		System.out.println("Funcionario " + nome + " Inserido no sistema!");
	}

	public void alterFuncionario(Integer idFuncionario, String nome, Integer idCargo) {
		this.funcionarioService.alterFuncionario(idFuncionario, nome, idCargo);
		System.out.println("Funcionario " + nome + " Alterado no sistema!");
	}

	public void deleteById(Integer idFuncionario) {
		findById(idFuncionario);
		this.funcionarioService.deleteById(idFuncionario);
	}

}
