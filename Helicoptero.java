//Módulo destinado para os Helicópteros
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Helicoptero extends Aeronave {
    private String cor;
    private int capacidade;

    Helicoptero() {
    }

    Helicoptero(int id, String marca, String modelo, String cor, int capacidade) {
        super(id, marca, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
    }

    Helicoptero(String marca, String modelo, String cor, int capacidade) {
        super(marca, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Helicoptero{" + "cor=" + cor + ", capacidade=" + capacidade + '}';
    }

    //Insert
    public void insert() throws SQLException {
            String sql = "INSERT INTO helicoptero (marca, modelo, cor, capacidade) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
            stmt.setString(1, getMarca());
            stmt.setString(2, getModelo());
            stmt.setString(3, getCor());
            stmt.setInt(4, getCapacidade());
            stmt.execute();
            DAO.deleteConnect();
    }

    // Update
    public void update() throws SQLException {
            String sql = "UPDATE helicoptero SET marca = ?, modelo = ?, cor = ?, capacidade = ? WHERE id_helicoptero = ?";
            PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
            stmt.setString(1, getMarca());
            stmt.setString(2, getModelo());
            stmt.setString(3, getCor());
            stmt.setInt(4, getCapacidade());
            stmt.setInt(5, getId());
            stmt.execute();
            DAO.deleteConnect();
    }

    // Delete
    public void delete() throws SQLException {
            String sql = "DELETE FROM helicoptero WHERE id_helicoptero = ?";
            PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
            stmt.setInt(1, getId());
            stmt.execute();
            DAO.deleteConnect();
    }

    // getById
    public static Helicoptero getById(int id) throws SQLException {
            String sql = "SELECT * FROM helicoptero WHERE id_helicoptero = ?";
            PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Helicoptero helicoptero = null;
            if (rs.next()) {
                helicoptero = new Helicoptero();
                helicoptero.setId(rs.getInt("id_helicoptero"));
            }
            DAO.deleteConnect();
            return helicoptero;
    }

    // GetALL
    public List<Helicoptero> getAll() throws SQLException {
            String sql = "SELECT * FROM helicoptero";
            PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Helicoptero> helicopteros = new ArrayList<>();
            while (rs.next()) {
                Helicoptero helicoptero = new Helicoptero();
                helicoptero.setId(rs.getInt("id_helicoptero"));
                helicoptero.setMarca(rs.getString("marca"));
                helicoptero.setModelo(rs.getString("modelo"));
                helicoptero.setCor(rs.getString("cor"));
                helicoptero.setCapacidade(rs.getInt("capacidade"));
                helicopteros.add(helicoptero);
            }
            DAO.deleteConnect();
            return helicopteros;
    }

}
