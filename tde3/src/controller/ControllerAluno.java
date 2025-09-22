package controller;
import exceptions.ModelException;
import model.Aluno;
import model.dao.DaoAluno;
import model.Curso;
import viewer.ViewAluno;

import javax.swing.*;

public class ControllerAluno extends ControllerAbstract{
//    Controler de caso de uso guarda os controller pai e a view correspondente
    final private ViewAluno janela;


//    Passa o controlador pai como argumento

    public ControllerAluno(ControllerAbstract c){
        super(c);
        this.janela =  new ViewAluno(this);
        this.janela.setVisible(true);


//        Aluno novo = new Aluno(matricula,nome,cursoSelecionado);
//        daoAluno.adicionarAluno(novo);

    }



    public void incluirNovoAluno(int matricula, String nome, Curso curso) {

        if (curso == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um curso.");
            return;
        }

        try{
            Aluno novo = new Aluno(matricula,nome,curso);
            DaoAluno daoAluno = new DaoAluno();
            daoAluno.adicionarAluno(novo);

            this.janela.setVisible(false);

            this.incluirAlunoFinalizado();


        }
        catch(NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, "Erro: A Matrícula do aluno deve ser um número válido.");
        }

        catch(ModelException e1){
            JOptionPane.showMessageDialog(null, e1.getMessage());

        }

    }

    public void cancelar(){
        this.janela.setVisible(false);
        this.incluirAlunoFinalizado();
    }

}
