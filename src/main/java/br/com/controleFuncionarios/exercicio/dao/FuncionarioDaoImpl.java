package br.com.controleFuncionarios.exercicio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.controleFuncionarios.exercicio.daoFactory.ConnectionFactory;
import br.com.controleFuncionarios.exercicio.entities.Cargo;
import br.com.controleFuncionarios.exercicio.entities.Funcionario;
import br.com.controleFuncionarios.exercicio.interfaceDao.FuncionarioDaoInterface;

public class FuncionarioDaoImpl extends Funcionario implements FuncionarioDaoInterface {

	ConnectionFactory con = ConnectionFactory.conect();

	public FuncionarioDaoImpl() {
	}

	@Override
	public List<Funcionario> findAllFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();

		try {

			PreparedStatement smt = con.getConnection().prepareStatement(
					"SELECT * FROM TB_FUNCIONARIOS AS F INNER JOIN TB_CARGO AS C ON (F.ID_CARGO = C.ID_CARGO)");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Cargo cargo = new Cargo();
				cargo.setIdCargo(rs.getInt("ID_CARGO"));
				cargo.setNomeCargo(rs.getString("NOME_CARGO"));
				cargo.setSalario(rs.getBigDecimal("SALARIO"));
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("ID_FUNCIONARIO"));
				funcionario.setNome(rs.getString("NOME"));
				funcionario.setCargo(cargo);
				funcionarios.add(funcionario);
			}
			rs.close();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return funcionarios;
	}

	@Override
	public void insert(Funcionario funcionario) {
		try {
			PreparedStatement smt;
			smt = con.getConnection().prepareStatement(
					"INSERT INTO TB_FUNCIONARIOS" + " (NOME, ID_CARGO) " + " VALUES " + " (?,?) ",
					Statement.RETURN_GENERATED_KEYS);
			smt.setString(1, funcionario.getNome());
			smt.setInt(2, funcionario.getCargo().getIdCargo());

			int linhasAfetadas = smt.executeUpdate();

			if (linhasAfetadas > 0) {
				ResultSet rs = smt.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					funcionario.setId(id);
				}

				rs.close();
				smt.close();
			} else {
				System.out.println("Erro ao inserir");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	@Override
	public void update(Funcionario funcionario) {
		try {

			PreparedStatement smt;
			smt = con.getConnection().prepareStatement(
					"UPDATE TB_FUNCIONARIOS" + " SET  NOME = ?, ID_CARGO = ? " + " WHERE ID_FUNCIONARIO = ?",
					Statement.RETURN_GENERATED_KEYS);
			smt.setString(1, funcionario.getNome());
			smt.setInt(2, funcionario.getCargo().getIdCargo());
			smt.setInt(3, funcionario.getId());

			smt.executeUpdate();

			smt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement smt;
			smt = con.getConnection().prepareStatement("DELETE FROM TB_FUNCIONARIOS WHERE ID_FUNCIONARIO = ?",
					Statement.RETURN_GENERATED_KEYS);
			smt.setInt(1, id);
			smt.executeUpdate();

			smt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	@Override
	public Funcionario findById(Integer id) {
		Funcionario funcionario = new Funcionario();
		try {
			PreparedStatement smt;
			smt = con.getConnection().prepareStatement(
					"SELECT * FROM TB_FUNCIONARIOS AS F INNER JOIN TB_CARGO AS C ON (F.ID_CARGO = C.ID_CARGO)"
							+ " where ID_FUNCIONARIO = ?");
			smt.setInt(1, id);

			ResultSet rs = smt.executeQuery();
			if (rs.next()) {
				Cargo cargo = new Cargo();
				cargo.setIdCargo(rs.getInt("ID_CARGO"));
				cargo.setNomeCargo(rs.getString("NOME_CARGO"));
				cargo.setSalario(rs.getBigDecimal("SALARIO"));
				funcionario.setId(rs.getInt("ID_FUNCIONARIO"));
				funcionario.setNome(rs.getString("NOME"));
				funcionario.setCargo(cargo);
			} else {
				return null;
			}
			rs.close();
			smt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		return funcionario;
	}

}
