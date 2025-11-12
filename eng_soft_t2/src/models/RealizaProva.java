package models;
public class RealizaProva {

    private float nota;

    // Relacionamento: (N) -> (1) Matricula
    private Matricula matricula;

    // Relacionamento: (N) -> (1) Prova
    private Prova prova;

    public RealizaProva(Matricula matricula, Prova prova) {
        this.matricula = matricula;
        this.prova = prova;
    }

    // Getters e Setters
    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }
}