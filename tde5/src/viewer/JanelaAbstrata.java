package viewer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class JanelaAbstrata extends JFrame {

    public JanelaAbstrata(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha só esta janela, não o programa todo
        this.setLocationRelativeTo(null); // Centraliza na tela
    }

    public void apresentar() {
        this.pack(); // Ajusta o tamanho da janela aos componentes
        this.setVisible(true);
    }

    public void fechar() {
        this.dispose();
    }

    public void notificar(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
