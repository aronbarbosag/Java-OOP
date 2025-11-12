package models;
import java.util.ArrayList;
import java.util.List;

public class Matricula {

    private String id;
    private float frequencia;
    private String status;

    // Relacionamento: Matricula (N) -> realiza -> (1) Aluno
    private Aluno aluno;

    // Relacionamento: Matricula (N) -> possui -> (1) Turma
    private Turma turma;

    // Relacionamento: Matricula (1) -> (N) RealizaProva
    private List<RealizaProva> provasRealizadas;

    public Matricula(String id, Aluno aluno, Turma turma) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
        this.status = "Ativa";
        this.frequencia = 100.0f;
        this.provasRealizadas = new ArrayList<>();
    }

    // Métodos da classe
    public void matricular() {
        System.out.println("Aluno matriculado.");
        this.status = "Ativa";
    }

    public void cancelar() {
        System.out.println("Matrícula cancelada.");
        this.status = "Cancelada";
    }

    public void aprovar() {
        System.out.println("Matrícula aprovada.");
        this.status = "Aprovada";
    }

    public void finalizar() {
        System.out.println("Matrícula finalizada.");
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(float frequencia) {
        this.frequencia = frequencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<RealizaProva> getProvasRealizadas() {
        return provasRealizadas;
    }

    public void addProvaRealizada(RealizaProva prova) {
        this.provasRealizadas.add(prova);
    }
}