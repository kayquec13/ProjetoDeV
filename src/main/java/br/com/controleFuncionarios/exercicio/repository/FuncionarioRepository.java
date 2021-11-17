package br.com.controleFuncionarios.exercicio.repository;

import java.util.List;

import br.com.controleFuncionarios.exercicio.dao.FuncionarioDaoImpl;
import br.com.controleFuncionarios.exercicio.entities.Funcionario;

public class FuncionarioRepository {

	private FuncionarioDaoImpl funcionarioDaoImpl;

	public FuncionarioRepository() {
		this.funcionarioDaoImpl = new FuncionarioDaoImpl();
	}

	public FuncionarioRepository(FuncionarioDaoImpl funcionarioDaoImpl) {
		this.funcionarioDaoImpl = funcionarioDaoImpl;
	}

	public FuncionarioDaoImpl getFuncionarioDaoImpl() {
		return funcionarioDaoImpl;
	}

	public void setFuncionarioDaoImpl(FuncionarioDaoImpl funcionarioDaoImpl) {
		this.funcionarioDaoImpl = funcionarioDaoImpl;
	}

	public List<Funcionario> findAll() {

		return this.funcionarioDaoImpl.findAllFuncionarios();
	}

	public Funcionario findById(Integer id) {
		return this.funcionarioDaoImpl.findById(id);
	}

	public void inserindoFuncionario(Funcionario funcionario) {
		this.funcionarioDaoImpl.insert(funcionario);
	}

	public void alterFuncionario(Funcionario funcionario) {
		this.funcionarioDaoImpl.update(funcionario);
	}

	public void deleteById(Integer idFuncionario) {
		this.funcionarioDaoImpl.deleteById(idFuncionario);
	}

}
