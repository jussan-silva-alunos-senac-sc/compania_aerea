public class Identificacao {
    private String letras;
    private int numeros;

    void execute() {

    }

    public Identificacao() {
    }

    public Identificacao(String letras, int numeros) {
        this.letras = letras;
        this.numeros = numeros;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public int getNumeros() {
        return numeros;
    }

    public void setNumeros(int numeros) {
        this.numeros = numeros;
    }

    public void setNumerosLetras(String letras, int numeros) {
        this.letras = letras;
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        return "Identificacao{" + "letras=" + letras + ", numeros=" + numeros + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Identificacao)) {
            return false;
        }
        final Identificacao other = (Identificacao) obj;
        if (!obj.equals(this.letras, other.letras)) {
            return false;
        }
        if (this.numeros != other.numeros) {
            return false;
        }
        return true;
    }



}
