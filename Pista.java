public class Pista {
    private int id;
    private String numero;

    Pista() {
    }

    Pista(int id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    Pista(String numero) {
        this.numero = numero;
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

    @Override
    public String toString() {
        return "Pista{" + "id=" + id + ", numero=" + numero + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Pista)) {
            return false;
        }
        final Pista other = (Pista) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    // Update
    public void update(Pista pista) {
        this.numero = pista.numero;
    }

    // Delete
    public void delete() {
        this.id = 0;
        this.numero = null;
    }

    // getById
    public void getById(int id) {
        this.id = id;
        this.numero = "numero";
    }

    // GetALL
    public List<Pista> getAll() {
        List<Pista> pistas = new ArrayList<>();
        pistas.add(new Pista(1, "numero"));
        pistas.add(new Pista(2, "numero"));
        pistas.add(new Pista(3, "numero"));
        pistas.add(new Pista(4, "numero"));
        pistas.add(new Pista(5, "numero"));
        return pistas;
    }
    
}
