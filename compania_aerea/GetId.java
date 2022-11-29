import java.util.ArrayList;

// Classe destinada a gerar um ID para cada objeto criado

public class GetId {
    private int id = 0;

    public int getId();

    public static int getNextId(ArrayList<? extends GetId> lista) {
        for (GetId object : lista) {
            if (object.getId() > id) {
                id = object.getId();
            }
        }
        return id + 1;
    }
}
