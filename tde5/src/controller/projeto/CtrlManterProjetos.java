package controller.projeto;

import controller.CtrlAbstrato;
import controller.CtrlPrograma;
import model.Projeto;
import model.dao.DaoProjeto;
import viewer.JanelaConsultarProjetos;

/**
 * Controlador para o caso de uso "Manter Projetos".
 * Orquestra a visualização da lista de projetos e delega ações como
 * incluir, alterar, excluir e associar para outros controladores especializados.
 */
public class CtrlManterProjetos extends CtrlAbstrato {

    private JanelaConsultarProjetos janela;
    private CtrlAbstratoProjeto ctrlFilho; // Armazena o controlador do caso de uso filho em execução

    public CtrlManterProjetos(CtrlAbstrato ctrlPai) {
        super(ctrlPai);
        DaoProjeto dao = new DaoProjeto();
        this.janela = new JanelaConsultarProjetos(this, dao.obterTodos());
        this.janela.apresentar();
    }

    /**
     * Inicia o caso de uso "Incluir Projeto".
     */
    public void iniciarIncluirProjeto() {
        if (this.ctrlFilhoEmExecucao()) return;
        this.ctrlFilho = new CtrlIncluirProjeto(this);
    }

    /**
     * Inicia o caso de uso "Alterar Projeto". (Método de esboço)
     * @param projetoSelecionado O projeto a ser alterado.
     */
    public void iniciarAlterarProjeto(Projeto projetoSelecionado) {
        if (this.ctrlFilhoEmExecucao()) return;
        if (projetoSelecionado == null) {
            this.janela.notificar("ERRO: É necessário selecionar um projeto para alterar.");
            return;
        }
        // TODO: Criar e instanciar o CtrlAlterarProjeto
        // this.ctrlFilho = new CtrlAlterarProjeto(this, projetoSelecionado);
        this.janela.notificar("Funcionalidade 'Alterar Projeto' ainda não implementada.");
    }

    /**
     * Inicia o caso de uso "Excluir Projeto". (Método de esboço)
     * @param projetoSelecionado O projeto a ser excluído.
     */
    public void iniciarExcluirProjeto(Projeto projetoSelecionado) {
        if (this.ctrlFilhoEmExecucao()) return;
        if (projetoSelecionado == null) {
            this.janela.notificar("ERRO: É necessário selecionar um projeto para excluir.");
            return;
        }
        // TODO: Criar e instanciar o CtrlExcluirProjeto
        this.janela.notificar("Funcionalidade 'Excluir Projeto' ainda não implementada.");
    }

    /**
     * Inicia o caso de uso "Associar Empregado a um Projeto".
     * @param projetoSelecionado O projeto que receberá a associação.
     */
    public void iniciarAssociarEmpregado(Projeto projetoSelecionado) {
        if (this.ctrlFilhoEmExecucao()) return;
        if (projetoSelecionado == null) {
            this.janela.notificar("ERRO: É necessário selecionar um projeto para fazer a associação.");
            return;
        }
        this.ctrlFilho = new CtrlAssociarEmpregadoAProjeto(this, projetoSelecionado);
    }

    /**
     * Método de callback invocado pelos controladores filhos quando eles terminam.
     */
    public void encerrarUseCaseFilho() {
        this.ctrlFilho = null;
        DaoProjeto dao = new DaoProjeto();
        this.janela.atualizarDados(dao.obterTodos());
    }

    /**
     * Verifica se já existe um caso de uso filho em execução.
     * @return true se um filho está ativo, false caso contrário.
     */
    private boolean ctrlFilhoEmExecucao() {
        if (this.ctrlFilho != null) {
            this.janela.notificar("Finalize a operação atual antes de iniciar uma nova.");
            return true;
        }
        return false;
    }

    @Override
    public void encerrar() {
        this.janela.fechar();
        CtrlPrograma ctrlPai = (CtrlPrograma) this.getCtrlPai();
        ctrlPai.manterProjetosFinalizado();
    }

    @Override
    public Object getBemTangivel() {
        return new DaoProjeto().obterTodos();
    }
}