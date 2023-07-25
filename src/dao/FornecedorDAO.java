package dao;

import conexao.Conexao;
import entity.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAO {

    private Conexao conexao;
    private Connection conn;

    public FornecedorDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor(cnpj, nome, telefone, email, bairro, rua, numero) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getBairro());
            stmt.setString(6, fornecedor.getRua());
            stmt.setInt(7, fornecedor.getNumero());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "inserido");
        } catch (Exception e) {
            System.out.println("Erro ao inserir." + e.getMessage());
        }
    }

    //listar todos os fornecedores
    public List<Fornecedor> listarFornecedores() {
        try {
            // criar vetor que vair armazenar os registros do banco
            List<Fornecedor> lista = new ArrayList<Fornecedor>();

            //criar coamndo sql
            String sql = "SELECT * from fornecedor order by nome";
            // Este comando seleciona todos os fornecedores da tabela e os ordena em ordem alfabetica pelo nome

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            //guarda resultado do select dentro do objeto rs
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(rs.getInt("idFornecedor"));
                f.setCnpj(rs.getString("cnpj"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setBairro(rs.getString("bairro"));
                f.setRua(rs.getString("rua"));
                f.setNumero(rs.getInt("numero"));

                lista.add(f);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void editar(Fornecedor fornecedor) {
        try {
            String sql = "update fornecedor set cnpj = ?, nome = ?, telefone = ?, email = ?, bairro = ?, rua = ?, numero = ? where idFornecedor = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getBairro());
            stmt.setString(6, fornecedor.getRua());
            stmt.setInt(7, fornecedor.getNumero());
            stmt.setInt(8, fornecedor.getIdFornecedor());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Fornecedor fornecedor) {
        try {
            String sql = "delete from fornecedor where idFornecedor = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, fornecedor.getIdFornecedor());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
