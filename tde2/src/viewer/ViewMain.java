package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.CtrlPrograma;

public class ViewMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    final private CtrlPrograma ctrl;
	
	public ViewMain(CtrlPrograma ctrl) {
        this.ctrl = ctrl;

		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		JButton btnCurso = new JButton("Curso");
		btnCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarIncluirCurso();

			}
		});
		btnCurso.setBounds(33, 53, 119, 66);
		contentPane.add(btnCurso);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.fecharPrograma();

			}
		});
		btFechar.setBounds(366, 53, 119, 66);
		contentPane.add(btFechar);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarIncluirAluno();
			}
		});
		btnAluno.setBounds(195, 53, 119, 66);
		contentPane.add(btnAluno);
		this.setVisible(true);

	}

}
