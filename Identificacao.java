import java.util.ArrayList;

//Módulo destinado para o Prefixo de identificação das aeronaves, das pistas, dos hangares e dos voos
//Desenvolvido por Jussan
//------------------------------------------------



public class Identificacao <T> {
    private T letras;
 

    public Identificacao() {
    }

    public Identificacao(T letras) {
        this.letras = letras;
    }

    private void setPrefixo (T letras) {
        this.letras = letras;
    }

    public Identificacao<String> getPrefixo () {
        return new Identificacao<String>();
    }

    private void setNumero (T letras) {
        this.letras = letras;
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
        return (String) letras;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Identificacao)) {
            return false;
        }
        final Identificacao other = (Identificacao) obj;
        if (this.letras != other.letras) {
            return false;
        }
        return true;
    }

}
