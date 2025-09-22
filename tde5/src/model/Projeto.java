package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Projeto {

    private String nome;
    private String descricao;
    private List<Empregado> listaEmpregados;

    public Projeto(String nome, String descricao) throws ModelException {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.listaEmpregados = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Empregado> getListaEmpregados() {
        return new ArrayList<>(this.listaEmpregados);
    }

    public void adicionarEmpregado(Empregado emp) throws ModelException {
        if (emp == null) throw new ModelException("Empregado não pode ser nulo.");
        if (!this.listaEmpregados.contains(emp)) {
            this.listaEmpregados.add(emp);
            if (!emp.getListaProjetos().contains(this)) {
                emp.adicionarProjeto(this);
            }
        }
    }

    public void removerEmpregado(Empregado emp) throws ModelException {
        if (emp == null) throw new ModelException("Empregado não pode ser nulo.");
        if (this.listaEmpregados.contains(emp)) {
            this.listaEmpregados.remove(emp);
            if (emp.getListaProjetos().contains(this)) {
                emp.removerProjeto(this);
            }
        }
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return Objects.equals(nome, projeto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}