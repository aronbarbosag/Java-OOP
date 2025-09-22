package controller.projeto;

package controller.projeto;

import controller.CtrlAbstrato;
import model.ModelException;
import model.Projeto;
import model.dao.DaoProjeto;

/**
 * Controlador para o caso de uso "Incluir Projeto".
 */
public class CtrlIncluirProjeto extends CtrlAbstratoProjeto {

    public CtrlIncluirProjeto(CtrlAbstrato c) {
        super(c); // Padrão: informa ao pai que é o CtrlManterProjetos
        // this.janela = new JanelaIncluirProjeto(this); // Cria a sua janela específica
        // this.janela.apresentar();
    }

    /**
     * Método chamado pela janela para efetivar a inclusão.
     */
    public void incluir(String nome, String descricao) {
        try {
            this.proj = new Projeto(nome, descricao);
            DaoProjeto dao = new DaoProjeto();
            dao.adicionar(this.proj);
            // this.janela.notificar("Projeto '" + nome + "' criado com sucesso!");
            this.encerrar(); // Padrão: Encerra o caso de uso e notifica o pai
        } catch (ModelException e) {
            // this.janela.notificar(e.getMessage());
        }
    }
}
