//Módulo destinado para os Jatos

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

    // Update
    public void update(Jato jato) {
        this.cor = jato.cor;
        this.velocidade = jato.velocidade;
    }

    // Delete
    public void delete() {
        this.cor = null;
        this.velocidade = 0;
    }

    // getById
    public void getById(int id) {
        this.id = id;
        this.marca = "Boeing";
        this.modelo = "747";
        this.cor = "Branco";
        this.velocidade = 1000;
    }

    // GetALL
    public List<Jato> getAll() {
        List<Jato> jatos = new ArrayList<>();
        jatos.add(new Jato(1, "Boeing", "747", "Branco", 1000));
        jatos.add(new Jato(2, "Boeing", "747", "Branco", 1000));
        jatos.add(new Jato(3, "Boeing", "747", "Branco", 1000));
        jatos.add(new Jato(4, "Boeing", "747", "Branco", 1000));
        jatos.add(new Jato(5, "Boeing", "747", "Branco", 1000));
        return jatos;
    }
    
}
