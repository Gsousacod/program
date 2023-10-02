package Program.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Program.Classes.FuncionarioPJ;

public class NovoRegistroPJ extends Tela implements ActionListener {
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");

    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");
    public ImageIcon iconSave = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\save.png");

    // Instancia de botoes
    JButton voltar = new JButton();
    JButton salvar = new JButton("Salvar");
    // Instancia de TextField
    JTextField jtfRazao = new JTextField();
    JTextField jtfCnpj = new JTextField();
    JTextField jtfEmail = new JTextField();
    JTextField jtfContato = new JTextField();
    JTextField jtfResponsavelLegal = new JTextField();
    JTextField jtfDepartamento = new JTextField();


    // Intancia de Variáveis para armazenamento das Strings
    private String sRazao, sCnpj, sEmail, sContato, sResponsavelLegal,sDepartamento;
    // Intancia de um objeto da classe Funcionario PJ
    public FuncionarioPJ funcionarioPJ = new FuncionarioPJ();

    public NovoRegistroPJ() {
        this.setTitle("Cadastro Pessoa Jurídica");
        setIconImage(icone.getImage());
        setResizable(false);


        // Label "RAZÃO SOCIAL"
        JLabel lRazao = new JLabel();
        lRazao.setText("Razão Social:");
        lRazao.setBounds(30, 66, 300, 70);
        lRazao.setForeground(corLabel1);
        this.add(lRazao);

        // Caixa para inserir Razão Social
        jtfRazao.setBounds(170, 90, 300, 25);
        jtfRazao.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfRazao.setToolTipText("Insira a razão social aqui");
        jtfRazao.addActionListener(this);
        this.add(jtfRazao);

        // Label "CNPJ"
        JLabel lCnpj = new JLabel();
        lCnpj.setText("CNPJ:");
        lCnpj.setBounds(30, 100, 120, 70);
        lCnpj.setForeground(corLabel1);
        this.add(lCnpj);

        // Caixa para inserir o CNPJ
        jtfCnpj.setBounds(170, 124, 300, 25);
        jtfCnpj.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfCnpj.setToolTipText("Insira o CNPJ aqui");
        jtfCnpj.addActionListener(this);
        this.add(jtfCnpj);

        // Label "E-MAIL"
        JLabel lEmail = new JLabel();
        lEmail.setText("E-mail:");
        lEmail.setBounds(30, 130, 120, 70);
        lEmail.setForeground(corLabel1);
        this.add(lEmail);

        // Caixa para inserir o E-mail
        jtfEmail.setBounds(170, 158, 300, 25);
        jtfEmail.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfEmail.setToolTipText("Insira o email aqui");
        jtfEmail.addActionListener(this);
        this.add(jtfEmail);

        // Label "CONTATO"
        JLabel lContato = new JLabel();
        lContato.setText("Contato:");
        lContato.setBounds(30, 168, 120, 70);
        lContato.setForeground(corLabel1);
        this.add(lContato);

        // Caixa para inserir o Contato
        jtfContato.setBounds(170, 192, 300, 25);
        jtfContato.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfContato.setToolTipText("Insira o contato aqui");
        jtfContato.addActionListener(this);
        this.add(jtfContato);

        // Label "RESPONSAVEL LEGAL"
        JLabel lResponsavelLegal = new JLabel();
        lResponsavelLegal.setText("Responsável legal:");
        lResponsavelLegal.setBounds(30, 202, 300, 70);
        lResponsavelLegal.setForeground(corLabel1);
        this.add(lResponsavelLegal);

        // Caixa para inserir o Responsável legal
        jtfResponsavelLegal.setBounds(170, 226, 300, 25);
        jtfResponsavelLegal.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfResponsavelLegal.setToolTipText("Insira o Responsável legal aqui");
        jtfResponsavelLegal.addActionListener(this);
        this.add(jtfResponsavelLegal);



        // Caixa para inserir o Departamento
        jtfDepartamento.setBounds(170, 260, 300, 25);
        jtfDepartamento.setFont(new Font("Arial", Font.ITALIC, 12));
        jtfDepartamento.setToolTipText("Insira o Responsável legal aqui");
        jtfDepartamento.addActionListener(this);
        this.add(jtfDepartamento);

        // Label "DEPARTAMENTO"
        JLabel lDepartamento = new JLabel();
        lDepartamento.setText("Departamento:");
        lDepartamento.setBounds(30, 236, 300, 70);
        lDepartamento.setForeground(corLabel1);
        this.add(lDepartamento);



        // Botão "Voltar"
        voltar.setIcon(iconBack);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        NovoRegistroPJ.this.dispose();
                        new NovoRegistro();
                    }
                });

        this.add(voltar);

        // Botão "Salvar"
        salvar.setVisible(true);
        salvar.setBounds(175, 320, 120, 40);
        salvar.setIcon(iconSave);
        salvar.setHorizontalAlignment(SwingConstants.CENTER);
        salvar.addActionListener(new ActionListener() { // MÉTODO DE CRIAÇÃO DE EVENTO DO BOTÃO SALVAR
            public void actionPerformed(ActionEvent e) {
                salvar.setEnabled(false); // Desabilita o botão

                sRazao = jtfRazao.getText();
                funcionarioPJ.setRazao(sRazao);

                sCnpj = jtfCnpj.getText();
                funcionarioPJ.setCnpj(sCnpj);

                sEmail = jtfEmail.getText();
                funcionarioPJ.setEmail(sEmail);

                sContato = jtfContato.getText();
                funcionarioPJ.setContato(sContato);

                sResponsavelLegal = jtfResponsavelLegal.getText();
                funcionarioPJ.setResponsavel(sResponsavelLegal);

                sDepartamento = jtfDepartamento.getText();
                funcionarioPJ.setDepartamento(sDepartamento);

                NovoRegistroPJ.this.dispose();
                new TelaAvisoPJ(funcionarioPJ);
            }
        });
        this.add(salvar);
    }
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
