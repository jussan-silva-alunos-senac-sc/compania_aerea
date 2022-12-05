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
    public void insert() {
        try {
            String sql = "INSERT INTO Helicoptero (marca, modelo, cor, capacidade) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
            ps.setString(1, getMarca());
            ps.setString(2, getModelo());
            ps.setString(3, getCor());
            ps.setInt(4, getCapacidade());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Helicoptero: " + e.getMessage());
        }
    }

    // Update
    public void update() {
        try {
            String sql = "UPDATE Helicoptero SET marca = ?, modelo = ?, cor = ?, capacidade = ? WHERE id = ?";
            PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
            ps.setString(1, getMarca());
            ps.setString(2, getModelo());
            ps.setString(3, getCor());
            ps.setInt(4, getCapacidade());
            ps.setInt(5, getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Helicoptero: " + e.getMessage());
        }
    }

    // Delete
    public void delete() {
        try {
            String sql = "DELETE FROM Helicoptero WHERE id = ?";
            PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
            ps.setInt(1, getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Helicoptero: " + e.getMessage());
        }
    }

    // getById
    public Helicoptero getById(int id) {
        try {
            String sql = "SELECT * FROM Helicoptero WHERE id = ?";
            PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Helicoptero h = new Helicoptero();
                h.setId(rs.getInt("id"));
                h.setMarca(rs.getString("marca"));
                h.setModelo(rs.getString("modelo"));
                h.setCor(rs.getString("cor"));
                h.setCapacidade(rs.getInt("capacidade"));
                return h;
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Helicoptero: " + e.getMessage());
        }
        return null;
    }

    // GetALL
    public List<Helicoptero> getAll() {
        List<Helicoptero> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Helicoptero";
            PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Helicoptero h = new Helicoptero();
                h.setId(rs.getInt("id"));
                h.setMarca(rs.getString("marca"));
                h.setModelo(rs.getString("modelo"));
                h.setCor(rs.getString("cor"));
                h.setCapacidade(rs.getInt("capacidade"));
                lista.add(h);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os Helicopteros: " + e.getMessage());
        }
        return lista;
    }
}
