package models;

import java.util.ArrayList;
import java.util.List;

public class Professor {

    private int idProfessor;
    private String nome;
    private String departamento;
    private String email;

    // Relacionamento: Professor (1) -> ministra -> (N) Turma
    private List<Turma> turmas;

    public Professor(int idProfessor, String nome, String departamento, String email) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.departamento = departamento;
        this.email = email;
        this.turmas = new ArrayList<>();
    }

    // Getters e Setters
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }
}