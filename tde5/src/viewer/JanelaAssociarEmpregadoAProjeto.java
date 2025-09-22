package viewer;

import controller.projeto.CtrlAssociarEmpregadoAProjeto;
import model.Empregado;
import model.Projeto;
import java.awt.*;
import javax.swing.*;

public class JanelaAssociarEmpregadoAProjeto extends JanelaAbstrata {

    private final CtrlAssociarEmpregadoAProjeto ctrl;
    private JComboBox<Empregado> comboEmpregados;

    public JanelaAssociarEmpregadoAProjeto(CtrlAssociarEmpregadoAProjeto c, Projeto p, Empregado[] todosEmpregados) {
        super("Associar Empregado ao Projeto: " + p.getNome());
        this.ctrl = c;

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Selecione o Empregado:"));

        comboEmpregados = new JComboBox<>(todosEmpregados);
        panel.add(comboEmpregados);

        JButton btnAssociar = new JButton("Associar");
        btnAssociar.addActionListener(e -> {
            Empregado selecionado = (Empregado) comboEmpregados.getSelectedItem();
            if (selecionado != null) {
                ctrl.associar(selecionado);
            } else {
                notificar("Nenhum empregado selecionado.");
            }
        });
        panel.add(btnAssociar);

        this.add(panel);
    }
}