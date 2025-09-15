package controller;
import exceptions.ModelException;
import model.Curso;
import viewer.ViewCurso;
import model.dao.DaoCurso;

import javax.swing.*;


public class ControllerCurso extends ControllerAbstract{
    private CtrlPrograma ctrlPai;
    final private ViewCurso janela;

    public ControllerCurso(ControllerAbstract c){
        super(c);
        this.janela = new ViewCurso(this);
        this.janela.setVisible(true);

    }

    public void incluirCurso(int idCurso, String nomeCurso) {
        try{
            Curso novo = new Curso(idCurso,nomeCurso);
            DaoCurso daoCurso = new DaoCurso();
            daoCurso.adicionarCurso(novo);
            JOptionPane.showMessageDialog(null, "Curso criado com sucesso!");
            this.janela.setVisible(false);
            this.incluirCursoFinalizado();
        }
        catch(ModelException e1){
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }


    }
    public void cancelar(){
        this.janela.setVisible(false);
        this.incluirCursoFinalizado();
    }


}
