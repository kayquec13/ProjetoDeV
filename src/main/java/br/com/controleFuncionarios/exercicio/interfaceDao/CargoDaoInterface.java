package br.com.controleFuncionarios.exercicio.interfaceDao;

import java.util.List;

import br.com.controleFuncionarios.exercicio.entities.Cargo;

public interface CargoDaoInterface {
	void insert (Cargo cargo);
	void update (Cargo cargo);
	void deleteById (Integer id);
	Cargo findById(Integer id);
	List<Cargo> findAll();
}
