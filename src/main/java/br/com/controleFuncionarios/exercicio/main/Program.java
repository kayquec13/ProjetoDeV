package br.com.controleFuncionarios.exercicio.main;

import java.math.BigDecimal;

import org.junit.Test;

public class Program {

	@Test
	public void main() {

		PreparaProgram program = new PreparaProgram();
		program.setup();
		System.out.println("\n--------------------------BUSCA-POR-TODOS- FUNCIONARIOS------------------");
		program.findAll();
		//System.out.println("\n--------------------------BUSCA-POR-ID-----------------------------------");
		//program.findById(2);
		//System.out.println("--------------------------INSERIR-FUNCIONARIO----------------------------");
		//program.insertFuncionario("Tiago", 2);
		//System.out.println("\n--------------------------BUSCA-POR-TODOS- FUNCIONARIOS------------------");
		//program.findAll();
		//System.out.println("\n--------------------------ALTERANDO-DADOS-DO-FUNCIONARIOS------------------");
		//program.alterFuncionario(1005, "FABRICIO", 1);
		//System.out.println("\n--------------------------BUSCA-POR-TODOS FUNCIONARIOS------------------");
		//program.findAll();
		//System.out.println("\n--------------------------DELETANDO-POR-ID---------------------------------");
		//program.deletByid(4);
		//System.out.println("\n--------------------------BUSCA-POR-TODOS- FUNCIONARIOS------------------");
		//program.findAll();
		//System.out.println("\n--------------------------CRUD-CARGO----------------------------------------");
		//program.findAllCargo();
		//System.out.println("\n--------------------------BUSCA-POR-ID--------------------------------------");
		//program.findByIdCargo(2);
		System.out.println("\n--------------------------INSERINDO-CARGO-----------------------------------");
		program.insertCargo("TesteKayque3", new BigDecimal(5000));
		System.out.println("\n--------------------------BUSCANDO-LISTA-DE-CARGOS--------------------------");
		program.findAllCargo();
		System.out.println("\n--------------------------ALTERANDO-CARGO-----------------------------------");
		program.alterCargo(4008, "Estagiario", new BigDecimal(2300));
		System.out.println("\n--------------------------BUSCANDO-LISTA-DE-CARGOS--------------------------");
		//program.findAllCargo();
		System.out.println("\n--------------------------DELETANDO-CARGO-----------------------------------");
		//para fazer esse metodo funcionar, vou ter que alterar ele nas outras classes para que venha como parametro o objeto.
		
		program.deleteCargoById(3011);
		System.out.println("\n--------------------------BUSCANDO-LISTA-DE-CARGOS--------------------------");
		program.findAllCargo();
	}
}
