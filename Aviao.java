//Módulo destinado para os aviões
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aviao extends Aeronave {
    private static int id;
    private Identificacao<String> prefixo;
    private int capacidade;
    private int idCompanhia;
    private Companhia companhia;

    Aviao() {
    }

    Aviao(int id, String marca, String modelo, Identificacao<String> prefixo, int capacidade, Companhia companhia) {
        super(marca, modelo);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.companhia = companhia;
    
    }

    Aviao(String marca, String modelo, Identificacao<String> prefixo, int capacidade, Companhia companhia) {
        super(marca, modelo);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.companhia = companhia;
    }

    public void setPrefixo(Identificacao<String> prefixo) {
        this.prefixo = prefixo;
    }

    public static int getidAviao() {
        return id;
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
        return "Aviao >> " + " Id do Avião = " + getidAviao() + ", prefixo = " + prefixo + ", capacidade = " + capacidade + ", idCompanhia = " + idCompanhia + ", companhia = " + companhia;
    }


    //Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO aviao (marca, modelo, prefixo, capacidade, id_companhia) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.getMarca());
        stmt.setString(2, this.getModelo());
        stmt.setString(3, this.prefixo.getNumero());
        stmt.setInt(4, this.getCapacidade());
        stmt.setInt(5, this.companhia.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    // Update
    public void update() throws SQLException {
        String sql = "UPDATE aviao SET marca = ?, modelo = ?, prefixo = ?, capacidade = ?, id_companhia = ? WHERE id_aviao = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.getMarca());
        stmt.setString(2, this.getModelo());
        stmt.setString(3, this.prefixo.getNumero());
        stmt.setInt(4, this.getCapacidade());
        stmt.setInt(5, this.getidCompanhia());
        stmt.setInt(6, this.getidAviao());
        stmt.execute();
        DAO.deleteConnect();
    }

    // Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM aviao WHERE id_aviao = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, this.getidAviao());
        stmt.execute();
        DAO.deleteConnect();
    }

    // getById
    public static Aviao getById(int id) throws SQLException {
        String sql = "SELECT * FROM aviao WHERE id_aviao = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Aviao aviao = null;
        if (rs.next()) {
            aviao = new Aviao();
            aviao.setId(rs.getInt("id_aviao"));
        }
        DAO.deleteConnect();
        return aviao;
    }

    // GetALL
    public List<Aviao> getAll() throws SQLException {
        String sql = "SELECT * FROM aviao";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Aviao> avioes = new ArrayList<>();
        while (rs.next()) {
            Aviao aviao = new Aviao();
            aviao.setId(rs.getInt("id_aviao"));
            aviao.setMarca(rs.getString("marca"));
            aviao.setModelo(rs.getString("modelo"));
            aviao.setPrefixo(new Identificacao<String>(rs.getString("prefixo")));
            aviao.setCapacidade(rs.getInt("capacidade"));
            aviao.setIdCompanhia(rs.getInt("id_companhia"));
            avioes.add(aviao);
        }
        DAO.deleteConnect();
        return avioes;
    }

}
