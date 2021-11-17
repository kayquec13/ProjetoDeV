package br.com.controleFuncionarios.exercicio.repository;

import java.util.List;

import br.com.controleFuncionarios.exercicio.dao.CargoDaoImpl;
import br.com.controleFuncionarios.exercicio.dao.TesteConsultaJpa;
import br.com.controleFuncionarios.exercicio.entities.Cargo;

public class CargoRepository {
	private CargoDaoImpl cargoDaoImpl;
	private TesteConsultaJpa testeInsert;
	
	public CargoRepository() {
		this.cargoDaoImpl = new CargoDaoImpl();
		this.testeInsert = new TesteConsultaJpa();
	}
	
	public CargoRepository(CargoDaoImpl cargoDaoImpl) {
		this.cargoDaoImpl = cargoDaoImpl;
	}
	
	public CargoRepository(TesteConsultaJpa testeInsert) {
		this.testeInsert = testeInsert;
	}

	public CargoDaoImpl getCargoDaoImpl() {
		return cargoDaoImpl;
	}

	public void setCargoDaoImpl(CargoDaoImpl cargoDaoImpl) {
		this.cargoDaoImpl = cargoDaoImpl;
	}
	
	
	public TesteConsultaJpa getTesteInsert() {
		return testeInsert;
	}

	public void setTesteInsert(TesteConsultaJpa testeInsert) {
		this.testeInsert = testeInsert;
	}

	public Cargo findById(Integer id) {		
		return this.cargoDaoImpl.findById(id);
	}

	public List<Cargo> findAll() {
		return this.cargoDaoImpl.findAll();
	}

	public void insertCargo(Cargo cargo) {
		this.testeInsert.insert(cargo);
	}

	public void alterCargo(Cargo cargo) {
		this.testeInsert.update(cargo);
	}

	public void deleteCargo(Integer id) {
		this.testeInsert.delete(id);;
	}

}
