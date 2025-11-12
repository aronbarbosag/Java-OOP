package models;
import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String idTurma;
    private String horario;
    private String sala;

    // Relacionamento: Turma (N) -> é de -> (1) Disciplina
    private Disciplina disciplina;

    // Relacionamento: Turma (N) -> é ministrada por -> (1) Professor
    private Professor professor;

    // Relacionamento: Turma (1) -> possui -> (N) Matricula
    private List<Matricula> matriculas;

    // Relacionamento: Turma (1) -> pertence -> (N) Prova
    private List<Prova> provas;

    public Turma(String idTurma, String horario, String sala, Disciplina disciplina, Professor professor) {
        this.idTurma = idTurma;
        this.horario = horario;
        this.sala = sala;
        this.disciplina = disciplina;
        this.professor = professor;
        this.matriculas = new ArrayList<>();
        this.provas = new ArrayList<>();
    }

    // Métodos da classe
    public void cadastrar() {
        System.out.println("Turma cadastrada.");
    }

    public void cancelar() {
        System.out.println("Turma cancelada.");
    }

    public void aprovar() {
        System.out.println("Turma aprovada.");
    }

    public void finalizar() {
        System.out.println("Turma finalizada.");
    }

    // Getters e Setters
    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void addMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void addProva(Prova prova) {
        this.provas.add(prova);
    }
}