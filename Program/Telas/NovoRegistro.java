package Program.Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovoRegistro extends Tela implements ActionListener {
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");

    public ImageIcon iconPJ = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\PJ.png");
    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");
    public ImageIcon iconPF = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\PF.png");
    JButton PF = new JButton();
    JButton PJ = new JButton();
    JButton voltar = new JButton();

    public NovoRegistro() {
        setTitle("Funcionários");
        setIconImage(icone.getImage());
        setLocationRelativeTo(null);
        setResizable(false);


        JLabel labelPF = new JLabel();
        labelPF.setText("Pessoa Física");
        labelPF.setForeground(corLabel1);
        labelPF.setBounds(180, 60, 100, 100);
        labelPF.setFont(new Font("Arial Black", Font.PLAIN, 12));
        this.add(labelPF);


        JLabel labelPJ = new JLabel();
        labelPJ.setText("Pessoa Jurídica");
        labelPJ.setForeground(corLabel1);
        labelPJ.setBounds(180, 170, 250, 100);
        labelPJ.setFont(new Font("Arial Black", Font.PLAIN, 12));
        this.add(labelPJ);


        PF.setBounds(70, 70, 75, 75);
        PF.setIcon(iconPF);
        PF.addActionListener(this);
        this.add(PF);


        PJ.setIcon(iconPJ);
        PJ.setBounds(70, 190, 75, 75);
        PJ.addActionListener(this);
        this.add(PJ);


        voltar.setIcon(iconBack);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(this);
        this.add(voltar);
    }

    public void aberturaCli() {
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PF) {
            this.dispose();
            new NovoRegistroPF();
        }
        if (e.getSource() == PJ) {
            this.dispose();
            new NovoRegistroPJ();
        }
        if (e.getSource() == voltar) {
            this.dispose();
            new Inicio();
        }
    }
}
