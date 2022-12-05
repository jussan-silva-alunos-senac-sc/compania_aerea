//Módulo destinado para os aviões
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aviao extends Aeronave {
    private String prefixo;
    private int capacidade;
    private int idCompanhia;
    private Companhia companhia;

    Aviao() {
    }

    Aviao(int id, String marca, String modelo, String prefixo, int capacidade, int idCompanhia) {
        super(id, marca, modelo);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.idCompanhia = idCompanhia;
    
    }

    Aviao(String marca, String modelo, String prefixo, int capacidade, int idCompanhia) {
        super(marca, modelo);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.idCompanhia = idCompanhia;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(int idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public Companhia getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }

    @Override
    public String toString() {
        return "Aviao{" + "prefixo=" + prefixo + ", capacidade=" + capacidade + ", idCompanhia=" + idCompanhia + ", companhia=" + companhia + '}';
    }


    //Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO aviao (marca, modelo, prefixo, capacidade, idCompanhia) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, this.getMarca());
        ps.setString(2, this.getModelo());
        ps.setString(3, this.getPrefixo());
        ps.setInt(4, this.getCapacidade());
        ps.setInt(5, this.getIdCompanhia());
        ps.execute();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE aviao SET marca = ?, modelo = ?, prefixo = ?, capacidade = ?, idCompanhia = ? WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, this.getMarca());
        ps.setString(2, this.getModelo());
        ps.setString(3, this.getPrefixo());
        ps.setInt(4, this.getCapacidade());
        ps.setInt(5, this.getIdCompanhia());
        ps.setInt(6, this.getId());
        ps.execute();
    }

    // Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM aviao WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.execute();
    }

    // getById
    public void getById(int id) throws SQLException {
        String sql = "SELECT * FROM aviao WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    // GetALL
    public List<Aviao> getAll() throws SQLException {
        String sql = "SELECT * FROM aviao";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.execute();
        return null;
    }

}
