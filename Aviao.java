//Módulo destinado para os aviões
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aviao extends Aeronave {
    private Identificacao<String, Integer> prefixo;
    private int capacidade;
    private int idCompanhia;
    private Companhia companhia;

    Aviao() {
    }

    Aviao(int id, String marca, String modelo, Identificacao<String, Integer> prefixo, int capacidade, Companhia companhia) {
        super(id, marca, modelo);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.companhia = companhia;
    
    }

    Aviao(String marca, String modelo, Identificacao<String, Integer> prefixo, int capacidade, Companhia companhia) {
        super(marca, modelo);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.companhia = companhia;
    }

    public Identificacao<String, Integer> getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Identificacao<String, Integer> prefixo) {
        this.prefixo = prefixo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getidCompanhia() {
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
        String sql = "INSERT INTO aviao (marca, modelo, prefixo, capacidade, id_companhia) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, this.getMarca());
        ps.setString(2, this.getModelo());
        ps.setString(3, ((Object) this.getPrefixo()).toString());
        ps.setInt(4, this.getCapacidade());
        ps.setInt(5, Companhia.getById(idCompanhia).getId());
        ps.execute();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE aviao SET marca = ?, modelo = ?, prefixo = ?, capacidade = ?, id_companhia = ? WHERE id_aviao = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, this.getMarca());
        ps.setString(2, this.getModelo());
        ps.setString(3, ((Object) this.getPrefixo()).toString());
        ps.setInt(4, this.getCapacidade());
        ps.setInt(5, this.getidCompanhia());
        ps.setInt(6, this.getId());
        ps.execute();
    }

    // Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM aviao WHERE id_aviao = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.execute();
    }

    // getById
    public void getById(int id) throws SQLException {
        String sql = "SELECT * FROM aviao WHERE id_aviao = ?";
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
