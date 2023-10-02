package Program.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;

public class Inicio extends JFrame implements ActionListener {

    // Icons para os botões
    public ImageIcon iconInsert = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\insert.png");
    public ImageIcon iconConfig = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\config.png");
    public ImageIcon iconCancel = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\cancel.png");
    public ImageIcon iconSave = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\save.png");
    public ImageIcon iconPF = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\PF.png");

    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");
    public ImageIcon iconLupa = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\Lupa.png");
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\iconePrincipal.png");

    public Color corFundo1 = new Color(42, 87, 141);   // Azul-escuro
    public Color corPanel = new Color(96, 125, 139);  // Cinza-azulado
    public Color corLabel1 = new Color(255, 193, 7);  // Amarelo (destaque)
    public Color corLabel2 = new Color(34, 34, 34);   // Cinza-escuro

    JButton novoRegistro = new JButton();
    JButton manuntencaoRegistro = new JButton();
    
    public Inicio() {
        
        setTitle("");
        setVisible(true); // configura visibilidade da tela.
        setIconImage(icone.getImage());
        setSize(500, 400); // configurando tamanho da tela.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // definindo operação de fechamento de tela.
        setResizable(false); // impossibilita o redimensionamento da tela.
        setLocationRelativeTo(null); // configura a localização de nascimento da tela
        setLayout(null); // "reseta" o layout da tela.
        getContentPane().setBackground(corFundo1); // Define cor de fundo da tela.


        // Título e subtitulo do Novo Registro
        setTitle("Gestão RH");
        JLabel labelRegistro = new JLabel();
        labelRegistro.setText("Novo Registro");
        labelRegistro.setForeground(corLabel1);
        labelRegistro.setBounds(180, 40, 100, 100);
        labelRegistro.setFont(new Font("Arial Black", Font.PLAIN, 12));
        this.add(labelRegistro);

        JLabel sublabelRegistro = new JLabel();
        sublabelRegistro.setText("Inserir um novo Funcionário.");
        sublabelRegistro.setForeground(corLabel2);
        sublabelRegistro.setBounds(180, 60, 300, 100);
        sublabelRegistro.setFont(new Font("Arial", Font.PLAIN, 11));
        this.add(sublabelRegistro);

        // Título e subtitulo da Manutenção de Registro
        JLabel labelManu = new JLabel();
        labelManu.setText("Registro de Funcionário");
        labelManu.setForeground(corLabel1);
        labelManu.setBounds(180, 160, 250, 100);
        labelManu.setFont(new Font("Arial Black", Font.PLAIN, 12));
        this.add(labelManu);

        JLabel sublabelManu = new JLabel();
        sublabelManu.setText("Pesquisar, alterar ou deletar um registro.");
        sublabelManu.setForeground(corLabel2);
        sublabelManu.setBounds(180, 180, 300, 100);
        sublabelManu.setFont(new Font("Arial", Font.PLAIN, 11));
        this.add(sublabelManu);

        // Botão Novo Registro
        novoRegistro.setBounds(70, 70, 75, 75);
        novoRegistro.setIcon(iconInsert);
        novoRegistro.addActionListener(this);
        this.add(novoRegistro);

        // Botão Manutenção de Registro
        manuntencaoRegistro.setIcon(iconConfig);
        manuntencaoRegistro.setBounds(70, 190, 75, 75);
        manuntencaoRegistro.addActionListener(this);
        this.add(manuntencaoRegistro);


         JLabel devs = new JLabel("Desenvolvido por: Gabriel de Sousa ");
         devs.setForeground(corLabel2);
         devs.setFont(new Font("Arial", Font.ITALIC, 9 ));
         devs.setBounds(40, 286, 1000, 100);
         devs.setVisible(true);
         this.add(devs);



    }
    
    // Método de ação dos botões
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == novoRegistro) {
            this.dispose();
            new NovoRegistro();
        }
        if (e.getSource() == manuntencaoRegistro) {
            this.dispose();
            new Manuntencao();
        }
    }
}
