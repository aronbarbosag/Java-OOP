package controller;


import javax.swing.*;

abstract class ControllerAbstract {
     private   ControllerAbstract ctrlPai;
     private static   ControllerAluno ctrlAlun ;
     private static   ControllerCurso ctrlCurso;

    public ControllerAbstract(ControllerAbstract ctrl){
        this.ctrlPai = ctrl;


    }

    public void iniciarIncluirCurso(){
        if(this.ctrlCurso == null){
            ControllerAbstract.ctrlCurso = new ControllerCurso(this);
        }
        else{
            JOptionPane.showMessageDialog(null, "Este Caso de Uso já está em execução!");
        }
    }


    public void iniciarIncluirAluno(){
        if(ControllerAbstract.ctrlAlun == null){
            ControllerAbstract.ctrlAlun = new ControllerAluno(this);
        }
        else{
            JOptionPane.showMessageDialog(null, "Este Caso de Uso já está em execução!");
        }
    }


    public ControllerAbstract getCtrlPai(){
        return this.ctrlPai;
    }


    public void incluirAlunoFinalizado(){
        ControllerAbstract.ctrlAlun = null;

    }

    public void incluirCursoFinalizado(){
        ControllerAbstract.ctrlCurso = null;

    }

    public void fecharPrograma() {
        System.exit(0);
    }


}
