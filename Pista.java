//Módulo destinado para as Pistas
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pista extends Identificacao {
    private int idPista;
    private Identificacao<String> numero;

    Pista() {
    }

    Pista(int idPista, Identificacao<String> numero) {
        this.idPista = idPista;
        this.numero = numero;
    }

    Pista(Identificacao<String> numero) {
        this.numero = numero;
    }

    public int getId() {
        return idPista;
    }

    public void setId(int idPista) {
        this.idPista = idPista;
    }

    public void setNumero(Identificacao<String> numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pista >>" + " id = " + idPista + ", numero = " + numero;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Pista)) {
            return false;
        }
        final Pista other = (Pista) obj;
        if (this.idPista != other.idPista) {
            return false;
        }
        return true;
    }
    
    //Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO Pista (numero) VALUES (?)";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.numero.getNumero());
        stmt.execute();
        DAO.deleteConnect();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE pista SET numero = ? WHERE id_pista = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.numero.getNumero());
        stmt.setInt(2, this.idPista);
        stmt.execute();
        DAO.deleteConnect();
    }

    // Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM pista WHERE id_pista = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, this.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    // getById
    public static Pista getById(int id) throws SQLException {
        String sql = "SELECT * FROM pista WHERE id_pista = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Pista pista = null;
        if (rs.next()) {
            pista = new Pista();
            pista.setId(rs.getInt("id_pista"));
        }
        DAO.deleteConnect();
        return pista;
    }

    // GetALL
    public List<Pista> getAll() throws SQLException {
        String sql = "SELECT * FROM pista";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Pista> pistas = new ArrayList<>();
        while (rs.next()) {
            Pista pista = new Pista();
            pista.setId(rs.getInt("id_pista"));
            pista.setNumero(new Identificacao<String>(rs.getString("numero")));
            pistas.add(pista);
        }
        DAO.deleteConnect();
        return pistas;
    }

}
