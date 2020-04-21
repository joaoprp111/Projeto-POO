package com.jetbrains;

public class Loja{
    private String codigo;
    private String nome;
    private double coordX;
    private double coordY;
    private int numEncomendasPorEntregar;
    private boolean existeEncomendaParaEntrega;

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
     * Getters
     */

    /**
     * @brief               Devolve o código da loja
     * @return              Código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @brief               Devolve o nome da loja
     * @return              Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief               Devolve a coordenada X da loja
     * @return              Coordenada X
     */
    public double getCoordX() {
        return coordX;
    }

    /**
     * @brief               Devolve a coordenada Y da loja
     * @return              Coordenada Y
     */
    public double getCoordY() {
        return coordY;
    }

    /**
     * @brief               Devolve o número de encomendas por entregar
     * @return              Número de encomendas por entregar
     */
    public int getNumEncomendasPorEntregar() {
        return numEncomendasPorEntregar;
    }

    /**
     * @brief               Verifica se a loja já tem pelo menos uma encomenda pronta a ser entregue
     * @return              true se sim, false se não
     */
    public boolean ExisteEncomendaParaEntrega() {
        return existeEncomendaParaEntrega;
    }

    /*
     * Setters
     */

    /**
     * @brief                                   Atualiza o número de encomendas prontas para entregar
     * @param numEncomendasPorEntregar          Novo valor
     */
    public void setNumEncomendasPorEntregar(int numEncomendasPorEntregar) {
        this.numEncomendasPorEntregar = numEncomendasPorEntregar;
    }

    /**
     * @brief                                   Atualiza estado da loja em relação às encomendas, para informar se podem ser transportadas ou não
     * @param numEncomendasPorEntregar          Novo estado (em booleano)
     */
    public void setExisteEncomendaParaEntrega(boolean existeEncomendaParaEntrega) {
        this.existeEncomendaParaEntrega = existeEncomendaParaEntrega;
    }

    /**
     * @brief               Transforma o conteúdo de um objeto numa String
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
}
