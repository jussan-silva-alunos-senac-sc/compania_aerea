//Módulo destinado para as companhias aéreas

public class Companhia {
    private int id;
    private String nome;
    private String cnpj;

    Companhia() {
    }

    Companhia(int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    Companhia(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Companhia{" + "id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Companhia)) {
            return false;
        }
        final Companhia other = (Companhia) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    // Update

    // Delete

    // getById

    // GetALL
}
