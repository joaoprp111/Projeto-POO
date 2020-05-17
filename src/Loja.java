import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Loja extends Entidade{
    private boolean infoFilas;
    private Collection<Encomenda> encs;

    /*
     * Construtor por omissão
     */
    public Loja(){
        super();
        this.infoFilas = false;
        this.encs = new ArrayList<>();
    }

    /*
     * Construtor parametrizado
     */
    public Loja(String codigo, String nome, GPS gps, boolean infoFilas) {
        super(codigo, nome, gps);
        this.infoFilas = infoFilas;
        this.encs = new ArrayList<>();
    }

    public Loja(String codigo, String nome, GPS gps) {
        super(codigo, nome, gps);
        this.infoFilas = false;
        this.encs = new ArrayList<>();
    }

    /*
     * Construtor de cópia
     */
    public Loja(Loja l){
        super(l);
        this.infoFilas = l.isInfoFilas();
        setEncs(l.getEncs());
    }

    /*
     * Getters
     */

    public boolean isInfoFilas() {
        return infoFilas;
    }

    public void setInfoFilas(boolean infoFilas) {
        this.infoFilas = infoFilas;
    }

    public Collection<Encomenda> getEncs() {
        List<Encomenda> res = new ArrayList<>();
        for(Encomenda enc: this.encs){
            res.add(enc.clone());
        }
        return res;
    }

    /*
     * Setters
     */

    public void setEncs(Collection<Encomenda> encs) {
        this.encs = new ArrayList<>();
        for(Encomenda enc : encs){
            this.encs.add(enc.clone());
        }
    }

    /**
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("infoFilas=").append(infoFilas);
        sb.append(", encs=").append(encs);
        sb.append('}');
        return sb.toString();
    }

    /**
     *              Verifica se dois objetos são iguais
     * @param o     Objeto com o qual vamos comparar
     * @return      Booleano a informar se são ou não iguais
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        Loja loja = (Loja) o;
        return this.infoFilas == loja.isInfoFilas() &&
                this.encs.equals(loja.getEncs());
    }

    /**
     *                      Clona uma loja
     * @return              Loja clone
     */
    public Loja clone(){
        return new Loja(this);
    }
}
