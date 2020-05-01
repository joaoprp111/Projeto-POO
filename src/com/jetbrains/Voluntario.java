package com.jetbrains;
import java.lang.StringBuilder;
import java.util.Objects;

public class Voluntario{
    private String id;
    private String nome;
    private double coordX;
    private double coordY;
    private double raio;
    private boolean disponivel;
    private boolean quer_fazer_entrega;

    /*
     * Construtor por omissão
     */
    public Voluntario(){
        this.id = new String();
        this.nome = new String();
        this.coordX = this.coordY = this.raio = 0.0;
        this.disponivel = this.quer_fazer_entrega = false; /* por omissão */
    }

    /*
     * Construtor parametrizado
     */
    public Voluntario(String id, String nome, double coordX, double coordY, double raio) {
        this.id = id;
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
        this.raio = raio;
        this.disponivel = false; /* No ínicio assume-se que não está disponível, consoante o fluxo do programa podemos alterar este campo */
        this.quer_fazer_entrega = false; /* Mesma decisão do campo anterior */
    }

    /*
     * Construtor de cópia
     */
    public Voluntario(Voluntario v){
        this.id = v.getId();
        this.nome = v.getNome();
        this.coordX = v.getCoordX();
        this.coordY = v.getCoordY();
        this.raio = v.getRaio();
        this.disponivel = v.isDisponivel();
        this.quer_fazer_entrega = v.Quer_fazer_entrega();
    }

    /*
     * Getters
     */

    /**
     *                      Devolve o identificador do voluntário
     * @return              Identificador
     */
    public String getId() {
        return id;
    }

    /**
     *                      Devolve o nome do voluntário
     * @return              Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *                      Devolve a coordenada x do voluntário
     * @return              Coordenada x
     */
    public double getCoordX() {
        return coordX;
    }

    /**
     *                      Devolve a coordenada y do voluntário
     * @return              Coordenada y
     */
    public double getCoordY() {
        return coordY;
    }

    /**
     *                      Devolve o raio limite de ação do voluntário
     * @return              Raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     *                      Informa se o voluntário está ou não disponível
     * @return              true se estiver disponivel, false caso contrário
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     *                      Informa se o voluntário quer fazer a entrega
     * @return              true se quiser, false caso contrário
     */
    public boolean Quer_fazer_entrega() {
        return quer_fazer_entrega;
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
     *                          Atualiza o estado de disponibilidade do voluntário
     * @param disponivel        Novo estado
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     *                                  Atualiza a decisão do voluntário, querer entregar ou não
     * @param quer_fazer_entrega        Novo estado
     */
    public void setQuer_fazer_entrega(boolean quer_fazer_entrega) {
        this.quer_fazer_entrega = quer_fazer_entrega;
    }

    /**
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Voluntario{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", coordX=").append(coordX);
        sb.append(", coordY=").append(coordY);
        sb.append(", raio=").append(raio);
        sb.append(", disponivel=").append(disponivel);
        sb.append(", quer_fazer_entrega=").append(quer_fazer_entrega);
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
        Voluntario that = (Voluntario) o;
        return Double.compare(that.getCoordX(), this.coordX) == 0 &&
                Double.compare(that.getCoordY(), this.coordY) == 0 &&
                Double.compare(that.getRaio(), this.raio) == 0 &&
                this.disponivel == that.isDisponivel() &&
                this.quer_fazer_entrega == that.Quer_fazer_entrega() &&
                Objects.equals(this.id, that.getId()) &&
                Objects.equals(this.nome, that.getNome());
    }

    /**
     *                      Clona um voluntário
     * @return              Voluntário clone
     */
    public Voluntario clone(){
        return new Voluntario(this);
    }
}
