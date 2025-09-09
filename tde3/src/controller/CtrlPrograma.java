package controller;
import viewer.ViewMain;
import exceptions.ModelException;

import javax.swing.*;


public class CtrlPrograma {

    private ViewMain janelaPrincipal;
    private ControllerAluno ctrlAlun;
    private ControllerCurso ctrlCurso;

    public  CtrlPrograma(){
        this.janelaPrincipal = new ViewMain(this);
        this.janelaPrincipal.setVisible(true);
    }


    public void iniciarIncluirCurso(){
        if(this.ctrlCurso == null){
            this.ctrlCurso = new ControllerCurso(this);
        }
        else{
            JOptionPane.showMessageDialog(null, "Este Caso de Uso já está em execução!");
        }
    }

    public void iniciarIncluirAluno(){
        if(this.ctrlAlun == null){
            this.ctrlAlun = new ControllerAluno(this);
        }
        else{
            JOptionPane.showMessageDialog(null, "Este Caso de Uso já está em execução!");
        }
    }


    public void incluirAlunoFinalizado(){
        this.ctrlAlun = null;

    }

    public void incluirCursoFinalizado(){
        this.ctrlCurso = null;

    }



    public void fecharPrograma() {
        System.exit(0);
    }




	public static void main(String[] args) {
		
		 new CtrlPrograma();
		

	}

}
