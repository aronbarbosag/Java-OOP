package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControllerAluno;
import exceptions.ModelException;
import model.Curso;
import model.dao.DaoCurso;

public class ViewAluno extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tf_matricula;
    private JTextField tf_nome_aluno;
    private JComboBox<Curso> curso_combobox;
    final private ControllerAluno ctrlAluno;


    public ViewAluno(ControllerAluno ctrlAlun) {
        this.ctrlAluno = ctrlAlun;
        setTitle("Cadastrar Aluno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_matricula = new JLabel("Matrícula: ");
        label_matricula.setBounds(10, 11, 302, 14);
        contentPane.add(label_matricula);

        tf_matricula = new JTextField();
        tf_matricula.setBounds(10, 36, 217, 20);
        contentPane.add(tf_matricula);
        tf_matricula.setColumns(10);

        JLabel label_nome_aluno = new JLabel("Nome do aluno(a):");
        label_nome_aluno.setBounds(10, 79, 233, 14);
        contentPane.add(label_nome_aluno);

        tf_nome_aluno = new JTextField();
        tf_nome_aluno.setBounds(10, 104, 217, 20);
        contentPane.add(tf_nome_aluno);
        tf_nome_aluno.setColumns(10);

        JLabel label_curso = new JLabel("Curso: ");
        label_curso.setBounds(10, 148, 197, 14);
        contentPane.add(label_curso);

        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrlAluno.cancelar();
            }
        });
        btCancelar.setBounds(253, 227, 89, 23);
        contentPane.add(btCancelar);



        curso_combobox = new JComboBox<Curso>();
        DaoCurso daoCurso = new DaoCurso();

        ArrayList<Curso> listaCursos = daoCurso.mostrarCursos();
        for(Curso c : listaCursos) {
            curso_combobox.addItem(c);
        }




        curso_combobox.setBounds(10, 173, 217, 22);
        contentPane.add(curso_combobox);


        JButton btnCriarCurso = new JButton("Criar Curso");
        btnCriarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrlAluno.getCtrlPai().iniciarIncluirCurso();

            }
        });

        btnCriarCurso.setBounds(253, 176, 89, 23);
        contentPane.add(btnCriarCurso);




        JButton btnCriarAluno = new JButton("Criar Aluno");
        btnCriarAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String matriculaString = tf_matricula.getText();
                String nome = tf_nome_aluno.getText();
                Curso cursoSelecionado = (Curso) curso_combobox.getSelectedItem();


                try {
                    int matricula = Integer.parseInt(matriculaString);
                    ctrlAluno.incluirNovoAluno(matricula,nome,cursoSelecionado);

                }
                catch(NumberFormatException e1) {
                    JOptionPane.showMessageDialog(btnCriarAluno, "Erro: A Matrícula do aluno deve ser um número válido.");
                }



            }
        });
        btnCriarAluno.setBounds(10, 227, 89, 23);
        contentPane.add(btnCriarAluno);

        this.setVisible(true);

    }


}
