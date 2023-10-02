package Program.Telas;

import Program.Classes.FuncionarioPF;
import Program.ConexãoBD.DAOFuncPf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaTablePF extends JFrame implements ActionListener {
    public ImageIcon iconCancel = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\cancel.png");
    public ImageIcon icone = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\iconePrincipal.png");
    public ImageIcon iconBack = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Images\\voltar.png");


    JButton voltar = new JButton();
    JButton jbExcluir = new JButton("Excluir");
    JButton jbAlterar = new JButton("Alterar");
    JButton jbGerarPdf = new JButton("Gerar PDF");

    JTable table;

    public ImageIcon iconSave = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\save.png");
    public ImageIcon iconPF = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\PF.png");
    public ImageIcon iconPJ = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\PJ.png");

    public ImageIcon iconAlterar = new ImageIcon("C:\\Users\\55339\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoPOO.java\\src\\main\\java\\Program\\Imagens\\alterar.png");

        //------------------------Criação de Cores-----------------------------------------------------------
    public Color corFundo1 = new Color(42, 87, 141);   // Azul-escuro
    public Color corPanel = new Color(96, 125, 139);  // Cinza-azulado
    public Color corLabel1 = new Color(255, 193, 7);  // Amarelo (destaque)
    public Color corLabel2 = new Color(34, 34, 34);   // Cinza-escuro
   public TelaTablePF() {
        setTitle("Resultado da Busca");
        setIconImage(icone.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(corFundo1);
        setSize(1000, 500);
        setLocationRelativeTo(null);


        



        voltar.setIcon(iconBack);
        voltar.setBounds(10, 15, 40, 30);
        voltar.addActionListener(this);
        this.add(voltar);


        jbExcluir.setBounds(850, 405, 110, 30);
        jbExcluir.setHorizontalTextPosition(SwingConstants.LEFT);
        jbExcluir.addActionListener(this);
        jbExcluir.setIcon(iconCancel);

        this.add(jbExcluir);


        jbAlterar.setBounds(730, 405, 110, 30);
        jbAlterar.addActionListener(this);
        jbAlterar.setIcon(iconAlterar);
        add(jbAlterar);


        jbGerarPdf.setBounds(610, 405, 110, 30);
        jbGerarPdf.setHorizontalTextPosition(SwingConstants.LEFT);
        jbGerarPdf.addActionListener(this);
        jbGerarPdf.setIcon(iconCancel);

        this.add(jbGerarPdf);


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Contato");
        model.addColumn("Email");
        model.addColumn("Departamento");

        // Criação do JTable com o DefaultTableModel
        table = new JTable(model);

        // Criação do JScrollPane com o JTable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(75, 55, 900, 340);
        scrollPane.setAutoscrolls(true);

        this.add(scrollPane);


        DAOFuncPf daoCPF = new DAOFuncPf();
        List<FuncionarioPF> clientes = daoCPF.lista();
        for (FuncionarioPF cliente : clientes) {
            Object[] rowData = new Object[5];
            rowData[0] = cliente.getNome();
            rowData[1] = cliente.getCPF();
            rowData[2] = cliente.getContato();
            rowData[3] = cliente.getEmail();
            rowData[4] = cliente.getDepartamento();
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
                DAOFuncPf daoCPF = new DAOFuncPf();
                List<FuncionarioPF> clientes = daoCPF.lista();
                FuncionarioPF cliente = clientes.get(selectedRow);
                daoCPF.excluir(cliente);
            }
        } else if (e.getSource() == jbAlterar) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                DAOFuncPf daoCPF = new DAOFuncPf();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                FuncionarioPF cliente = new FuncionarioPF();
                cliente.setNome((String) model.getValueAt(selectedRow, 0));
                cliente.setCPF((String) model.getValueAt(selectedRow, 1));
                cliente.setContato((String) model.getValueAt(selectedRow, 2));


                // Abre uma nova janela de edição para o cliente selecionado
                TelaAlteracaoPF telaAlteracao = new TelaAlteracaoPF(cliente);
                telaAlteracao.setVisible(true);
                telaAlteracao.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        // Verifica se a janela de edição foi fechada com as alterações salvas
                        if (telaAlteracao.isSaved()) {
                            FuncionarioPF clienteAlterado = telaAlteracao.getFuncionario();
                            // Atualiza os dados no banco de dados
                            daoCPF.altera(clienteAlterado, cliente.getCPF());

                            // Atualiza a tabela com os novos dados
                            model.setValueAt(clienteAlterado.getNome(), selectedRow, 0);
                            model.setValueAt(clienteAlterado.getCPF(), selectedRow, 1);
                            model.setValueAt(clienteAlterado.getContato(), selectedRow, 2);
                        }
                    }
                });
            }
        }
    }
}
    
