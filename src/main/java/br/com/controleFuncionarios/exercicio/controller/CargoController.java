package br.com.controleFuncionarios.exercicio.controller;

import java.math.BigDecimal;
import java.util.List;

import br.com.controleFuncionarios.exercicio.entities.Cargo;
import br.com.controleFuncionarios.exercicio.service.CargoService;

public class CargoController {

	private CargoService cargoService;

	public CargoController() {
		this.cargoService = new CargoService();
	}

	public CargoController(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public void findAll() {
		List<Cargo> cargos = this.cargoService.findAll();
		for (Cargo cargo : cargos) {
			System.out.println(cargo);
		}
	}

	public void findById(Integer idCargo) {
		Cargo cargo = this.cargoService.findById(idCargo);
		System.out.println(cargo);
	}

	public void insertCargo(String nomeCargo, BigDecimal salario) {
		this.cargoService.insertCargo(nomeCargo, salario);
		System.out.println("Inserido " + nomeCargo + " no sistema!");
	}

	public void alterCargo(Integer idCargo, String nome, BigDecimal salario) {
		this.cargoService.alterCargo(idCargo, nome,salario);
		System.out.println("Alterando " + nome + " no sistema!");
	}

	public void deleteCargo(Integer idCargo) {
		findById(idCargo);
		this.cargoService.deleteCargo(idCargo);
	}

}
