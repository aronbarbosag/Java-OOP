package viewer;

import controller.CtrlPrograma;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class JanelaPrincipal extends JanelaAbstrata {

    private final CtrlPrograma ctrl;

    public JanelaPrincipal(CtrlPrograma c) {
        super("Sistema de Gestão");
        this.ctrl = c;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar esta janela encerra o programa
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JButton btnManterProjetos = new JButton("Manter Projetos");
        btnManterProjetos.addActionListener((ActionEvent e) -> {
            ctrl.iniciarManterProjetos();
        });

        // Adicionar botões para outras funcionalidades se desejar
        // JButton btnManterEmpregados = new JButton("Manter Empregados");

        this.add(btnManterProjetos);
    }
}
