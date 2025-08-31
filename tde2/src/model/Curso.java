package model;
import exceptions.ModelException;
import java.util.ArrayList;


public class Curso {
	
	private int idCurso;
	private String nome;
	
	private ArrayList<Aluno> alunos; 
	
	public static final int TAMANHO_NOME = 40;

	public Curso(int idCurso,String nome) throws ModelException {
		this.setIdCurso(idCurso);
		this.setNome(nome);
		this.alunos = new ArrayList<Aluno>();
	}
	
	public ArrayList<Aluno> getAlunos() {
		ArrayList<Aluno> copiaAlunos = new ArrayList<>(alunos);
		for(Aluno aluno:copiaAlunos) {
			System.out.println("nome: " +  aluno.getNome() + "matricula: " + aluno.getMatricula());
		}
		
		return new ArrayList<Aluno>(alunos);
	}

	public void setAlunos(ArrayList<Aluno> alunos) throws ModelException {
		Curso.validarAlunos(alunos);
		this.alunos = alunos;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) throws ModelException {
		Curso.validarIdCurso(idCurso);
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException{
		Curso.validarNome(nome);
		this.nome = nome;
	}
	
	public boolean adicionarAluno(Aluno aluno) throws ModelException {
		Curso.validarAluno(aluno);
		return this.alunos.add(aluno);
	}

	
	public boolean removerAluno(Aluno aluno) throws ModelException {
		Curso.validarAluno(aluno);
		return this.alunos.remove(aluno);		
	}
	
	@Override
    public String toString() {
        
        return this.getNome(); 
    }
	
	public static void validarNome(String nome) throws ModelException{
		if(nome.length() > Curso.TAMANHO_NOME)
			throw new ModelException("O nome não deve passar de " +  Curso.TAMANHO_NOME+  " caracteres");
	}
	
	public static void validarAluno(Aluno aluno) throws ModelException{
		if (aluno==null)
			throw new ModelException("Aluno nao pdoe estar vazio");
	}
	
	
	public static void validarIdCurso(int idCurso) throws ModelException {
		if(idCurso<1)
			throw new ModelException("O id do curso deve ser um numero maior ou igual a 1");
	}
	
	public static void validarAlunos(ArrayList<Aluno> alunos) throws ModelException{
		if (alunos==null) {
			throw new ModelException("A referencia a aluno nao pode esta vazia");
		}
	}
	
	

}
