package com.jetbrains;

public class  Utilizador{
    private String id;
    private String nome;
    private double coordX;
    private double coordY;

    /*
     * Construtor parametrizado
     */
    public Utilizador(String id, String nome, double coordX, double coordY) {
        this.id = id;
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    /*
     * Construtor por cópia
     */
    public Utilizador(Utilizador user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.coordX = user.getCoordX();
        this.coordY = user.getCoordY();
    }

    /*
     * Getters
     */

    /**
     *                      Devolve o identificador do utilizador
     * @return              Identificador
     */
    public String getId() {
        return this.id;
    }

    /**
     *                      Devolve o nome do utilizador
     * @return              Nome do utilizador
     */
    public String getNome() {
        return this.nome;
    }

    /**
     *                      Devolve a coordenada X do utilizador
     * @return              Coordenada X
     */
    public double getCoordX() {
        return this.coordX;
    }

    /**
     *                      Devolve a coordenada Y do utilizador
     * @return              Coordenada Y
     */
    public double getCoordY() {
        return this.coordY;
    }

    /**
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Utilizador{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", coordX=").append(coordX);
        sb.append(", coordY=").append(coordY);
        sb.append('}');
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
