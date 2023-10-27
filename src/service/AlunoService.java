package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AlunoDAO;
import dao.BancoDados;
import entities.Aluno;
import entities.Curso;

public class AlunoService {
	
	public AlunoService() {
		
	}
	
	public List<Aluno> buscarTodos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List <Aluno> alunos = new AlunoDAO(conn).buscarTodos();
		
		CursoService cursoService = new CursoService();
		
		for (Aluno aluno : alunos) {
						
			Curso curso = cursoService.buscarPorCodigo(aluno.getCurso().getCodigo());
			aluno.setCurso(curso);
		}
		
		return alunos;
	}
	
	public void cadastrar(Aluno aluno) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new AlunoDAO(conn).cadastrar(aluno);
	}
}











