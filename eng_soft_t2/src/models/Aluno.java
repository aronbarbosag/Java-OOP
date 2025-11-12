package models;
import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String matricula;
    private String nome;
    private String cpf;
    private String email;

    // Relacionamento: Aluno (1) -> realiza -> (N) Matricula
    private List<Matricula> matriculas;

    public Aluno(String matricula, String nome, String cpf, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.matriculas = new ArrayList<>();
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void addMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }
}