package controller;
import projeto.*;

import javax.swing.JOptionPane;
import controller.projeto.CtrlManterProjetos; // NOVO
import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato {
    // ...
    private CtrlIncluirEmpregado     ctrlIncluirEmpregado;
    private CtrlManterDepartamentos  ctrlManterDepartamentos; // Adicionado para consistência
    private CtrlManterProjetos       ctrlManterProjetos;    // NOVO

    public CtrlPrograma() {
        super(null);
        this.janelaPrincipal = new JanelaPrincipal(this);
        this.janelaPrincipal.apresentar();
    }

    // ... (iniciar/finalizar IncluirDepartamento e IncluirEmpregado) ...
    // É recomendado ter um padrão de "Manter" para todos

    //
    // NOVOS MÉTODOS PARA O CASO DE USO "MANTER PROJETOS"
    //
    /**
     * Iniciando o caso de uso Manter Projetos
     */
    public void iniciarManterProjetos() {
        if (this.ctrlManterProjetos == null) {
            this.ctrlManterProjetos = new CtrlManterProjetos(this);
        } else {
            this.janelaPrincipal.notificar("O caso de uso 'Manter Projetos' já está em execução!");
        }
    }

    /**
     * Encerrando o caso de uso Manter Projetos (chamado pelo filho)
     */
    public void manterProjetosFinalizado() {
        this.ctrlManterProjetos = null;
    }

    @Override
    public void encerrar() {

    }

    @Override
    public Object getBemTangivel() {
        return null;
    }

    // ... (restante da classe) ...
}
