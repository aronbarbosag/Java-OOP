package model;
import exceptions.ModelException;

public class Aluno {
	
	
	
	
	private int matricula;
	private String nome;
	private Curso curso;
	
	public static final int TAMANHO_NOME = 40;
	
	
	public  Aluno(int matricula,String nome, Curso curso) throws ModelException {
		this.setMatricula(matricula);
		this.setNome(nome);
		this.setCurso(curso);
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) throws ModelException {
		Aluno.validarMatricula(matricula);
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException {
		Aluno.validarNome(nome);
		this.nome = nome;
	}
	
	
	
	public String getCurso() {
		
		return this.curso.getNome();
	}

	public void setCurso(Curso curso) throws ModelException {
		Aluno.validarCurso(curso);
		
		if (this.curso != null)
			this.curso.removerAluno(this);
		this.curso = curso;
		this.curso.adicionarAluno(this);
		
		
	}
	
	public static void validarNome(String nome) throws ModelException{
		if(nome.length() > Aluno.TAMANHO_NOME)
			throw new ModelException("O nome não deve passar de " +  Aluno.TAMANHO_NOME+  " caracteres");
	}

	public static void validarMatricula(int matricula) throws ModelException {
		if (matricula<1)
			throw new ModelException("A matricula deve ser um numero maior que zero");
		
			
			
	}
	
	public static void validarCurso(Curso curso) throws ModelException{
		if(curso==null)
			throw new ModelException("É necessairo que o aluno esteja em um curso ");
	}
	

}
