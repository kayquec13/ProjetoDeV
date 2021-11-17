package br.com.controleFuncionarios.exercicio.interfaceDao;

import java.util.List;

import br.com.controleFuncionarios.exercicio.entities.Funcionario;

public interface FuncionarioDaoInterface {
	void insert (Funcionario funcionario);
	void update (Funcionario funcionario);
	void deleteById (Integer id);
	Funcionario findById(Integer id);
	List<Funcionario> findAllFuncionarios();
}
