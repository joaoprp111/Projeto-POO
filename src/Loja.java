public class Loja{
    private String codigo;
    private String nome;
    private double coordX;
    private double coordY;
    private int numEncomendasPorEntregar;
    private boolean existeEncomendaParaEntrega;

    /*
     * Construtor por omissão
     */
    public Loja(){
        this.codigo = new String();
        this.nome = new String();
        this.coordX = this.coordY = 0.0;
        this.numEncomendasPorEntregar = 0;
        this.existeEncomendaParaEntrega = false;
    }

    /*
     * Construtor parametrizado
     */
    public Loja(String codigo, String nome, double coordX, double coordY) {
        this.codigo = codigo;
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
        this.numEncomendasPorEntregar = 0; /* A primeira vez que se cria um objeto do tipo loja, não há encomendas por entregar */
        this.existeEncomendaParaEntrega = false; /* Como o número de encomendas a entregar é 0, este campo tem de ser falso */
    }

    /*
     * Construtor de cópia
     */
    public Loja(Loja l){
        this.codigo = l.getCodigo();
        this.nome = l.getNome();
        this.coordX = l.getCoordX();
        this.coordY = l.getCoordY();
        this.numEncomendasPorEntregar = l.getNumEncomendasPorEntregar();
        this.existeEncomendaParaEntrega = l.ExisteEncomendaParaEntrega();
    }

    /*
     * Getters
     */

    /**
     *                      Devolve o código da loja
     * @return              Código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *                      Devolve o nome da loja
     * @return              Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *                      Devolve a coordenada X da loja
     * @return              Coordenada X
     */
    public double getCoordX() {
        return coordX;
    }

    /**
     *                      Devolve a coordenada Y da loja
     * @return              Coordenada Y
     */
    public double getCoordY() {
        return coordY;
    }

    /**
     *                      Devolve o número de encomendas por entregar
     * @return              Número de encomendas por entregar
     */
    public int getNumEncomendasPorEntregar() {
        return numEncomendasPorEntregar;
    }

    /**
     *                      Verifica se a loja já tem pelo menos uma encomenda pronta a ser entregue
     * @return              true se sim, false se não
     */
    public boolean ExisteEncomendaParaEntrega() {
        return existeEncomendaParaEntrega;
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
     *                                          Atualiza o número de encomendas prontas para entregar
     * @param numEncomendasPorEntregar          Novo valor
     */
    public void setNumEncomendasPorEntregar(int numEncomendasPorEntregar) {
        this.numEncomendasPorEntregar = numEncomendasPorEntregar;
    }

    /**
     *                                          Atualiza estado da loja em relação às encomendas, para informar se podem ser transportadas ou não
     * @param existeEncomendaParaEntrega          Novo estado (em booleano)
     */
    public void setExisteEncomendaParaEntrega(boolean existeEncomendaParaEntrega) {
        this.existeEncomendaParaEntrega = existeEncomendaParaEntrega;
    }

    /**
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Loja{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", coordX=").append(coordX);
        sb.append(", coordY=").append(coordY);
        sb.append(", numEncomendasPorEntregar=").append(numEncomendasPorEntregar);
        sb.append(", existeEncomendaParaEntrega=").append(existeEncomendaParaEntrega);
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
        Loja loja = (Loja) o;
        return Double.compare(loja.getCoordX(), this.coordX) == 0 &&
                Double.compare(loja.getCoordY(), this.coordY) == 0 &&
                this.numEncomendasPorEntregar == loja.getNumEncomendasPorEntregar() &&
                this.existeEncomendaParaEntrega == loja.ExisteEncomendaParaEntrega() &&
                this.codigo.equals(loja.getCodigo()) &&
                this.nome.equals(loja.getNome());
    }

    /**
     *                      Clona uma loja
     * @return              Loja clone
     */
    public Loja clone(){
        return new Loja(this);
    }
}
