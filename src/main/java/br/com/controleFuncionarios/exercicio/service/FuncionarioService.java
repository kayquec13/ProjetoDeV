package br.com.controleFuncionarios.exercicio.service;

import java.util.List;

import br.com.controleFuncionarios.exercicio.entities.Cargo;
import br.com.controleFuncionarios.exercicio.entities.Funcionario;
import br.com.controleFuncionarios.exercicio.repository.CargoRepository;
import br.com.controleFuncionarios.exercicio.repository.FuncionarioRepository;

public class FuncionarioService {

	private FuncionarioRepository funcionarioRepository;
	private FuncionarioService funcionarioService;
	private CargoRepository cargoRepository;
	
	public FuncionarioService() {
		this.funcionarioRepository = new FuncionarioRepository();
		this.funcionarioService = new FuncionarioService();
		this.cargoRepository = new CargoRepository();
	}

	public FuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
	}

	public FuncionarioRepository getFuncionarioRepository() {
		return funcionarioRepository;
	}

	public void setFuncionarioRepository(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public CargoRepository getCargoRepository() {
		return cargoRepository;
	}

	public void setCargoRepository(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public List<Funcionario> findAll() {
		List<Funcionario> funcionarios = this.funcionarioRepository.findAll() ;
		return	funcionarios;
	}

	public Funcionario findById(Integer id) {		
		return this.funcionarioRepository.findById(id);
	}

	public void inserindoFuncionario(String nome, Integer idCargo) {
		Cargo cargo = this.cargoRepository.findById(idCargo);
		Funcionario funcionario = new Funcionario(nome,cargo);
		this.funcionarioRepository.inserindoFuncionario(funcionario);		
	}

	public void alterFuncionario(Integer idFuncionario,String nome, Integer idCargo) {
		Cargo cargo = this.cargoRepository.findById(idCargo);
		Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario);
		funcionario.setNome(nome);
		funcionario.setCargo(cargo);
		this.funcionarioRepository.alterFuncionario(funcionario);
	}

	public void deleteById(Integer idFuncionario) {
		this.funcionarioRepository.deleteById(idFuncionario);
	}

}
