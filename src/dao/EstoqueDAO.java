package dao;

import conexao.Conexao;
import entity.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EstoqueDAO {

    private Conexao conexao;
    private Connection conn;

    public EstoqueDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Estoque estoque) {
        String sql = "INSERT INTO estoque(nome) VALUES "
                + "(?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, estoque.getNome());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Inserido");
        } catch (Exception e) {
            System.out.println("Erro ao inserir curso." + e.getMessage());
        }
    }

    public List<Estoque> listarEstoques() {
        try {
            List<Estoque> lista = new ArrayList<Estoque>();

            String sql = "SELECT * from estoque";
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Estoque e = new Estoque();
                e.setIdEstoque(rs.getInt("idEstoque"));
                e.setNome(rs.getString("nome"));

                lista.add(e);
            }
            return lista;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void editar(Estoque estoque) {
        try {
            String sql = "update estoque set nome = ? where idEstoque = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, estoque.getNome());
            stmt.setInt(2, estoque.getIdEstoque());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Estoque estoque) {
        try {
            String sql = "delete from estoque where idEstoque = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, estoque.getIdEstoque());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
