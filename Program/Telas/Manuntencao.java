package Program.Telas;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manuntencao extends Tela implements ActionListener {
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");

    public ImageIcon iconPJ = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\PJ.png");
    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");
    public ImageIcon iconPF = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\PF.png");

    JButton MTPF = new JButton();
    JButton MTPJ = new JButton();
    JButton voltar = new JButton();

    public Manuntencao() {
        setTitle("Funcionarios ");
        setIconImage(icone.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        // Título e subtitulo do Pesquisar PF
        JLabel labelMTPF = new JLabel();
        labelMTPF.setText("Pesquisar PF");
        labelMTPF.setForeground(corLabel1);
        labelMTPF.setBounds(180, 60, 100, 100);
        labelMTPF.setFont(new Font("Arial Black", Font.PLAIN, 12));
        this.add(labelMTPF);

        // Título e subtitulo do Pesquisar PJ
        JLabel labelMTPJ = new JLabel();
        labelMTPJ.setText("Pesquisar PJ");
        labelMTPJ.setForeground(corLabel1);
        labelMTPJ.setBounds(180, 170, 250, 100);
        labelMTPJ.setFont(new Font("Arial Black", Font.PLAIN, 12));
        this.add(labelMTPJ);

        // Botão Pesquisar PF
        MTPF.setBounds(70, 70, 75, 75);
        MTPF.setIcon(iconPF);
        MTPF.addActionListener(this);
        this.add(MTPF);

        // Botão Pesquisar PJ
        MTPJ.setBounds(70, 190, 75, 75);
        MTPJ.setIcon(iconPJ);
        MTPJ.addActionListener(this);
        this.add(MTPJ);

        // Botão Voltar
        voltar.setIcon(iconBack);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(this);
        this.add(voltar);
    }

    // Método de ação dos botões
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MTPF) {
            this.dispose();
            new TelaTablePF();
        }
        if (e.getSource() == MTPJ) {
            this.dispose();
            new TelaTablePJ();
        }
        if (e.getSource() == voltar) {
            this.dispose();
            new Inicio();    
        }
    }
}
