package Program.Telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Program.Classes.FuncionarioPF;

public class NovoRegistroPF extends Tela implements ActionListener {
    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");

    public ImageIcon iconSave = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\save.png");

    //------------------------CREATE BUTTON------------------------\\

    JButton salvar = new JButton("Salvar", iconSave);
    JButton voltar = new JButton(iconBack);

    //------------------------CREATE TEXTFIELD------------------------\\

    JTextField textName = new JTextField();
    JTextField textCPF = new JTextField();
    JTextField textContato = new JTextField();
    JTextField textDepart = new JTextField();
    JTextField textEmail = new JTextField();

    //------------------------CREATE LABEL------------------------\\

    JLabel labelNome = new JLabel("Nome");
    JLabel labelCPF = new JLabel("CPF");
    JLabel labelContato = new JLabel("Contato");
    JLabel labelDepart = new JLabel("Departamento");
    JLabel labelEmail = new JLabel("Email");

    private String sNome, sCPF, sContato, sDepart,sEmail;

    public FuncionarioPF clientePF = new FuncionarioPF();

    public NovoRegistroPF() {
        setTitle("Cadastrar Pessoa Física");
        //------------------------Labels------------------------\\

        // NOME
        labelNome.setBounds(30, 66, 70, 70);
        labelNome.setForeground(corLabel1);
        labelNome.setVisible(true);
        this.add(labelNome);

        // CPF
        labelCPF.setBounds(30, 100, 70, 70);
        labelCPF.setForeground(corLabel1);
        labelCPF.setVisible(true);
        this.add(labelCPF);

        // CONTATO
        labelContato.setBounds(30, 134, 70, 70);
        labelContato.setForeground(corLabel1);
        labelContato.setVisible(true);
        this.add(labelContato);

        // DEPARTAMENTO
        labelDepart.setBounds(30, 168, 100, 70);
        labelDepart.setForeground(corLabel1);
        labelDepart.setVisible(true);
        this.add(labelDepart);

        // EMAIL
        labelEmail.setBounds(30, 202, 70, 70);
        labelEmail.setForeground(corLabel1);
        labelEmail.setVisible(true);
        this.add(labelEmail);



        //------------------------TextFields------------------------\\

        //NAME
        textName.setBounds(140, 90, 320, 25);
        textName.setFont(new Font("Arial", Font.ITALIC, 12));
        textName.setToolTipText("Insira o Nome aqui");
        textName.setVisible(true);
        this.add(textName);

        // CPF
        textCPF.setBounds(140, 124, 320, 25);
        textCPF.setFont(new Font("Arial", Font.ITALIC, 12));
        textCPF.setToolTipText("Insira o CPF aqui");
        textCPF.setVisible(true);
        add(textCPF);

        // CONTATO
        textContato.setBounds(140, 158, 320, 25);
        textContato.setFont(new Font("Arial", Font.ITALIC, 12));
        textContato.setToolTipText("Insira o Contato aqui");
        textContato.setVisible(true);
        this.add(textContato);

        //Departamento
        textDepart.setBounds(140, 192, 320, 25);
        textDepart.setFont(new Font("Arial", Font.ITALIC, 12));
        textDepart.setToolTipText("Insira o Contato aqui");
        textDepart.setVisible(true);
        this.add(textDepart);

        //Email
        textEmail.setBounds(140, 226, 320, 25);
        textEmail.setFont(new Font("Arial", Font.ITALIC, 12));
        textEmail.setToolTipText("Insira o Contato aqui");
        textEmail.setVisible(true);
        this.add(textEmail);

        //------------------------FUNÇÃO BUTTONS------------------------\\

        salvar.setVisible(true);
        salvar.setBounds(185, 270, 120, 40);
        salvar.setHorizontalAlignment(SwingConstants.CENTER);
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                salvar.setEnabled(false);

                sNome = textName.getText();
                clientePF.setNome(sNome);

                sCPF = textCPF.getText();
                clientePF.setCPF(sCPF);

                sContato = textContato.getText();
                clientePF.setContato(sContato);

                sDepart = textDepart.getText();
                clientePF.setDepartamento(sDepart);

                sEmail = textEmail.getText();
                clientePF.setEmail(sEmail);

                new TelaAvisoPF(clientePF);
                NovoRegistroPF.this.dispose();

            }
        });

        this.add(salvar);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(this);
        this.add(voltar);
    }
    // ----------MÉTODO DE CRIAÇÃO DE EVENTOS----------
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltar) {
            this.dispose();
            new NovoRegistro();
        }
    }
}
