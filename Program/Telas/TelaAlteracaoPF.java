package Program.Telas;

import Program.Classes.FuncionarioPF;
import Program.ConexãoBD.DAOFuncPf;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlteracaoPF extends JFrame implements ActionListener {
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");
    public ImageIcon iconCancel = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\cancel2.png");
    public ImageIcon iconEnviar = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\enviar-bd.png");

    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");

    // Cores utilizadas
    public Color corFundo1 = new Color(42, 87, 141);   // Azul-escuro
    public Color corPanel = new Color(96, 125, 139);  // Cinza-azulado
    public Color corLabel1 = new Color(255, 193, 7);  // Amarelo (destaque)
    public Color corLabel2 = new Color(34, 34, 34);   // Cinza-escuro
    // Ícones e cores
     public Color branco = new Color(255, 255, 255);

    private FuncionarioPF funcionario;
    private boolean isSaved;
    private DAOFuncPf dao;

    public String antigoCpf;

    // Campos de texto para os atributos do FuncionarioPF
    private JTextField tfNome;
    private JTextField tfCpf;
    private JTextField tfContato;

    // Botões
    private JButton btnSalvar;
    private JButton btnCancelar;

    public TelaAlteracaoPF(FuncionarioPF funcionario) {
        this.funcionario = funcionario;
        this.isSaved = false;
        this.dao = new DAOFuncPf();
        antigoCpf = funcionario.getCPF();

        // Configurações do JFrame
        setTitle("Alterar Funcionario PF");
        setIconImage(icone.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(corFundo1);
        setSize(400, 300);


        // Labels
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(branco);
        lblNome.setBounds(20, 20, 100, 20);
        add(lblNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setForeground(branco);
        lblCpf.setBounds(20, 50, 100, 20);
        add(lblCpf);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setForeground(branco);
        lblContato.setBounds(20, 80, 100, 20);
        add(lblContato);

        // Campos de texto
        tfNome = new JTextField(funcionario.getNome());
        tfNome.setBounds(130, 20, 200, 20);
        add(tfNome);

        tfCpf = new JTextField(funcionario.getCPF());
        tfCpf.setBounds(130, 50, 200, 20);
        add(tfCpf);

        tfContato = new JTextField(funcionario.getContato());
        tfContato.setBounds(130, 80, 200, 20);
        add(tfContato);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(214, 190, 115, 30);
        btnSalvar.setBackground(new Color(6, 185, 57));
        btnSalvar.addActionListener(this);
        btnSalvar.setIcon(iconEnviar);
        add(btnSalvar);

        btnCancelar = new JButton("x");
        btnCancelar.setBounds(170, 190, 40, 30);
        btnCancelar.setIcon(iconCancel);
        btnCancelar.setBackground(new Color(245, 250, 250));
        btnCancelar.addActionListener(this);
        add(btnCancelar);
    }

    // Obtém os valores dos campos de texto e atualiza o cliente
    public FuncionarioPF getFuncionario() {
        funcionario.setNome(tfNome.getText());
        funcionario.setCPF(tfCpf.getText());
        funcionario.setContato(tfContato.getText());

        return funcionario;
    }

    public boolean isSaved() {
        return isSaved;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalvar) {
            // Obtém o cliente alterado e o salva no banco de dados
            FuncionarioPF clienteAlterado = getFuncionario();
            dao.altera(clienteAlterado, antigoCpf);
            isSaved = true;
            dispose();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }
}
