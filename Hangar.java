//Módulo destinado para os Hangares
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Hangar extends DAO {
    private int idHangar;
    private String local;
    private int idAeronave;
    private Aviao aviao;

    Hangar() {
    }

    Hangar(int idHangar, String local, int idAeronave) {
        this.idHangar = idHangar;
        this.local = local;
        this.idAeronave = idAeronave;
    }

    Hangar(String local, int idAeronave) {
        this.local = local;
        this.idAeronave = idAeronave;
    }

    public int getId() {
        return idHangar;
    }

    public void setId(int idHangar) {
        this.idHangar = idHangar;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getidAeronave() {
        return idAeronave;
    }

    public void setidAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }

    public Aviao getAviao() {
        return aviao;
    }

    private int getidAviao() {
		return idAeronave;
	}

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    @Override
    public String toString() {
        return "Hangar >>" + " id = " + idHangar + ", local = " + local + ", idAvião = " + idAeronave + ", aviao = " + aviao;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Hangar)) {
            return false;
        }
        final Hangar other = (Hangar) obj;
        if (this.idHangar != other.idHangar) {
            return false;
        }
        return true;
    }

    //Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO hangar (local, idAeronave) VALUES (?, ?)";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.local);
        stmt.setInt(2, this.aviao.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE hangar SET local = ?, idAeronave = ? WHERE id_hangar = ?";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setString(1, this.getLocal());
        stmt.setInt(2, this.getidAviao());
        stmt.setInt(3, this.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

	// Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM hangar WHERE id_hangar = ?";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setInt(1, this.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    // getById
    public static Hangar getById(int id) throws SQLException {
        String sql = "SELECT * FROM hangar WHERE id_hangar = ?";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Hangar hangar = null;
        if (rs.next()) {
            hangar = new Hangar();
            hangar.setId(rs.getInt("id_hangar"));
        }
        DAO.deleteConnect();
        return hangar;
    }

    // GetALL
    public static List<Hangar> getAll() throws SQLException {
        String sql = "SELECT * FROM hangar";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Hangar> hangares = new ArrayList<>();
        while (rs.next()) {
            Hangar hangar = new Hangar();
            hangar.setId(rs.getInt("id"));
            hangar.setLocal(rs.getString("local"));
            hangar.setidAeronave(rs.getInt("idAeronave"));
            hangares.add(hangar);
        }
        DAO.deleteConnect();
        return hangares;
    }

}
