//Módulo destinado para as Pistas
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pista {
    private int id;
    private String numero;

    Pista() {
    }

    Pista(int id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    Pista(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pista{" + "id=" + id + ", numero=" + numero + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Pista)) {
            return false;
        }
        final Pista other = (Pista) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    //Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO pista (numero) VALUES (?)";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, this.numero);
        ps.execute();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE pista SET numero = ? WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, this.numero);
        ps.setInt(2, this.id);
        ps.execute();
    }

    // Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM pista WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setInt(1, this.id);
        ps.execute();
    }

    // getById
    public static Pista getById(int id) throws SQLException {
        String sql = "SELECT * FROM pista WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        return null;
    }

    // GetALL
    public static List<Pista> getAll() throws SQLException {
        String sql = "SELECT * FROM pista";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.execute();
        return null;
    }
    
}
