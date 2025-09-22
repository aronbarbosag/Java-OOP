package controller.projeto;

package controller.projeto;

import controller.CtrlAbstrato;
import model.Projeto;
import viewer.JanelaAbstrata; // Supondo que você crie uma janela base

/**
 * Classe base para os controladores de casos de uso que manipulam um único Projeto.
 */
public abstract class CtrlAbstratoProjeto extends CtrlAbstrato {

    protected Projeto proj;
    protected JanelaAbstrata janela; // A janela específica (de inclusão, alteração, etc.)

    public CtrlAbstratoProjeto(CtrlAbstrato c) {
        super(c); // Padrão: Sempre informa quem é o pai
    }

    @Override
    public Object getBemTangivel() {
        return this.proj;
    }

    @Override
    public void encerrar() {
        if (this.janela != null) {
            this.janela.fechar();
        }
        // Padrão: Notifica o controlador pai (CtrlManterProjetos) que a tarefa terminou
        CtrlManterProjetos ctrlPai = (CtrlManterProjetos) this.getCtrlPai();
        ctrlPai.fimDaEdicao();
    }
}
