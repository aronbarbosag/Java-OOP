package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empregado implements Comparable<Empregado> {

    private String cpf;
    private String nome;
    private Departamento depto;
    private List<Projeto> listaProjetos;

    public Empregado(String cpf, String nome, Departamento depto) throws ModelException {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setDepto(depto);
        this.listaProjetos = new ArrayList<>();
    }

    // ... (Getters e Setters para cpf, nome, depto com validações) ...
    public String getCpf() { return this.cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; } // Adicionar validação se necessário
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; } // Adicionar validação se necessário
    public Departamento getDepto() { return this.depto; }
    public void setDepto(Departamento depto) { this.depto = depto; }


    // MÉTODOS PARA GERENCIAR O RELACIONAMENTO N-N COM PROJETO
    public List<Projeto> getListaProjetos() {
        return new ArrayList<>(this.listaProjetos);
    }

    public void adicionarProjeto(Projeto proj) throws ModelException {
        if (proj == null) throw new ModelException("Projeto não pode ser nulo.");
        if (!this.listaProjetos.contains(proj)) {
            this.listaProjetos.add(proj);
            // Garante a consistência do outro lado da relação
            if (!proj.getListaEmpregados().contains(this)) {
                proj.adicionarEmpregado(this);
            }
        }
    }

    public void removerProjeto(Projeto proj) throws ModelException {
        if (proj == null) throw new ModelException("Projeto não pode ser nulo.");
        if (this.listaProjetos.contains(proj)) {
            this.listaProjetos.remove(proj);
            // Garante a consistência do outro lado da relação
            if (proj.getListaEmpregados().contains(this)) {
                proj.removerEmpregado(this);
            }
        }
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.cpf + ")";
    }

    @Override
    public int compareTo(Empregado outro) {
        return this.cpf.compareTo(outro.cpf);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empregado empregado = (Empregado) o;
        return Objects.equals(cpf, empregado.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}