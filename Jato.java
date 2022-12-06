//Módulo destinado para os Jatos
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

public class Jato extends Aeronave {
    private String cor;
    private int velocidade;

    Jato() {
    }

    Jato(int id, String marca, String modelo, String cor, int velocidade) {
        super(id, marca, modelo);
        this.cor = cor;
        this.velocidade = velocidade;
    }

    Jato(String marca, String modelo, String cor, int velocidade) {
        super(marca, modelo);
        this.cor = cor;
        this.velocidade = velocidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String toString() {
        return "Jato{" + "cor=" + cor + ", velocidade=" + velocidade + '}';
    }

    //Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO jato (marca, modelo, cor, velocidade) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.getMarca());
        stmt.setString(2, this.getModelo());
        stmt.setString(3, this.cor);
        stmt.setInt(4, this.velocidade);
        stmt.execute();
        DAO.deleteConnect();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE jato SET marca = ?, modelo = ?, cor = ?, velocidade = ? WHERE id_jato = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.getMarca());
        stmt.setString(2, this.getModelo());
        stmt.setString(3, this.cor);
        stmt.setInt(4, this.velocidade);
        stmt.setInt(5, this.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    // Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM jato WHERE id_jato = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, this.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    // getById
    public static Jato getById(int id) throws SQLException {
            String sql = "SELECT * FROM jato WHERE id_jato = ?";
            PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Jato jato = null;
            if (rs.next()) {
                jato = new Jato();
                jato.setId(rs.getInt("id_jato"));
            }
            DAO.deleteConnect();
            return jato;
    }

    // GetALL
    public List<Jato> getAll() throws SQLException {
        String sql = "SELECT * FROM jato";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Jato> jatos = new ArrayList<>();
        while (rs.next()) {
            Jato jato = new Jato();
            jato.setId(rs.getInt("id_jato"));
            jato.setMarca(rs.getString("marca"));
            jato.setModelo(rs.getString("modelo"));
            jato.setCor(rs.getString("cor"));
            jato.setVelocidade(rs.getInt("velocidade"));
            jatos.add(jato);
        }
        DAO.deleteConnect();
        return jatos;
    }
}
