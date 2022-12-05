//Módulo destinado para as Aeronaves
//Desenvolvido por Jussan
//------------------------------------------------

public abstract class Aeronave extends Identificacao {
    private static int id;
    private String marca;
    private String modelo;

    Aeronave() {
    }

    Aeronave (int id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    Aeronave (String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Aeronave{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Aeronave)) {
            return false;
        }
        final Aeronave other = (Aeronave) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}