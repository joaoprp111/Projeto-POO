import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Loja extends Entidade{
    private boolean infoFilas;
    private int tempoAtendimentoPorPessoa; // em segundos
    private int pessoasEmEspera;
    private Collection<Encomenda> encs;

    /*
     * Construtor por omissão
     */
    public Loja(){
        super();
        this.infoFilas = false;
        this.tempoAtendimentoPorPessoa = 0;
        this.pessoasEmEspera = 0;
        this.encs = new ArrayList<>();
    }

    /*
     * Construtor parametrizado
     */
    public Loja(String codigo, String nome, GPS gps, boolean infoFilas, int tempoAtendimentoPorPessoa, int pessoasEmEspera) {
        super(codigo, nome, gps);
        this.infoFilas = infoFilas;
        if(infoFilas){
            this.tempoAtendimentoPorPessoa = tempoAtendimentoPorPessoa;
            this.pessoasEmEspera = pessoasEmEspera;
        } else {
            this.tempoAtendimentoPorPessoa = 0;
            this.pessoasEmEspera = 0;
        }
        this.encs = new ArrayList<>();
    }

    public Loja(String codigo, String nome, GPS gps) {
        super(codigo, nome, gps);
        this.infoFilas = false;
        this.tempoAtendimentoPorPessoa = 0;
        this.pessoasEmEspera = 0;
        this.encs = new ArrayList<>();
    }

    /*
     * Construtor de cópia
     */
    public Loja(Loja l){
        super(l);
        this.infoFilas = l.isInfoFilas();
        this.tempoAtendimentoPorPessoa = l.getTempoAtendimentoPorPessoa();
        this.pessoasEmEspera = l.getPessoasEmEspera();
        setEncs(l.getEncs());
    }

    /*
     * Getters
     */

    public boolean isInfoFilas() {
        return infoFilas;
    }

    public int getTempoAtendimentoPorPessoa(){
        return tempoAtendimentoPorPessoa;
    }

    public int getPessoasEmEspera(){
        return pessoasEmEspera;
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

    public void setInfoFilas(boolean infoFilas){
        this.infoFilas = infoFilas;
    }

    public void setTempoAtendimentoPorPessoa(int tempoAtendimentoPorPessoa){
        this.tempoAtendimentoPorPessoa = tempoAtendimentoPorPessoa;
    }

    public void setPessoasEmEspera(int pessoasEmEspera){
        this.pessoasEmEspera = pessoasEmEspera;
    }

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
    @Override
    public String toString() {
        return "Loja{" +
                "infoFilas=" + infoFilas +
                ", tempoAtendimentoPorPessoa=" + tempoAtendimentoPorPessoa +
                ", pessoasEmEspera=" + pessoasEmEspera +
                ", encs=" + encs +
                '}';
    }

    /**
     *              Verifica se dois objetos são iguais
     * @param o     Objeto com o qual vamos comparar
     * @return      Booleano a informar se são ou não iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Loja loja = (Loja) o;
        return isInfoFilas() == loja.isInfoFilas() &&
                getTempoAtendimentoPorPessoa() == loja.getTempoAtendimentoPorPessoa() &&
                getPessoasEmEspera() == loja.getPessoasEmEspera() &&
                Objects.equals(getEncs(), loja.getEncs());
    }

    /**
     *                      Clona uma loja
     * @return              Loja clone
     */
    public Loja clone(){
        return new Loja(this);
    }
}
