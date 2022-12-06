//Módulo destinado para os Voos
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Voo extends DAO {
    private static int idVoo;
    private Identificacao<String> numero;
    private String data;
    private String hora;
    private String origem;
    private String destino;
    private String piloto;
    private String copiloto;
    private String observacao;
    private int idPista;
    private Pista pista;
    private int idAeronave;
    private Aeronave Aeronave;
    private int idAviao;
    private Aviao aviao;
    private int idHelicoptero;
    private Helicoptero helicoptero;
    private int idJato;
    private Jato jato;

    Voo() {
    }

    Voo(int idVoo, Identificacao<String> numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao, int idPista, int idAeronave) {
        this.idVoo = idVoo;
        this.numero = numero;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.observacao = observacao;
        this.idPista = idPista;
        this.idAeronave = idAeronave;
 
    }

    Voo(Identificacao<String> numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao, int idPista, int idAeronave) {
        this.numero = numero;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.observacao = observacao;
        this.idPista = idPista;
        this.idAeronave = idAeronave;
    }

    public void setNumero(Identificacao<String> numero) {
        this.numero = numero;
    }

    public static int getId() {
        return idVoo;
    }

    public void setId(int idVoo) {
        this.idVoo = idVoo;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public String getCopiloto() {
        return copiloto;
    }

    public void setCopiloto(String copiloto) {
        this.copiloto = copiloto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getIdPista() {
        return idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public int getIdAeronave() {
        return idAeronave;
    }

    public void setIdAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Helicoptero getHelicoptero() {
        return helicoptero;
    }

    public void setHelicoptero(Helicoptero helicoptero) {
        this.helicoptero = helicoptero;
    }
    public Jato getJato() {
        return jato;
    }

    public void setJato(Jato jato) {
        this.jato = jato;
    }

    @Override
    public String toString() {
        return "Voo >>" + " id = " + idVoo + ", numero = " + numero + ", data = " + data + ", hora = " + hora + ", origem = " + origem + ", destino = " + destino + ", piloto = " + piloto + ", copiloto = " + copiloto + ", observacao = " + observacao + ", idPista = " + idPista + ", pista = " + pista + ", idAeronave = " + idAeronave + ", aviao = " + aviao + ", helicoptero = " + helicoptero + ", jato = " + jato;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Voo)) {
            return false;
        }
        final Voo other = (Voo) obj;
        if (this.idVoo != other.idVoo) {
            return false;
        }
        return true;
    }

    //Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO voo (numero, data, hora, origem, destino, piloto, copiloto, observacao, idPista, idAeronave) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.numero.getNumero());
        stmt.setString(2, this.getData());
        stmt.setString(3, this.getHora());
        stmt.setString(4, this.getOrigem());
        stmt.setString(5, this.getDestino());
        stmt.setString(6, this.getPiloto());
        stmt.setString(7, this.getCopiloto());
        stmt.setString(8, this.getObservacao());
        stmt.setInt(9, this.pista.getId());
        stmt.setInt(10, this.Aeronave.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    //Update
    public void update() throws SQLException {
        String sql = "UPDATE voo SET numero = ?, data = ?, hora = ?, origem = ?, destino = ?, piloto = ?, copiloto = ?, observacao = ?, idPista = ?, idAeronave = ? WHERE id_voo = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setString(1, this.numero.getNumero());
        stmt.setString(2, this.getData());
        stmt.setString(3, this.getHora());
        stmt.setString(4, this.getOrigem());
        stmt.setString(5, this.getDestino());
        stmt.setString(6, this.getPiloto());
        stmt.setString(7, this.getCopiloto());
        stmt.setString(8, this.getObservacao());
        stmt.setInt(9, this.pista.getId());
        stmt.setInt(10, this.Aeronave.getId());
        stmt.setInt(11, this.getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    //Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM voo WHERE id_voo = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, getId());
        stmt.execute();
        DAO.deleteConnect();
    }

    //GetById
    public static Voo getById(int idvoo) throws SQLException {
        String sql = "SELECT * FROM voo WHERE id_voo = ?";
        PreparedStatement stmt = DAO.getConnect().prepareStatement(sql);
        stmt.setInt(1, getId());
        ResultSet rs = stmt.executeQuery();
        Voo voo = null;
        while (rs.next()) {
            voo = new Voo();
            voo.setId(rs.getInt("id_voo"));
        }
        DAO.deleteConnect();
        return voo;
    }

    //GetAll
    public static List<Voo> getAll() throws SQLException {
        String sql = "SELECT * FROM voo";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Voo> voos = new ArrayList<>();
        while (rs.next()) {
            Voo voo = new Voo();
            voo.setId(rs.getInt("id_voo"));
            voo.setNumero(new Identificacao<String>(rs.getString("numero")));
            voo.setData(rs.getString("data"));
            voo.setHora(rs.getString("hora"));
            voo.setOrigem(rs.getString("origem"));
            voo.setDestino(rs.getString("destino"));
            voo.setPiloto(rs.getString("piloto"));
            voo.setCopiloto(rs.getString("copiloto"));
            voo.setObservacao(rs.getString("observacao"));
            voo.setIdPista(rs.getInt("id_pista"));
            voo.setIdAeronave(rs.getInt("id_aeronave"));
            voos.add(voo);
        }
        DAO.deleteConnect();
        return voos;
    }
}
