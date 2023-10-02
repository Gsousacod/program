package Program.ConexãoBD;

import java.sql.*;
import java.util.*;
import Program.Classes.FuncionarioPJ;

public class DAOFuncPj {
    private Connection conexao;

    public DAOFuncPj() {
        conexao = (Connection) new FabricaDeConexoes().solicitaConexao("localhost:3306", "gestaorh", "root","Ga98030484");
    }

    public void insert(FuncionarioPJ pj) {

        String sql = "INSERT INTO PessoaJuridica " +
                "(razao, cnpj, email, contato, responsavel,departamento) " +
                "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pj.getRazao());
            stmt.setString(2, pj.getCnpj());
            stmt.setString(3, pj.getEmail());
            stmt.setString(4, pj.getContato());
            stmt.setString(5, pj.getResponsavel());
            stmt.setString(6, pj.getDepartamento());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public FuncionarioPJ busca(String n) {
        FuncionarioPJ p = new FuncionarioPJ();
        try {
            String sql = "select * from PessoaJuridica where nome like ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + n + "%");

            ResultSet rs = stmt.executeQuery();
            p.setRazao("Não Encontrado!"); // ANTES p.setNome("Não Encontrado!");-- ta dando erro

            while (rs.next()) {
                if (rs.getString("nome").equals(n)) {
                    p.setRazao(rs.getString("Razao"));
                    p.setCnpj(rs.getString("Cnpj"));
                    p.setEmail(rs.getString("Email"));
                    p.setContato(rs.getString("Contato"));
                    p.setResponsavel(rs.getString("Responsavel"));
                    p.setDepartamento(rs.getString("Departamento"));
                }
            }
            rs.close();
            stmt.close();
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FuncionarioPJ> lista() {
        try {
            List<FuncionarioPJ> funcionarios = new ArrayList<FuncionarioPJ>();
            PreparedStatement stmt = conexao.prepareStatement("select * from PessoaJuridica");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FuncionarioPJ c = new FuncionarioPJ();
                c.setRazao(rs.getString("razao"));
                c.setCnpj(rs.getString("cnpj"));
                c.setEmail(rs.getString("email"));
                c.setContato(rs.getString("contato"));
                c.setResponsavel(rs.getString("responsavel"));
                c.setResponsavel(rs.getString("departamento"));
                funcionarios.add(c);
            }
            rs.close();
            stmt.close();
            return funcionarios;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void altera(FuncionarioPJ c, String n) {
        String sql = "update PessoaJuridica set" +
                     " razao=?, cnpj=?, email=?, contato=?, responsavel=?,departamento=?" +
                     " where cnpj=?"; 

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.getRazao());
            stmt.setString(2, c.getCnpj());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getContato());
            stmt.setString(5, c.getResponsavel());
            stmt.setString(6, c.getDepartamento());
            stmt.setString(7, n);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(FuncionarioPJ pj) {
        String sql = "DELETE FROM PessoaJuridica WHERE cnpj = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pj.getCnpj());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
