package Program.ConexãoBD;

import Program.Classes.FuncionarioPF;
import java.sql.*;
import java.util.*;

public class DAOFuncPf {
    private Connection conexao;

    public DAOFuncPf() {
        conexao = (Connection) new FabricaDeConexoes().solicitaConexao("localhost:3306", "gestaorh", "root","Ga98030484");
    }
    public void insert(FuncionarioPF c) {
        String sql = "INSERT INTO PessoaFisica" +
                "(nome, cpf, contato,departamento,email)" +
                " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCPF());
            stmt.setString(3, c.getContato());
            stmt.setString(4, c.getDepartamento());
            stmt.setString(5, c.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public FuncionarioPF busca (String n) {
        FuncionarioPF p = new FuncionarioPF();
        try{
            String sql = "select * from PessoaFisica where nome like ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,"%"+ n + "%");
            ResultSet rs = stmt.executeQuery();
    
            p.setNome("Não Encontrado!");
    
            while(rs.next()){
                if(rs.getString("nome").equals(n)){
                    p.setNome(rs.getString("nome"));
                    p.setContato(rs.getString("contato"));
                    p.setCPF(rs.getString("CPF"));
                    p.setDepartamento(rs.getString("departamento"));
                    p.setEmail(rs.getString("email"));
                }
            }
            rs.close();
            stmt.close();
            return p;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<FuncionarioPF> lista() {
        try {
            List<FuncionarioPF> clipf = new ArrayList<FuncionarioPF>();
            PreparedStatement stmt = conexao.prepareStatement("select * from PessoaFisica");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FuncionarioPF c = new FuncionarioPF();
                c.setNome(rs.getString("nome"));
                c.setContato(rs.getString("contato"));
                c.setCPF(rs.getString("CPF"));
                c.setDepartamento(rs.getString("departamento"));
                c.setEmail(rs.getString("email"));

                clipf.add(c);
            }
            rs.close();
            stmt.close();
            return clipf;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void excluir(FuncionarioPF pf) {
        String sql = "DELETE FROM PessoaFisica WHERE cpf = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pf.getCPF());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(FuncionarioPF c, String n) {
        String sql = "update PessoaFisica set" +
                     " nome=?, cpf=?, contato=?, departamento=?,email=?" +
                     " where cpf=?"; 
                     try {
                        PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1, c.getNome());
                        stmt.setString(2, c.getCPF());
                        stmt.setString(3, c.getContato());
                         stmt.setString(4, c.getDepartamento());
                         stmt.setString(5, c.getEmail());
                        stmt.setString(6, n);
            
                        stmt.execute();
                        stmt.close();
            
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            
    }

