package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exceptions.ModelException;
import model.Curso;
import model.dao.DaoCurso;
import controller.ControllerCurso;

public class ViewCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_id_curso;
	private JTextField tf_nome_curso;
	private ControllerCurso ctrlCurso;
	
	public ViewCurso(ControllerCurso ctrl) {
        this.ctrlCurso = ctrl;
		setTitle("Cadastrar Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		DaoCurso daoCurso = new DaoCurso();
		
		JButton btnCriarCurso = new JButton("Criar Curso");
		btnCriarCurso.setBounds(10, 179, 130, 35);
		btnCriarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idCurso = tf_id_curso.getText();
				String nomeCurso = tf_nome_curso.getText();
				
				if (idCurso.trim().isEmpty() || nomeCurso.trim().isEmpty()) {
			        JOptionPane.showMessageDialog(btnCriarCurso, "Por favor, preencha todos os campos.");
			        return; // Para a execução do método aqui
			    }
				
				try {
					int idCursoInt = Integer.parseInt(idCurso);
                    ctrlCurso.incluirCurso(idCursoInt,nomeCurso);
					tf_id_curso.setText("");
					tf_nome_curso.setText("");
					tf_id_curso.requestFocus();
					
				}
				catch (NumberFormatException e1) { 
				    JOptionPane.showMessageDialog(btnCriarCurso, "Erro: O ID do curso deve ser um número válido.");
				}

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCriarCurso);
		
		JLabel labe_id_curso = new JLabel("id do curso: ");
		labe_id_curso.setBounds(10, 11, 132, 14);
		contentPane.add(labe_id_curso);
		
		tf_id_curso = new JTextField();
		tf_id_curso.setBounds(11, 36, 131, 20);
		contentPane.add(tf_id_curso);
		tf_id_curso.setColumns(10);
		
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(253, 176, 89, 23);
		contentPane.add(btCancelar);
		
		JLabel lblNomeDoCurso = new JLabel("Nome do curso:");
		lblNomeDoCurso.setBounds(10, 85, 87, 14);
		contentPane.add(lblNomeDoCurso);
		
		tf_nome_curso = new JTextField();
		tf_nome_curso.setBounds(10, 110, 132, 20);
		contentPane.add(tf_nome_curso);
		tf_nome_curso.setColumns(10);
		this.setVisible(true);

	}

}
