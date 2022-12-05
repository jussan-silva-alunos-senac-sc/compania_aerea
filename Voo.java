//Módulo destinado para os Voos
//Desenvolvido por Jussan
//------------------------------------------------

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Voo extends DAO {
    private int id;
    private String numero;
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

    Voo(int id, String numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao, int idPista, int idAeronave) {
        this.id = id;
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

    Voo(String numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao, int idPista, int idAeronave) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
        return "Voo{" + "id=" + id + ", numero=" + numero + ", data=" + data + ", hora=" + hora + ", origem=" + origem + ", destino=" + destino + ", piloto=" + piloto + ", copiloto=" + copiloto + ", observacao=" + observacao + ", idPista=" + idPista + ", pista=" + pista + ", idAeronave=" + idAeronave + ", aviao=" + aviao + ", helicoptero=" + helicoptero + ", jato=" + jato + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Voo)) {
            return false;
        }
        final Voo other = (Voo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    //Insert
    public void insert() throws SQLException {
        String sql = "INSERT INTO voo (numero, data, hora, origem, destino, piloto, copiloto, observacao, idPista, idAeronave) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, numero);
        ps.setString(2, data);
        ps.setString(3, hora);
        ps.setString(4, origem);
        ps.setString(5, destino);
        ps.setString(6, piloto);
        ps.setString(7, copiloto);
        ps.setString(8, observacao);
        ps.setInt(9, idPista);
        ps.setInt(10, idAeronave);
        ps.executeUpdate();
        ps.close();
    }

    //Update
    public void update() throws SQLException {
        String sql = "UPDATE voo SET numero = ?, data = ?, hora = ?, origem = ?, destino = ?, piloto = ?, copiloto = ?, observacao = ?, idPista = ?, idAeronave = ? WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setString(1, numero);
        ps.setString(2, data);
        ps.setString(3, hora);
        ps.setString(4, origem);
        ps.setString(5, destino);
        ps.setString(6, piloto);
        ps.setString(7, copiloto);
        ps.setString(8, observacao);
        ps.setInt(9, idPista);
        ps.setInt(10, idAeronave);
        ps.setInt(11, id);
        ps.executeUpdate();
        ps.close();
    }

    //Delete
    public void delete() throws SQLException {
        String sql = "DELETE FROM voo WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    //GetById
    public void getById(int id) throws SQLException {
        String sql = "SELECT * FROM voo WHERE id = ?";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
            this.numero = rs.getString("numero");
            this.data = rs.getString("data");
            this.hora = rs.getString("hora");
            this.origem = rs.getString("origem");
            this.destino = rs.getString("destino");
            this.piloto = rs.getString("piloto");
            this.copiloto = rs.getString("copiloto");
            this.observacao = rs.getString("observacao");
            this.idPista = rs.getInt("idPista");
            this.idAeronave = rs.getInt("idAeronave");
        }
        rs.close();
        ps.close();
    }

    //GetAll
    public static List<Voo> getAll() throws SQLException {
        List<Voo> lista = new ArrayList<Voo>();
        String sql = "SELECT * FROM voo";
        PreparedStatement ps = DAO.getConnect().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Voo voo = new Voo();
            voo.setId(rs.getInt("id"));
            voo.setNumero(rs.getString("numero"));
            voo.setData(rs.getString("data"));
            voo.setHora(rs.getString("hora"));
            voo.setOrigem(rs.getString("origem"));
            voo.setDestino(rs.getString("destino"));
            voo.setPiloto(rs.getString("piloto"));
            voo.setCopiloto(rs.getString("copiloto"));
            voo.setObservacao(rs.getString("observacao"));
            voo.setIdPista(rs.getInt("idPista"));
            voo.setIdAeronave(rs.getInt("idAeronave"));
            lista.add(voo);
        }
        rs.close();
        ps.close();
        return lista;
    }
}
