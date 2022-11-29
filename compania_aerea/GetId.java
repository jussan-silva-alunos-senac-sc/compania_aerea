import java.util.ArrayList;

// Classe destinada a gerar um ID para cada objeto criado

public interface GetId {
    public int getId();

    public static int getNextId(ArrayList<? extends GetId> lista) {
        int id = 0;
        for (GetId object : lista) {
            if (object.getId() > id) {
                id = object.getId();
            }
        }
        return id + 1;
    }
}
