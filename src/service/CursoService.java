package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BancoDados;
import dao.CursoDAO;
import entities.Curso;

public class CursoService {

	public CursoService() {

	}

	public void cadastrar(Curso curso) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new CursoDAO(conn).cadastrar(curso);
	}

	public List<Curso> buscarTodos() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new CursoDAO(conn).buscarTodos();
	}

	public Curso buscarPorCodigo(int codigoCurso) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new CursoDAO(conn).buscarPorCodigo(codigoCurso);
	}
}
