package controller;
import viewer.ViewMain;
import exceptions.ModelException;

import javax.swing.*;


public class CtrlPrograma extends ControllerAbstract{

    private ViewMain janelaPrincipal;


    public  CtrlPrograma(ControllerAbstract c){
        super(null);
        this.janelaPrincipal = new ViewMain(this);
        this.janelaPrincipal.setVisible(true);
    }














}
