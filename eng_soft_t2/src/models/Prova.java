package models;
import java.util.ArrayList;
import java.util.List;

public class Prova {

    private String idProva;
    private String descricao;

    // Relacionamento: Prova (N) -> pertence -> (1) Turma
    private Turma turma;

    // Relacionamento: Prova (1) -> (N) RealizaProva
    private List<RealizaProva> realizacoes;

    public Prova(String idProva, String descricao, Turma turma) {
        this.idProva = idProva;
        this.descricao = descricao;
        this.turma = turma;
        this.realizacoes = new ArrayList<>();
    }

    // Métodos da classe
    public void cadastrar() {
        System.out.println("Prova cadastrada.");
    }

    public void reprovar() {
        System.out.println("Prova reprovada.");
    }

    public void aprovar() {
        System.out.println("Prova aprovada.");
    }

    public void aplicar() {
        System.out.println("Prova aplicada.");
    }

    public void corrigir() {
        System.out.println("Prova corrigida.");
    }

    public void rever() {
        System.out.println("Prova em revisão.");
    }

    public void finalizar() {
        System.out.println("Prova finalizada.");
    }

    // Getters e Setters
    public String getIdProva() {
        return idProva;
    }

    public void setIdProva(String idProva) {
        this.idProva = idProva;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<RealizaProva> getRealizacoes() {
        return realizacoes;
    }

    public void addRealizacao(RealizaProva realizacao) {
        this.realizacoes.add(realizacao);
    }
}