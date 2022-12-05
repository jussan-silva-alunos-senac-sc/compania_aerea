import java.util.ArrayList;

//Módulo destinado para o Prefixo de identificação das aeronaves, das pistas, dos hangares e dos voos
//Desenvolvido por Jussan
//------------------------------------------------



public class Identificacao <T,S extends Number> {
    private T letras;
    private S numeros;

    public Identificacao() {
    }

    public Identificacao(T letras, S numeros) {
        this.letras = letras;
        this.numeros = numeros;
    }

    void setPrefixo (T letras, S numeros) {
        this.letras = letras;
        this.numeros = numeros;
    }

    public Identificacao<String, Integer> getPrefixo () {
        return new Identificacao<String, Integer>();
    }

    private void setNumero (T letras, S numeros) {
        this.letras = letras;
        this.numeros = numeros;
    }
    
    public String getNumero () {
        return toString();
    }
    
    public static void  lista(ArrayList<Identificacao> lista) {
        for (Identificacao identificacao : lista) {
            System.out.println(identificacao);
        }
    }

    @Override
    public String toString() {
        return letras + "-" + numeros;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Identificacao)) {
            return false;
        }
        final Identificacao other = (Identificacao) obj;
        if (this.letras != other.letras) {
            return false;
        }
        if (this.numeros != other.numeros) {
            return false;
        }
        return true;
    }

}
