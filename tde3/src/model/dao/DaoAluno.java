package model.dao;
import model.Aluno;
import java.util.ArrayList;

public class DaoAluno {
	public static ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	
	
	
	
	
	public void adicionarAluno(Aluno aluno) {
		DaoAluno.listaAlunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		DaoAluno.listaAlunos.remove(aluno);
	}
	
	public ArrayList<Aluno> mostrarAluno(){
		return new ArrayList<>(DaoAluno.listaAlunos);
	}
	


}
