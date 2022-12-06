import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Módulo destinado para as Aeronaves
//Desenvolvido por Jussan
//------------------------------------------------

public class Aeronave extends Identificacao {
    private static int idAeronave;
    private String marca;
    private String modelo;

    Aeronave() {
    }

    Aeronave (int idAeronave, String marca, String modelo) {
        this.idAeronave = idAeronave;
        this.marca = marca;
        this.modelo = modelo;
    }

    Aeronave (String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public static int getId() {
        return idAeronave;
    }

    public void setId(int idAeronave) {
        this.idAeronave = idAeronave;
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
        return "Aeronave >> " + "id =" + idAeronave + ", marca = " + marca + ", modelo = " + modelo;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Aeronave)) {
            return false;
        }
        final Aeronave other = (Aeronave) obj;
        if (this.idAeronave != other.idAeronave) {
            return false;
        }
        return true;
    }


}


