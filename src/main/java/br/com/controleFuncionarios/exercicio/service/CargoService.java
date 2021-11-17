package br.com.controleFuncionarios.exercicio.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.controleFuncionarios.exercicio.entities.Cargo;
import br.com.controleFuncionarios.exercicio.repository.CargoRepository;

public class CargoService {

	private CargoRepository cargoRepository;

	public CargoService() {
		this.cargoRepository = new CargoRepository();
	}

	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public CargoRepository getCargoRepository() {
		return cargoRepository;
	}

	public void setCargoRepository(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public List<Cargo> findAll() {
		List<Cargo> cargos = this.cargoRepository.findAll();
		return cargos;
	}

	public Cargo findById(Integer idCargo) {
		return this.cargoRepository.findById(idCargo);
	}

	public void insertCargo(String nomeCargo, BigDecimal salario) {
		Cargo cargo = new Cargo(nomeCargo, salario);
		this.cargoRepository.insertCargo(cargo);
	}

	public void alterCargo(Integer idCargo, String nome, BigDecimal salario) {
		Cargo cargo = this.cargoRepository.findById(idCargo);
		cargo.setNomeCargo(nome);
		cargo.setSalario(salario);
		this.cargoRepository.alterCargo(cargo);
	}

	public void deleteCargo(Integer idCargo) {
		this.cargoRepository.deleteCargo(idCargo);
	}

}
