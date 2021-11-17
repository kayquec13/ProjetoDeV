package br.com.controleFuncionarios.exercicio.main;

import java.math.BigDecimal;

import org.junit.Before;

import br.com.controleFuncionarios.exercicio.controller.CargoController;
import br.com.controleFuncionarios.exercicio.controller.FuncionarioController;
import br.com.controleFuncionarios.exercicio.repository.CargoRepository;
import br.com.controleFuncionarios.exercicio.repository.FuncionarioRepository;
import br.com.controleFuncionarios.exercicio.service.CargoService;
import br.com.controleFuncionarios.exercicio.service.FuncionarioService;

public class PreparaProgram {

	private FuncionarioController funcionarioController;
	private FuncionarioService funcionarioService;
	private CargoController cargoController;
	private CargoService cargoService;
	
	public PreparaProgram() {		
	}

	public FuncionarioController getFuncionarioControler() {
		return funcionarioController;
	}

	public void setFuncionarioControler(FuncionarioController funcionarioControler) {
		this.funcionarioController = funcionarioControler;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public CargoController getCargoController() {
		return cargoController;
	}

	public void setCargoController(CargoController cargoController) {
		this.cargoController = cargoController;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	@Before
	public void setup() {		
		this.funcionarioService = new FuncionarioService(new FuncionarioRepository(), new CargoRepository());
		this.funcionarioController = new FuncionarioController(this.funcionarioService);
		this.cargoService = new CargoService(new CargoRepository());
		this.cargoController = new CargoController(this.cargoService);
	}
	
	public void findAll() {
		this.funcionarioController.findAll();
	}
	
	public void findById(Integer id) {
		this.funcionarioController.findById(id);
	}

	public void insertFuncionario(String string, Integer idCargo) {
		this.funcionarioController.inserirFuncionario(string,idCargo);
	}

	public void alterFuncionario(Integer idFuncionario,String nome, Integer idCargo) {
		this.funcionarioController.alterFuncionario(idFuncionario,nome, idCargo);
	}

	public void deletByid(Integer idFuncionario) {
		this.funcionarioController.deleteById(idFuncionario);		
	}

	public void findAllCargo() {
		this.cargoController.findAll();
	}

	public void findByIdCargo(Integer idCargo) {
		this.cargoController.findById(idCargo);
	}

	public void insertCargo(String nomeCargo, BigDecimal salario) {
		this.cargoController.insertCargo(nomeCargo, salario);
	}

	public void alterCargo(Integer idCargo, String nome, BigDecimal salario) {
		this.cargoController.alterCargo(idCargo, nome,salario);
	}

	public void deleteCargoById(Integer idCargo) {
		this.cargoController.deleteCargo(idCargo);
	}

}
