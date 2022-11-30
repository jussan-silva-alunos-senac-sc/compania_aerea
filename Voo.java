public class Voo {
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
    private int idAviao;
    private Aviao aviao;
    private int idHelicoptero;
    private Helicoptero helicoptero;
    private int idJato;
    private Jato jato;

    Voo() {
    }

    Voo(int id, String numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao, int idPista, int idAviao, int idHelicoptero, int idJato) {
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
        this.idAviao = idAviao;
        this.idHelicoptero = idHelicoptero;
        this.idJato = idJato;
    }

    Voo(String numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observacao, int idPista, int idAviao, int idHelicoptero, int idJato) {
        this.numero = numero;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.observacao = observacao;
        this.idPista = idPista;
        this.idAviao = idAviao;
        this.idHelicoptero = idHelicoptero;
        this.idJato = idJato;
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

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public int getIdHelicoptero() {
        return idHelicoptero;
    }

    public void setIdHelicoptero(int idHelicoptero) {
        this.idHelicoptero = idHelicoptero;
    }

    public Helicoptero getHelicoptero() {
        return helicoptero;
    }

    public void setHelicoptero(Helicoptero helicoptero) {
        this.helicoptero = helicoptero;
    }

    public int getIdJato() {
        return idJato;
    }

    public void setIdJato(int idJato) {
        this.idJato = idJato;
    }

    public Jato getJato() {
        return jato;
    }

    public void setJato(Jato jato) {
        this.jato = jato;
    }

    @Override
    public String toString() {
        return "Voo{" + "id=" + id + ", numero=" + numero + ", data=" + data + ", hora=" + hora + ", origem=" + origem + ", destino=" + destino + ", piloto=" + piloto + ", copiloto=" + copiloto + ", observacao=" + observacao + ", idPista=" + idPista + ", pista=" + pista + ", idAviao=" + idAviao + ", aviao=" + aviao + ", idHelicoptero=" + idHelicoptero + ", helicoptero=" + helicoptero + ", idJato=" + idJato + ", jato=" + jato + '}';
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

    //Update
    public void update(Voo voo) {
        this.numero = voo.numero;
        this.data = voo.data;
        this.hora = voo.hora;
        this.origem = voo.origem;
        this.destino = voo.destino;
        this.piloto = voo.piloto;
        this.copiloto = voo.copiloto;
        this.observacao = voo.observacao;
        this.idPista = voo.idPista;
        this.idAviao = voo.idAviao;
        this.idHelicoptero = voo.idHelicoptero;
        this.idJato = voo.idJato;
    }

    //Delete
    public void delete() {
        this.numero = null;
        this.data = null;
        this.hora = null;
        this.origem = null;
        this.destino = null;
        this.piloto = null;
        this.copiloto = null;
        this.observacao = null;
        this.idPista = 0;
        this.idAviao = 0;
        this.idHelicoptero = 0;
        this.idJato = 0;
    }

    //GetById
    public static Voo getById(int id) {
        Voo voo = null;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM voo WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                voo = new Voo();
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
                voo.setIdAviao(rs.getInt("idAviao"));
                voo.setIdHelicoptero(rs.getInt("idHelicoptero"));
                voo.setIdJato(rs.getInt("idJato"));
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        } catch (SQLException ex) {
            Logger.getLogger(Voo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voo;
    }

    //GetAll
    public static Voo GetAll() {
        Voo voo = null;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM voo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                voo = new Voo();
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
                voo.setIdAviao(rs.getInt("idAviao"));
                voo.setIdHelicoptero(rs.getInt("idHelicoptero"));
                voo.setIdJato(rs.getInt("idJato"));
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        } catch (SQLException ex) {
            Logger.getLogger(Voo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voo;
    }
}
