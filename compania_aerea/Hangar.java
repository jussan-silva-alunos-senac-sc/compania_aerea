//Módulo destinado para os hangares

public class Hangar extends Aviao {
    private int id;
    private String local;
    private int idAviao;
    private Aviao aviao;

    Hangar() {
    }

    Hangar(int id, String local, int idAviao) {
        this.id = id;
        this.local = local;
        this.idAviao = idAviao;
    }

    Hangar(String local, int idAviao) {
        this.local = local;
        this.idAviao = idAviao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    @Override
    public String toString() {
        return "Hangar{" + "id=" + id + ", local=" + local + ", idAviao=" + idAviao + ", aviao=" + aviao + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Hangar)) {
            return false;
        }
        final Hangar other = (Hangar) obj;
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
