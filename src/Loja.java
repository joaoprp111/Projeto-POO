import java.util.*;

public class Loja extends Entidade{
    private boolean infoFilas;
    private boolean temMedicamentos;
    private int tempoAtendimentoPorPessoa; // em segundos
    private int pessoasEmEspera;
    private Map<String,Encomenda> encs;

    /*
     * Construtor por omissão
     */
    public Loja(){
        super();
        this.infoFilas = false;
        this.tempoAtendimentoPorPessoa = 0;
        this.pessoasEmEspera = 0;
        this.temMedicamentos = false;
        this.encs = new HashMap<>();
    }

    /*
     * Construtor parametrizado
     */

    public Loja(String codigo, String nome, GPS gps, boolean infoFilas, boolean temMedicamentos) {
        super(codigo, nome, gps);
        this.infoFilas = infoFilas;
        this.tempoAtendimentoPorPessoa = 0;
        this.pessoasEmEspera = 0;
        this.encs = new HashMap<>();
        this.temMedicamentos = temMedicamentos;
    }

    public Loja(String codigo, String nome, GPS gps) {
        super(codigo, nome, gps);
        this.infoFilas = false;
        this.tempoAtendimentoPorPessoa = 0;
        this.pessoasEmEspera = 0;
        this.temMedicamentos = false;
        this.encs = new HashMap<>();
    }

    /*
     * Construtor de cópia
     */
    public Loja(Loja l){
        super(l);
        this.infoFilas = l.isInfoFilas();
        this.tempoAtendimentoPorPessoa = l.getTempoAtendimentoPorPessoa();
        this.pessoasEmEspera = l.getPessoasEmEspera();
        this.temMedicamentos = l.getTemMedicamentos();
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

    public Map<String,Encomenda> getEncs() {
        Map<String,Encomenda> res = new HashMap<>();
        for(Encomenda enc: this.encs.values()){
            res.put(enc.getCodEnc(),enc.clone());
        }
        return res;
    }

    public boolean getTemMedicamentos() {
        return temMedicamentos;
    }

    public void setTemMedicamentos(boolean temMedicamentos) {
        this.temMedicamentos = temMedicamentos;
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

    public void setEncs(Map<String,Encomenda> encs) {
        this.encs = new HashMap<>();
        for(Encomenda enc : encs.values()){
            this.encs.put(enc.getCodEnc(),enc.clone());
        }
    }

    public void setEnc(Encomenda e){
        this.encs.put(e.getCodEnc(),e.clone());
    }

    /**
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Loja{");
        sb.append(super.toString());
        sb.append("infoFilas=").append(infoFilas);
        sb.append(", temMedicamentos=").append(temMedicamentos);
        sb.append(", tempoAtendimentoPorPessoa=").append(tempoAtendimentoPorPessoa);
        sb.append(", pessoasEmEspera=").append(pessoasEmEspera);
        sb.append(", encs=").append(encs);
        sb.append('}');
        return sb.toString();
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
                getTemMedicamentos() == loja.getTemMedicamentos() &&
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
