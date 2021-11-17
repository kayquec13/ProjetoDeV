package br.com.controleFuncionarios.exercicio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.controleFuncionarios.exercicio.daoFactory.ConnectionFactory;
import br.com.controleFuncionarios.exercicio.entities.Cargo;
import br.com.controleFuncionarios.exercicio.interfaceDao.CargoDaoInterface;

public class CargoDaoImpl implements CargoDaoInterface {
	ConnectionFactory con = ConnectionFactory.conect();

	@Override
	public void insert(Cargo cargo) {
		try {
			PreparedStatement smt;
			smt = con.getConnection().prepareStatement("INSERT INTO TB_CARGO" + " (NOME_CARGO, SALARIO) " + " VALUES " + " (?,?) ",
					Statement.RETURN_GENERATED_KEYS);
			smt.setString(1, cargo.getNomeCargo());
			smt.setBigDecimal(2, cargo.getSalario());

			int linhasAfetadas = smt.executeUpdate();

			if (linhasAfetadas > 0) {
				ResultSet rs = smt.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					cargo.setIdCargo(id);
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
	public void update(Cargo cargo) {
		try {
			PreparedStatement smt;
			smt = con.getConnection().prepareStatement("UPDATE TB_CARGO" + " SET  NOME_CARGO = ?, SALARIO = ? " + " WHERE ID_CARGO = ?",
					Statement.RETURN_GENERATED_KEYS);
			smt.setString(1, cargo.getNomeCargo());
			smt.setBigDecimal(2, cargo.getSalario());
			smt.setInt(3, cargo.getIdCargo());

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
			smt = con.getConnection().prepareStatement("DELETE FROM TB_CARGO WHERE ID_CARGO = ?", Statement.RETURN_GENERATED_KEYS);
			smt.setInt(1, id);
			smt.executeUpdate();

			smt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	@Override
	public Cargo findById(Integer id) {
		Cargo cargo = new Cargo();
		try {
			PreparedStatement smt;
			smt = con.getConnection().prepareStatement("SELECT " + "*" + " FROM TB_CARGO" + " WHERE ID_CARGO = ? ");
			smt.setInt(1, id);

			ResultSet rs = smt.executeQuery();
			if (rs.next()) {
				cargo.setIdCargo(rs.getInt("ID_CARGO"));
				cargo.setNomeCargo(rs.getString("NOME_CARGO"));
				cargo.setSalario(rs.getBigDecimal("SALARIO"));

			} else {
				return null;
			}
			rs.close();
			smt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		return cargo;
	}

	@Override
	public List<Cargo> findAll() {
		List<Cargo> cargos = new ArrayList<>();

		try {
			PreparedStatement smt = con.getConnection().prepareStatement("SELECT * FROM TB_CARGO ");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Cargo cargo = new Cargo();
				cargo.setIdCargo(rs.getInt("ID_CARGO"));
				cargo.setNomeCargo(rs.getString("NOME_CARGO"));
				cargo.setSalario(rs.getBigDecimal("SALARIO"));
				cargos.add(cargo);
			}
			rs.close();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return cargos;
	}

}
