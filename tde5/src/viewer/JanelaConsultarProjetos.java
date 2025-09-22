package viewer;

import controller.projeto.CtrlManterProjetos;
import model.Projeto;
import java.awt.*;
import javax.swing.*;

public class JanelaConsultarProjetos extends JanelaAbstrata {

    private final CtrlManterProjetos ctrl;
    private JList<Projeto> listProjetos;
    private DefaultListModel<Projeto> listModel;

    public JanelaConsultarProjetos(CtrlManterProjetos c, Projeto[] lista) {
        super("Manter Projetos");
        this.ctrl = c;

        // Painel principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Lista de projetos
        listModel = new DefaultListModel<>();
        for (Projeto p : lista) {
            listModel.addElement(p);
        }
        listProjetos = new JList<>(listModel);
        panel.add(new JScrollPane(listProjetos), BorderLayout.CENTER);

        // Painel de botões
        JPanel btnPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        JButton btnIncluir = new JButton("Incluir Novo");
        JButton btnAssociar = new JButton("Associar Empregado");

        btnIncluir.addActionListener(e -> ctrl.iniciarIncluirProjeto());
        btnAssociar.addActionListener(e -> {
            Projeto selecionado = listProjetos.getSelectedValue();
            ctrl.iniciarAssociarEmpregado(selecionado);
        });

        btnPanel.add(btnIncluir);
        btnPanel.add(btnAssociar);

        panel.add(btnPanel, BorderLayout.EAST);
        this.add(panel);
    }

    public void atualizarDados(Projeto[] novaLista) {
        listModel.clear();
        for (Projeto p : novaLista) {
            listModel.addElement(p);
        }
    }
}