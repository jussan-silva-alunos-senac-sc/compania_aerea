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
    public void update(Hangar hangar) {
        this.id = hangar.getId();
        this.local = hangar.getLocal();
        this.idAviao = hangar.getIdAviao();
    }

    // Delete
    public void delete() {
        this.id = 0;
        this.local = null;
        this.idAviao = 0;
    }

    // getById
    public void getById(int id) {
        this.id = id;
        this.local = "Hangar 1";
        this.idAviao = 1;
    }

    // GetALL
    public List<Hangar> getAll() {
        List<Hangar> hangares = new ArrayList<Hangar>();
        Hangar hangar = new Hangar();
        hangar.setId(1);
        hangar.setLocal("Hangar 1");
        hangar.setIdAviao(1);
        hangares.add(hangar);
        hangar = new Hangar();
        hangar.setId(2);
        hangar.setLocal("Hangar 2");
        hangar.setIdAviao(2);
        hangares.add(hangar);
        hangar = new Hangar();
        hangar.setId(3);
        hangar.setLocal("Hangar 3");
        hangar.setIdAviao(3);
        hangares.add(hangar);
        return hangares;
    }
    
}
