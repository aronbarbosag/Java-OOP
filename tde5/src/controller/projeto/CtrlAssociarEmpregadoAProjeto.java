package controller.projeto;

package controller.projeto;

import model.Empregado;
import model.ModelException;
import model.Projeto;
import model.dao.DaoEmpregado;

/**
 * Controlador para o caso de uso "Associar um Empregado a um Projeto".
 */
public class CtrlAssociarEmpregadoAProjeto extends CtrlAbstratoProjeto {

    public CtrlAssociarEmpregadoAProjeto(CtrlAbstrato c, Projeto projetoAlvo) {
        super(c);
        this.proj = projetoAlvo;

        // Carrega todos os empregados para exibi-los na janela
        DaoEmpregado daoEmp = new DaoEmpregado();
        Empregado[] todosEmpregados = daoEmp.obterTodos().toArray(new Empregado[0]);

        // this.janela = new JanelaAssociarEmpregado(this, projetoAlvo, todosEmpregados);
        // this.janela.apresentar();
    }

    /**
     * Método chamado pela janela para efetivar a associação.
     * @param empregadoASerAdicionado O empregado selecionado pelo usuário.
     */
    public void associar(Empregado empregadoASerAdicionado) {
        try {
            this.proj.adicionarEmpregado(empregadoASerAdicionado);
            // Idealmente, você também salvaria o estado do projeto (não implementado no DAO atual)
            // this.janela.notificar("Empregado '" + empregadoASerAdicionado.getNome() + "' associado ao projeto!");
            this.encerrar(); // Encerra este caso de uso e volta para a tela de Manter Projetos
        } catch (ModelException e) {
            // this.janela.notificar(e.getMessage());
        }
    }
}
