import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Módulo destinado para as companhias aéreas

public class Companhia {
    private int id;
    private String nome;
    private String cnpj;

    Companhia() {
    }

    Companhia(int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    Companhia(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Companhia{" + "id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Companhia)) {
            return false;
        }
        final Companhia other = (Companhia) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    // Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO companhia (nome, cnpj) VALUES (?, ?)";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.nome);
        stmt.setString(2, this.cnpj);
        stmt.execute();
        DAO.deleteConnect();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE companhia SET nome = ?, cnpj = ? WHERE id = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.nome);
        stmt.setString(2, this.cnpj);
        stmt.setInt(3, this.id);
        stmt.execute();
        DAO.deleteConnect();
    }

    // Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM companhia WHERE id = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, this.id);
        stmt.execute();
        DAO.deleteConnect();
    }

    // getById
    public static Companhia getById(int id) throws SQLException {
        String sql = "SELECT * FROM companhia WHERE id = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Companhia companhia = null;
        if (rs.next()) {
            companhia = new Companhia();
            companhia.setId(rs.getInt("id"));
            companhia.setNome(rs.getString("nome"));
            companhia.setCnpj(rs.getString("cnpj"));
        }
        DAO.deleteConnect();
        return companhia;
    }

    // GetALL
    public static List<Companhia> getAll() throws SQLException {
        String sql = "SELECT * FROM companhia";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Companhia> companhias = new ArrayList<>();
        while (rs.next()) {
            Companhia companhia = new Companhia();
            companhia.setId(rs.getInt("id"));
            companhia.setNome(rs.getString("nome"));
            companhia.setCnpj(rs.getString("cnpj"));
            companhias.add(companhia);
        }
        DAO.deleteConnect();
        return companhias;
    }
}
