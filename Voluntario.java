public class Voluntario{
    private String id;
    private String nome;
    private double coordX;
    private double coordY;
    private double raio;
    private boolean disponivel;
    private boolean quer_fazer_entrega;

    /*
     * Construtor parametrizado
     */
    public Voluntario(String id, String nome, double coordX, double coordY, double raio) {
        this.id = id;
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
        this.raio = raio;
        this.disponivel = 0; /* No ínicio assume-se que não está disponível, consoante o fluxo do programa podemos alterar este campo */
        this.quer_fazer_entrega = 0; /* Mesma decisão do campo anterior */
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
     * @brief               Devolve o identificador do voluntário
     * @return              Identificador
     */
    public String getId() {
        return id;
    }

    /**
     * @brief               Devolve o nome do voluntário
     * @return              Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief               Devolve a coordenada x do voluntário
     * @return              Coordenada x
     */
    public double getCoordX() {
        return coordX;
    }

    /**
     * @brief               Devolve a coordenada y do voluntário
     * @return              Coordenada y
     */
    public double getCoordY() {
        return coordY;
    }

    /**
     * @brief               Devolve o raio limite de ação do voluntário
     * @return              Raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     * @brief               Informa se o voluntário está ou não disponível
     * @return              true se estiver disponivel, false caso contrário
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * @brief               Informa se o voluntário quer fazer a entrega
     * @return              true se quiser, false caso contrário
     */
    public boolean Quer_fazer_entrega() {
        return quer_fazer_entrega;
    }

    /*
     * Setters
     */

    /**
     * @brief                   Atualiza o estado de disponibilidade do voluntário
     * @param disponivel        Novo estado
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * @brief                   Atualiza a decisão do voluntário, querer entregar ou não
     * @param disponivel        Novo estado
     */
    public void setQuer_fazer_entrega(boolean quer_fazer_entrega) {
        this.quer_fazer_entrega = quer_fazer_entrega;
    }

    /**
     * @brief               Transforma o conteúdo de um objeto numa String
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
     * @brief               Clona um voluntário
     * @return              Voluntário clone
     */
    public Voluntario clone(){
        return new Voluntario(this);
    }
}