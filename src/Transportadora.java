import java.util.Objects;

public abstract class Transportadora extends Entidade{
    private String nif;
    private double raio;
    private double preco; /* Preço por km */
    /*
     * Construtor por omissao
     */
    public Transportadora(){
        super();
        this.nif = "";
        this.preco = 0.0;
    }

    /*
     * Construtor parametrizado
     */
    public Transportadora(String codigo, String nome, GPS gps, String nif, double raio, double preco) {
        super(codigo, nome, gps);
        this.nif = nif;
        this.raio = raio;
        this.preco = preco;
    }

    /*
     * Construtor por cópia
     */
    public Transportadora(Transportadora t) {
        super(t);
        this.nif = t.getNif();
        this.raio = t.getRaio();
        this.preco = t.getPreco();
    }

    /*
     * Getters
     */

    /**
     *                      Devolve o nif da empresa
     * @return              NIF
     */
    public String getNif() {
        return nif;
    }

    /**
     *                      Devolve o raio de transporte
     * @return              Raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     *                      Devolve o valor do preço por km
     * @return              Preço
     */
    public double getPreco() {
        return preco;
    }

    /*
     * Setters
     */

    /**
     *                      Atualiza o preço por km
     * @param preco         Preço novo
     */
    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    /**
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", nif='").append(nif).append('\'');
        sb.append(", raio=").append(raio);
        sb.append(", preco=").append(preco);
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
        Transportadora that = (Transportadora) o;
        return Double.compare(that.getRaio(), this.raio) == 0 &&
                Double.compare(that.getPreco(), this.preco) == 0 &&
                Objects.equals(this.nif, that.getNif());
    }

    public double calculaPrecoTransporte(double peso, double distLoja, double distUser){
        double distTotal = distLoja + distUser;
        return peso * preco * distTotal;
    }

    public abstract Transportadora clone();
}
