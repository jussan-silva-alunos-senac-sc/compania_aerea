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

    // Delete

    // getById

    // GetALL
}
