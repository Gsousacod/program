package Program.Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Program.Classes.FuncionarioPJ;
import Program.ConexãoBD.DAOFuncPj;

public class TelaAlteracaoPJ extends JFrame implements ActionListener {
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");
    public ImageIcon iconCancel = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\cancel2.png");
    public ImageIcon iconEnviar = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\enviar-bd.png");

    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");

    // Cores utilizadas
    public Color corFundo1 = new Color(27, 38, 44);
    public Color corPanel = new Color(15, 76, 117);
    public Color corLabel1 = new Color(187, 225, 250);
    public Color corLabel2 = new Color(200, 200, 200);
    public Color branco = new Color(255, 255, 255);

    // Ícones e cores

    private FuncionarioPJ cliente;
    private boolean isSaved;
    private DAOFuncPj dao;

    public String antigoCnpj;

    // Campos de texto para os atributos do FuncionarioPJ
    private JTextField tfRazao;
    private JTextField tfCnpj;
    private JTextField tfEmail;
    private JTextField tfContato;
    private JTextField tfResponsavel;

    // Botões
    private JButton btnSalvar;
    private JButton btnCancelar;

    public TelaAlteracaoPJ(FuncionarioPJ cliente) {
        this.cliente = cliente;
        this.isSaved = false;
        this.dao = new DAOFuncPj();
        antigoCnpj = cliente.getCnpj();

        // Configurações do JFrame
        setTitle("Alterar Cliente PJ");
        setIconImage(icone.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(corFundo1);
        setSize(400, 300);


        // Labels
        JLabel lblRazao = new JLabel("Razão Social:");
        lblRazao.setForeground(branco);
        lblRazao.setBounds(20, 20, 100, 20);
        add(lblRazao);

        JLabel lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(20, 50, 100, 20);
        lblCnpj.setForeground(branco);
        add(lblCnpj);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 80, 100, 20);
        lblEmail.setForeground(branco);
        add(lblEmail);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setForeground(branco);
        lblContato.setBounds(20, 110, 100, 20);
        add(lblContato);

        JLabel lblResponsavel = new JLabel("Responsável:");
        lblResponsavel.setForeground(branco);
        lblResponsavel.setBounds(20, 140, 100, 20);
        add(lblResponsavel);

        // Campos de texto
        tfRazao = new JTextField(cliente.getRazao());
        tfRazao.setBounds(130, 20, 200, 20);
        add(tfRazao);

        tfCnpj = new JTextField(cliente.getCnpj());
        tfCnpj.setBounds(130, 50, 200, 20);
        add(tfCnpj);

        tfEmail = new JTextField(cliente.getEmail());
        tfEmail.setBounds(130, 80, 200, 20);
        add(tfEmail);

        tfContato = new JTextField(cliente.getContato());
        tfContato.setBounds(130, 110, 200, 20);
        add(tfContato);

        tfResponsavel = new JTextField(cliente.getResponsavel());
        tfResponsavel.setBounds(130, 140, 200, 20);
        add(tfResponsavel);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(214, 190, 115, 30);
        btnSalvar.setBackground(new Color(6, 185, 57));
        btnSalvar.addActionListener(this);
        btnSalvar.setIcon(iconEnviar);
        add(btnSalvar);

        btnCancelar = new JButton("");
        btnCancelar.setBounds(170, 190, 40, 30);
        btnCancelar.setIcon(iconCancel);
        btnCancelar.setBackground(new Color(245, 250, 250));
        btnCancelar.addActionListener(this);
        add(btnCancelar);
    }

    // Obtém os valores dos campos de texto e atualiza o cliente
    public FuncionarioPJ getCliente() {
        cliente.setRazao(tfRazao.getText());
        cliente.setCnpj(tfCnpj.getText());
        cliente.setEmail(tfEmail.getText());
        cliente.setContato(tfContato.getText());
        cliente.setResponsavel(tfResponsavel.getText());

        return cliente;
    }

    public boolean isSaved() {
        return isSaved;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalvar) {
            // Obtém o cliente alterado e o salva no banco de dados
            FuncionarioPJ clienteAlterado = getCliente();
            dao.altera(clienteAlterado, antigoCnpj);
            isSaved = true;
            dispose();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }
}
