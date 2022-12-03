//Módulo destinado para os Helicópteros

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

    // Update
    public void update(Helicoptero helicoptero) {
        this.cor = helicoptero.cor;
        this.capacidade = helicoptero.capacidade;
    }

    // Delete
    public void delete() {
        this.cor = null;
        this.capacidade = 0;
    }

    // getById
    public void getById(int id) {
        this.id = id;
        this.marca = "Boeing";
        this.modelo = "747";
        this.cor = "Branco";
        this.capacidade = 10;
    }

    // GetALL
    public List<Helicoptero> getAll() {
        List<Helicoptero> lista = new ArrayList<>();
        return lista;
    }
    
}
