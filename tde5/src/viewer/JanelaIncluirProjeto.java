package viewer;

import controller.projeto.CtrlIncluirProjeto;
import java.awt.*;
import javax.swing.*;

public class JanelaIncluirProjeto extends JanelaAbstrata {

    private final CtrlIncluirProjeto ctrl;
    private JTextField txtNome;
    private JTextArea txtDescricao;

    public JanelaIncluirProjeto(CtrlIncluirProjeto c) {
        super("Incluir Novo Projeto");
        this.ctrl = c;

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Formulário
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        formPanel.add(new JLabel("Nome:"));
        txtNome = new JTextField(30);
        formPanel.add(txtNome);
        formPanel.add(new JLabel("Descrição:"));
        txtDescricao = new JTextArea(5, 30);
        formPanel.add(new JScrollPane(txtDescricao));

        // Botões
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> {
            ctrl.incluir(txtNome.getText(), txtDescricao.getText());
        });

        btnPanel.add(btnConfirmar);

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);
        this.add(panel);
    }
}