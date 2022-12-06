import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Módulo destinado para as companhias aéreas

public class Companhia {
    private int idCompanhia;
    private String nome;
    private String cnpj;

    Companhia() {
    }

    Companhia(int idCompanhia, String nome, String cnpj) {
        this.idCompanhia = idCompanhia;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    Companhia(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public int getId() {
        return idCompanhia;
    }

    public void setId(int idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Companhia >> " + " id = " + idCompanhia + ", nome=" + nome + ", cnpj=" + cnpj;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Companhia)) {
            return false;
        }
        final Companhia other = (Companhia) obj;
        if (this.idCompanhia != other.idCompanhia) {
            return false;
        }
        return true;
    }

    // Insert
    // Declara função de inserção
    public void insert() throws SQLException {
        // Declaração de variável sql e insere a query
        String sql = "INSERT INTO companhia (nome, cnpj) VALUES (?, ?)";
        // Declaração de variável para preparar a query
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        // Insere os valores na query
        stmt.setString(1, this.nome);
        stmt.setString(2, this.cnpj);
        // Executa a query
        stmt.execute();
        // Fecha a conexão
        DAO.deleteConnect();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE companhia SET nome = ?, cnpj = ? WHERE id_companhia = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.nome);
        stmt.setString(2, this.cnpj);
        stmt.setInt(3, this.idCompanhia);
        stmt.execute();
        DAO.deleteConnect();
    }

    // Delete
    public void delete() throws SQLException {
        // Declaração de variável sql e insere a query
        String sql = "DELETE FROM companhia WHERE id_companhia = ?";
        // Declaração de variável para preparar a query
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        // Insere os valores na query
        stmt.setInt(1, this.idCompanhia);
        // Executa a query
        stmt.execute();
        // Fecha a conexão
        DAO.deleteConnect();
    }

    // getById
    public static Companhia getById(int idCompanhia) throws SQLException {
        // Declaração de variável sql e insere a query
        String sql = "SELECT * FROM companhia WHERE id_companhia = ?";
        // Declaração de variável para preparar a query
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        // Insere os valores na query
        stmt.setInt(1, idCompanhia);
        // Executa a query
        ResultSet rs = stmt.executeQuery();
        // Declaração de variável para armazenar o resultado
        Companhia companhia = null;
        // Verifica se há resultado
        if (rs.next()) {
            // Cria um objeto Companhia
            companhia = new Companhia();
            // Insere os valores do resultado no objeto
            companhia.setId(rs.getInt("id_companhia"));
        }
        // Fecha a conexão
        DAO.deleteConnect();
        // Retorna o resultado
        return companhia;
    }

    // GetALL
    public static List<Companhia> getAll() throws SQLException {
        // Declaração de variável sql e insere a query
        String sql = "SELECT * FROM companhia";
        // Declaração de variável para preparar a query
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        // Executa a query
        ResultSet rs = stmt.executeQuery();
        // Declaração de variável para armazenar o resultado
        List<Companhia> companhias = new ArrayList<>();
        // Verifica se há resultado
        while (rs.next()) {
            // Cria um objeto Companhia
            Companhia companhia = new Companhia();
            // Insere os valores do resultado no objeto
            companhia.setId(rs.getInt("id_companhia"));
            companhia.setNome(rs.getString("nome"));
            companhia.setCnpj(rs.getString("cnpj"));
            // Insere o objeto na lista
            companhias.add(companhia);
        }
        // Fecha a conexão
        DAO.deleteConnect();
        // Retorna o resultado
        return companhias;
    }
}
