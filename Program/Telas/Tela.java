package Program.Telas;
import java.awt.*;

import javax.swing.*;


public class Tela extends JFrame{
    
    
    //------------------------Criação de Icones--------------------------------------------------------
    public ImageIcon iconInsert = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\insert.png");
    public ImageIcon iconConfig = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\config.png");
    public ImageIcon iconCancel = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\cancel.png");
    public ImageIcon iconSave = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\save.png");
    public ImageIcon iconPF = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\PF.png");
    public ImageIcon iconPJ = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\PJ.png");
    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\voltar.png");
    public ImageIcon iconLupa = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\Lupa.png");
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");
    ;
    //------------------------Criação de Cores-----------------------------------------------------------
    public Color corFundo1 = new Color(42, 87, 141);   // Azul-escuro
    public Color corPanel = new Color(96, 125, 139);  // Cinza-azulado
    public Color corLabel1 = new Color(255, 193, 7);  // Amarelo (destaque)
    public Color corLabel2 = new Color(34, 34, 34);   // Cinza-escuro
    
    public Tela(){
        setIconImage(icone.getImage());
        setTitle("");
        setVisible(true);                              //configura visibilidade da tela.
        setSize(500, 500);                 //configurando tamanho da tela.
        setDefaultCloseOperation(EXIT_ON_CLOSE);       //definindo operação de fechamento de tela.
        setResizable(false);                //impossibilita o redimensionamento da tela.
        setLocationRelativeTo(null);               //configura a localização de nascimento da tela
        setLayout(null);                    //"reseta" o layout da tela.
        getContentPane().setBackground(corFundo1); //Define cor de fundo da tela.  


        JLabel devs = new JLabel("Desenvolvido por: Gabriel de Sousa ");
        devs.setForeground(corLabel2);
        devs.setFont(new Font("Arial", Font.ITALIC, 9 ));
        devs.setBounds(40, 386, 1000, 100);
        devs.setVisible(true);
        this.add(devs);

    }
    
}