package dao;

import conexao.Conexao;
import entity.Estoque;
import entity.Fornecedor;
import entity.Medicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MedicamentoDAO {

    private Conexao conexao;
    private Connection conn;

    public MedicamentoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public List<Medicamento> listarMedicamentos() {
        try {
            // criar vetor que vair armazenar os registros do banco
            List<Medicamento> lista = new ArrayList<Medicamento>();

            //criar coamndo sql
            String sql = "select m.idMedicamento, m.nome, m.descricao, m.valor, m.qtde, f.nome, e.nome FROM medicamento as m "
                    + "JOIN fornecedor as f JOIN estoque as e on (m.idfornecedor = f.idFornecedor and m.idEstoque = e.idEstoque)";

            //essa consulta SQL está selecionando várias colunas das tabelas medicamento, 
            //fornecedor e estoque, e está combinando essas tabelas com base nas condições fornecidas.//
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            //guarda resultado do select dentro do objeto rs
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Medicamento m = new Medicamento();
                Fornecedor f = new Fornecedor();
                Estoque e = new Estoque();

                f.setNome(rs.getString("f.nome"));
                e.setNome(rs.getString("e.nome"));

                m.setIdMedicamento(rs.getInt("m.IdMedicamento"));
                m.setDescricao(rs.getString("m.descricao"));
                m.setNome(rs.getString("m.nome"));
                m.setValor(rs.getFloat("m.valor"));
                m.setQtde(rs.getInt("m.qtde"));
                //fornecedor
                m.setIdFornecedor(f);
                //estoque
                m.setIdEstoque(e);

                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // ...
    public List<String> listarFornecedorMedicamento() {
        try {
            List<String> lista = new ArrayList<>();

            String sql = "SELECT CONCAT('Fornecedor: ', f.nome, '     ---->     Medicamento: ', m.nome) AS informacao "
                    + "FROM fornecedor AS f "
                    + "JOIN medicamento AS m ON f.idFornecedor = m.idfornecedor";

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String informacao = rs.getString("informacao");
                lista.add(informacao);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listarClientesMedicamentos() {
        try {
            List<String> lista = new ArrayList<String>();

            String sql = "SELECT CONCAT(c.nome, '     ----->     ', m.nome) AS cliente_medicamento "
                    + "FROM cliente c "
                    + "JOIN pedido p ON c.idCliente = p.idcliente "
                    + "JOIN medicamento m ON p.idmedicamento = m.idMedicamento";

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String clienteMedicamento = rs.getString("cliente_medicamento");
                lista.add(clienteMedicamento);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void inserir(Medicamento medicamento) {
        String sql = "INSERT INTO medicamento(nome, valor, descricao, qtde, idfornecedor, idestoque) VALUES"
                + "(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, medicamento.getNome());
            stmt.setFloat(2, medicamento.getValor());
            stmt.setString(3, medicamento.getDescricao());
            stmt.setInt(4, medicamento.getQtde());
            stmt.setInt(5, medicamento.getIdFornecedor().getIdFornecedor());
            stmt.setInt(6, medicamento.getIdEstoque().getIdEstoque());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Inserido!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir." + e);
        }
    }

    public void editar(Medicamento medicamento) {
        try {
            String sql = "update medicamento set nome = ?, valor = ?, descricao = ?, qtde = ?, idfornecedor = ?, idestoque = ? where idMedicamento = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, medicamento.getNome());
            stmt.setFloat(2, medicamento.getValor());
            stmt.setString(3, medicamento.getDescricao());
            stmt.setInt(4, medicamento.getQtde());
            stmt.setInt(5, medicamento.getIdFornecedor().getIdFornecedor());
            stmt.setInt(6, medicamento.getIdEstoque().getIdEstoque());
            stmt.setInt(7, medicamento.getIdMedicamento());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Medicamento medicamento) {
        try {
            String sql = "delete from medicamento where idMedicamento = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, medicamento.getIdMedicamento());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
