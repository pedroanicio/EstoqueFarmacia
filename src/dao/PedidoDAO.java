package dao;

import conexao.Conexao;
import entity.Cliente;
import entity.Medicamento;
import entity.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoDAO {

    private Conexao conexao;
    private Connection conn;

    public PedidoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public List<Pedido> listarPedidos() {
        try {
            // criar vetor que vai armazenar os registros do banco
            List<Pedido> lista = new ArrayList<Pedido>();

            //criar coamndo sql
            String sql = "select p.idPedido, p.dia, p.qtdeMedicamento, c.nome, m.nome from pedido as p "
                    + "JOIN cliente as c JOIN medicamento as m on(p.idcliente = c.idCliente and p.idmedicamento = m.idMedicamento);";

            //essa consulta SQL está selecionando várias colunas das tabelas pedido, 
            //cliente e medicamento, e está combinando essas tabelas com base nas condições fornecidas.
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            //guarda resultado do select dentro do objeto rs
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                Cliente cliente = new Cliente();
                Medicamento medicamento = new Medicamento();

                cliente.setNome(rs.getString("c.nome"));
                medicamento.setNome(rs.getString("m.nome"));

                p.setIdPedido(rs.getInt("idPedido"));
                p.setQtdeMedicamento(rs.getInt("qtdeMedicamento"));
                p.setDia(rs.getString("dia"));

                p.setIdCliente(cliente);
                p.setIdMedicamento(medicamento);

                lista.add(p);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //Listar todos os pedidos dos clientes
    public List<Pedido> listarPedidosClientes() {
        try {
            // criar vetor que vair armazenar os registros do banco
            List<Pedido> lista = new ArrayList<Pedido>();

            //criar coamndo sql
            String sql = "select c.nome, m.nome, p.idPedido, p.qtdeMedicamento, p.dia from "
                    + "cliente as c join medicamento as m join pedido as p on(c.idCliente = p.idcliente and m.idMedicamento = p.idMedicamento)order by c.idCliente";
            // Este comando seleciona o nome do cliente, nome do medicamento, quantidade de itens do pedido e a data, e os exibe de forma ordenada pelo id do cliente

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            //guarda resultado do select dentro do objeto rs
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();

                Cliente cliente = new Cliente();
                Medicamento medicamento = new Medicamento();

                cliente.setNome(rs.getString("c.nome"));
                medicamento.setNome(rs.getString("m.nome"));

                p.setIdPedido(rs.getInt("idPedido"));
                p.setQtdeMedicamento(rs.getInt("qtdeMedicamento"));
                p.setDia(rs.getString("dia"));

                p.setIdCliente(cliente);
                p.setIdMedicamento(medicamento);

                lista.add(p);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Pedido> listarPedidosComNomeCompletoTelefone() {
        try {
            List<Pedido> lista = new ArrayList<Pedido>();

            String sql = "SELECT CONCAT(c.nome, '     -      ', c.telefone) AS nome_completo_telefone, m.nome, p.idPedido, p.qtdeMedicamento, p.dia "
                    + "FROM cliente AS c JOIN medicamento AS m JOIN pedido AS p "
                    + "ON (c.idCliente = p.idcliente AND m.idMedicamento = p.idMedicamento) "
                    + "ORDER BY c.idCliente";

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                Cliente cliente = new Cliente();
                Medicamento medicamento = new Medicamento();

                String nomeCompletoTelefone = rs.getString("nome_completo_telefone");
                cliente.setNome(nomeCompletoTelefone);

                medicamento.setNome(rs.getString("m.nome"));

                p.setIdPedido(rs.getInt("idPedido"));
                p.setQtdeMedicamento(rs.getInt("qtdeMedicamento"));
                p.setDia(rs.getString("dia"));

                p.setIdCliente(cliente);
                p.setIdMedicamento(medicamento);

                lista.add(p);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void inserir(Pedido pedido) {
        String sql = "INSERT INTO pedido(idcliente, idmedicamento, dia, qtdeMedicamento) VALUES "
                + "(?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pedido.getIdCliente().getIdCliente());
            stmt.setInt(2, pedido.getIdMedicamento().getIdMedicamento());
            stmt.setString(3, pedido.getDia());
            stmt.setInt(4, pedido.getQtdeMedicamento());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Inserido!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir." + e.getMessage());
        }
    }

    public void editar(Pedido pedido) {
        try {
            String sql = "update pedido set dia = ?, qtdeMedicamento = ?, idcliente = ?, idmedicamento = ? where idPedido = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, pedido.getDia());
            stmt.setInt(2, pedido.getQtdeMedicamento());
            stmt.setInt(3, pedido.getIdCliente().getIdCliente());
            stmt.setInt(4, pedido.getIdMedicamento().getIdMedicamento());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Pedido pedido) {
        try {
            String sql = "delete from pedido where idPedido = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, pedido.getIdPedido());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
