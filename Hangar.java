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
    private int idAviao;
    private Aviao aviao;

    Hangar() {
    }

    Hangar(int idHangar, String local, int idAviao) {
        this.idHangar = idHangar;
        this.local = local;
        this.idAviao = idAviao;
    }

    Hangar(String local, int idAviao) {
        this.local = local;
        this.idAviao = idAviao;
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

    public int getidAviao() {
        return idAviao;
    }

    public void setidAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public Aviao getAviao() {
        return aviao;
    }

 
    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    @Override
    public String toString() {
        return "Hangar >>" + " id = " + idHangar + ", local = " + local + ", idAvião = " + idAviao + ", aviao = " + aviao;
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
        String sql = "INSERT INTO hangar (local, id_aviao) VALUES (?, ?)";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.local);
        stmt.setInt(2, this.getidAviao());
        stmt.execute();
        DAO.deleteConnect();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE hangar SET local = ?, id_aviao = ? WHERE id_hangar = ?";
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
            hangar.setidAviao(rs.getInt("idAviao"));
            hangares.add(hangar);
        }
        DAO.deleteConnect();
        return hangares;
    }

}
