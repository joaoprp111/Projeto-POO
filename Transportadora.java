public class Transportadora{
    private String codigo;
    private String nome;
    private double coordX;
    private double coordY;
    private String nif;
    private double raio;
    private double preco; /* Preço por km */

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
     * Getters
     */

    /**
     * @brief               Devolve o código da empresa
     * @return              Código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @brief               Devolve o nome da empresa
     * @return              Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief               Devolve a coordenada x
     * @return              Coordenada x
     */
    public double getCoordX() {
        return coordX;
    }

    /**
     * @brief               Devolve a coordenada y
     * @return              Coordenada y
     */
    public double getCoordY() {
        return coordY;
    }

    /**
     * @brief               Devolve o nif da empresa
     * @return              NIF
     */
    public String getNif() {
        return nif;
    }

    /**
     * @brief               Devolve o raio de transporte
     * @return              Raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     * @brief               Devolve o valor do preço por km
     * @return              Preço
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @brief               Transforma o conteúdo de um objeto numa String
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
}