package dao;

import conexao.Conexao;
import entity.Cliente;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClienteDAO {

    private Conexao conexao;
    private Connection conn;

    // construtor é executado automaticamente sempre que um novo objeto for criado
    public ClienteDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, telefone, cpf, bairro, rua, numero) VALUES "
                + "(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getRua());
            stmt.setInt(6, cliente.getNumero());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Inserido");
        } catch (Exception e) {
            System.out.println("Erro ao inserir curso." + e.getMessage());
        }
    }

    //listar todos os clientes
    public List<Cliente> listarClientes() {
        try {
            // criar vetor que vair armazenar os registros do banco
            List<Cliente> lista = new ArrayList<Cliente>();

            //criar coamndo sql
            String sql = "SELECT * from cliente group by idCliente";
            // Este comando seleciona todos os clientes da tabela e os ordena em ordem crescente pelo idCliente

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            //guarda resultado do select dentro do objeto rs
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));
                c.setBairro(rs.getString("bairro"));
                c.setRua(rs.getString("rua"));
                c.setNumero(rs.getInt("numero"));

                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void editar(Cliente cliente) {
        try {
            String sql = "update cliente set nome = ?, telefone = ?, cpf = ?, bairro = ?, rua = ?, numero = ? where idCliente = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getRua());
            stmt.setInt(6, cliente.getNumero());
            stmt.setInt(7, cliente.getIdCliente());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Cliente cliente) {
        try {
            String sql = "delete from cliente where idCliente = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, cliente.getIdCliente());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
