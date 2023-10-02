package Program.Telas;

import Program.Classes.FuncionarioPJ;
import Program.ConexãoBD.DAOFuncPj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaTable extends Tela implements ActionListener {
    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");
    public ImageIcon iconInsert = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\insert.png");
    public ImageIcon iconConfig = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\config.png");
    public ImageIcon iconCancel = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\cancel.png");


    JButton voltar = new JButton();
    JButton excluir = new JButton("Excluir");
    JTable table;



    public TelaTable() {
        // Configurações do JFrame
        setTitle("Resultado da Busca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(corFundo1);
        setSize(700, 400);

        // Configurações do Botão voltar
        voltar.setIcon(iconBack);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(this);
        this.add(voltar);

        // Configurações do Botão excluir
        excluir.setBounds(70, 15, 40, 30);
        excluir.addActionListener(this);
        excluir.setIcon(iconCancel);
        add(excluir);

        // Criação do DefaultTableModel com as colunas desejadas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Razão Social");
        model.addColumn("CNPJ");
        model.addColumn("Email");
        model.addColumn("Contato");
        model.addColumn("Responsável");

        // Criação do JTable com o DefaultTableModel
        table = new JTable(model);

        // Criação do JScrollPane com o JTable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 65, 625, 250);
        add(scrollPane);

        // Preenchimento do DefaultTableModel com os dados do banco de dados
        DAOFuncPj daoCPJ = new DAOFuncPj();
        List<FuncionarioPJ> clientes = daoCPJ.lista();
        for (FuncionarioPJ cliente : clientes) {
            Object[] rowData = new Object[5];
            rowData[0] = cliente.getRazao();
            rowData[1] = cliente.getCnpj();
            rowData[2] = cliente.getEmail();
            rowData[3] = cliente.getContato();
            rowData[4] = cliente.getResponsavel();
            model.addRow(rowData);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltar) {
            this.dispose();
            new Manuntencao();
        } else if (e.getSource() == excluir) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);

                // Excluir o objeto no banco de dados
                DAOFuncPj daoCPJ = new DAOFuncPj();
                List<FuncionarioPJ> clientes = daoCPJ.lista();
                FuncionarioPJ cliente = clientes.get(selectedRow);
                daoCPJ.excluir(cliente);
            }
        }
    }
}
