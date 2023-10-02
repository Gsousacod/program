package Program.Telas;

import Program.Classes.FuncionarioPJ;
import Program.ConexãoBD.DAOFuncPj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaTablePJ extends JFrame implements ActionListener {
    public ImageIcon iconSave = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\save.png");
    public ImageIcon iconPF = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\PF.png");
    public ImageIcon iconPJ = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\PJ.png");
    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\voltar.png");
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");
    public ImageIcon iconAlterar = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\alterar.png");


    JButton voltar = new JButton();
    JButton jbExcluir = new JButton("Excluir");
    JButton jbAlterar = new JButton("Alterar");
    JTable table;
 

    //------------------------Criação de Cores-----------------------------------------------------------
    public Color corFundo1 = new Color(42, 87, 141);   // Azul-escuro
    public Color corPanel = new Color(96, 125, 139);  // Cinza-azulado
    public Color corLabel1 = new Color(255, 193, 7);  // Amarelo (destaque)
    public Color corLabel2 = new Color(34, 34, 34);   // Cinza-escuro   //definindo a cor de fundo em um objeto
    public ImageIcon iconCancel = new ImageIcon("Program/Images/cancel.png");

    public TelaTablePJ() {
        setTitle("Resultado da Busca");
        setIconImage(icone.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(corFundo1);
        setSize(1000, 500);
        setLocationRelativeTo(null);

        

        // Configurações do Botão voltar
        voltar.setIcon(iconBack);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(this);
        this.add(voltar);

        // Configurações do Botão excluir
        jbExcluir.setBounds(850, 405, 110, 30);
        jbExcluir.setHorizontalTextPosition(SwingConstants.LEFT);
        jbExcluir.addActionListener(this);
        jbExcluir.setIcon(iconCancel);
        
        this.add(jbExcluir);

        // Configurações do Botão alterar
        jbAlterar.setBounds(730, 405, 110, 30);
        jbAlterar.setIcon(iconAlterar);
        jbAlterar.setAlignmentX(LEFT_ALIGNMENT);
        jbAlterar.addActionListener(this);
        // jbAlterar.setIcon(iconAlterar);
        add(jbAlterar);

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
        scrollPane.setBounds(75, 55, 900, 340);
        scrollPane.setAutoscrolls(true);
        
        
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
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltar) {
            this.dispose();
            new Manuntencao();
        } else if (e.getSource() == jbExcluir) {
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
        } else if (e.getSource() == jbAlterar) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                DAOFuncPj daoCPJ = new DAOFuncPj();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                FuncionarioPJ cliente = new FuncionarioPJ();
                cliente.setRazao((String) model.getValueAt(selectedRow, 0));
                cliente.setCnpj((String) model.getValueAt(selectedRow, 1));
                cliente.setEmail((String) model.getValueAt(selectedRow, 2));
                cliente.setContato((String) model.getValueAt(selectedRow, 3));
                cliente.setResponsavel((String) model.getValueAt(selectedRow, 4));


                // Abre uma nova janela de edição para o cliente selecionado
                TelaAlteracaoPJ telaAlteracao = new TelaAlteracaoPJ(cliente);
                telaAlteracao.setVisible(true);
                telaAlteracao.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        // Verifica se a janela de edição foi fechada com as alterações salvas
                        if (telaAlteracao.isSaved()) {
                            FuncionarioPJ clienteAlterado = telaAlteracao.getCliente();
                            // Atualiza os dados no banco de dados
                            daoCPJ.altera(clienteAlterado, cliente.getRazao());

                            // Atualiza a tabela com os novos dados
                            model.setValueAt(clienteAlterado.getRazao(), selectedRow, 0);
                            model.setValueAt(clienteAlterado.getCnpj(), selectedRow, 1);
                            model.setValueAt(clienteAlterado.getEmail(), selectedRow, 2);
                            model.setValueAt(clienteAlterado.getContato(), selectedRow, 3);
                            model.setValueAt(clienteAlterado.getResponsavel(), selectedRow, 4);
                        }
                    }
                });
            }
        }
    }
}