//Módulo destinado para os Jatos
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, this.getMarca());
        ps.setString(2, this.getModelo());
        ps.setString(3, this.getCor());
        ps.setInt(4, this.getVelocidade());
        ps.execute();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE jato SET marca = ?, modelo = ?, cor = ?, velocidade = ? WHERE id_jato = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, this.getMarca());
        ps.setString(2, this.getModelo());
        ps.setString(3, this.getCor());
        ps.setInt(4, this.getVelocidade());
        ps.setInt(5, this.getId());
        ps.execute();
    }

    // Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM jato WHERE id_jato = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.execute();
    }

    // getById
    public void getById(int id) {
        try {
            String sql = "SELECT * FROM jato WHERE id_jato = ?";
            PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Jato: " + ex.getMessage());
        }
    }

    // GetALL
    public List<Jato> getAll() {
        List<Jato> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM jato";
            PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Jato: " + ex.getMessage());
        }
        return lista;
    }
    
}
