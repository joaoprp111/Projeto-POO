import java.util.Objects;

public class Utilizador extends Entidade{

    /*
     * Construtor por omissão
     */
    public Utilizador(){
        super();
    }

    /*
     * Construtor parametrizado
     */
    public Utilizador(String id, String nome, GPS gps) {
        super(id, nome, gps);
    }

    /*
     * Construtor por cópia
     */
    public Utilizador(Utilizador user){
        super(user);
    }

    /**
     *              Verifica se dois objetos são iguais
     * @param o     Objeto com o qual vamos comparar
     * @return      Booleano a informar se são ou não iguais
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }

    /**
     *                      Faz uma cópia do utilizador
     * @return              Utilizador clone
     */
    public Utilizador clone(){
        return new Utilizador(this);
    }
}
