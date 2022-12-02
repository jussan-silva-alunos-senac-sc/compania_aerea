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

    // Update
    public void update(Aviao aviao) {
        this.prefixo = aviao.prefixo;
        this.capacidade = aviao.capacidade;
        this.idCompanhia = aviao.idCompanhia;
    }

    // Delete
    public void delete() {
        this.prefixo = null;
        this.capacidade = 0;
        this.idCompanhia = 0;
    }

    // getById
    public void getById(int id) {
        this.id = id;
        this.marca = "Boeing";
        this.modelo = "747";
        this.prefixo = "PRFX";
        this.capacidade = 10;
        this.idCompanhia = 1;
    }

    // GetALL
    public List<Aviao> getAll() {
        List<Aviao> avioes = new ArrayList<>();
        avioes.add(new Aviao(1, "Boeing", "747", "PRFX", 10, 1));
        avioes.add(new Aviao(2, "Boeing", "747", "PRFX", 10, 1));
        avioes.add(new Aviao(3, "Boeing", "747", "PRFX", 10, 1));
        avioes.add(new Aviao(4, "Boeing", "747", "PRFX", 10, 1));
        avioes.add(new Aviao(5, "Boeing", "747", "PRFX", 10, 1));
        return avioes;
    }
}
