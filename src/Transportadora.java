import java.util.Objects;

public class Transportadora{
    private String codigo;
    private String nome;
    private double coordX;
    private double coordY;
    private String nif;
    private double raio;
    private double preco; /* Preço por km */

    /*
     * Construtor por omissao
     */
    public Transportadora(){
        this.codigo = new String();
        this.nome = new String();
        this.coordX = this.coordY = this.raio = this.preco = 0.0;
        this.nif = new String();
    }

    /*
     * Construtor parametrizado
     */
    public Transportadora(String codigo, String nome, double coordX, double coordY, String nif, double raio, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
        this.nif = nif;
        this.raio = raio;
        this.preco = preco;
    }

    /*
     * Construtor por cópia
     */
    public Transportadora(Transportadora t) {
        this.codigo = t.getCodigo();
        this.nome = t.getNome();
        this.coordX = t.getCoordX();
        this.coordY = t.getCoordY();
        this.nif = t.getNif();
        this.raio = t.getRaio();
        this.preco = t.getPreco();
    }

    /*
     * Getters
     */

    /**
     *                      Devolve o código da empresa
     * @return              Código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *                      Devolve o nome da empresa
     * @return              Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *                      Devolve a coordenada x
     * @return              Coordenada x
     */
    public double getCoordX() {
        return coordX;
    }

    /**
     *                      Devolve a coordenada y
     * @return              Coordenada y
     */
    public double getCoordY() {
        return coordY;
    }

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
     *                       Atualiza a localização em x
     * @param coordX         Coordenada em x
     */
    public void setCoordX(double coordX){
        this.coordX = coordX;
    }

    /**
     *                       Atualiza a localização em y
     * @param coordY         Coordenada em Y
     */
    public void setCoordY(double coordY){
        this.coordY = coordY;
    }

    /**
     *                      Atualiza o preço por km
     * @param preco         Preço novo
     */
    public void setPreco(double preco){
        this.preco = preco;
    }

    /**
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Transportadora{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", coordX=").append(coordX);
        sb.append(", coordY=").append(coordY);
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
        Transportadora that = (Transportadora) o;
        return Double.compare(that.getCoordX(), this.coordX) == 0 &&
                Double.compare(that.getCoordY(), this.coordY) == 0 &&
                Double.compare(that.getRaio(), this.raio) == 0 &&
                Double.compare(that.getPreco(), this.preco) == 0 &&
                Objects.equals(this.codigo, that.getCodigo()) &&
                Objects.equals(this.nome, that.getNome()) &&
                Objects.equals(this.nif, that.getNif());
    }

    /**
     *                      Clona uma empresa transportadora
     * @return              Empresa clone
     */
    public Transportadora clone(){
        return new Transportadora(this);
    }
}
