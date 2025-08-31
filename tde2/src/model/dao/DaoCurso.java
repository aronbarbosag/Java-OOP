package model.dao;
import model.Curso;
import java.util.ArrayList;

public class DaoCurso {
	
	public static ArrayList<Curso> listaCursos = new ArrayList<Curso>();
	
	
	
	public void adicionarCurso(Curso curso) {
		DaoCurso.listaCursos.add(curso);
	}
	
	public void removerCurso(Curso curso) {
		DaoCurso.listaCursos.remove(curso);
	}
	
	public ArrayList<Curso> mostrarCursos() {
		return new ArrayList<>(DaoCurso.listaCursos);
	}

}
