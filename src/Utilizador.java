import java.io.Serializable;

public class Utilizador extends Entidade implements Serializable {
    public Utilizador() {
    }

    public Utilizador(String codigo, String nome, GPS gps) {
        super(codigo, nome, gps);
    }

    public Utilizador(Entidade e) {
        super(e);
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }


}
