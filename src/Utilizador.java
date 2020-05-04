import java.util.Objects;

public class  Utilizador{
    private String id;
    private String nome;
    private double coordX;
    private double coordY;

    /*
     * Construtor por omissão
     */
    public Utilizador(){
        this.id = new String();
        this.nome = new String();
        this.coordX = 0.0;
        this.coordY = 0.0;
    }

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

    /*
     * Setters
     */

    /**
     *                      Atualiza a localização em x do utilizador
     * @param coordX         Coordenada em x
     */
    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    /**
     *                      Atualiza a localização em y do utilizador
     * @param coordY        Coordenada em y
     */
    public void setCoordY(double coordY) {
        this.coordY = coordY;
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
     *              Verifica se dois objetos são iguais
     * @param o     Objeto com o qual vamos comparar
     * @return      Booleano a informar se são ou não iguais
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return Double.compare(that.getCoordX(), this.coordX) == 0 &&
                Double.compare(that.getCoordY(), this.coordY) == 0 &&
                Objects.equals(this.id, that.getId()) &&
                Objects.equals(this.nome, that.getNome());
    }

    /**
     *                      Faz uma cópia do utilizador
     * @return              Utilizador clone
     */
    public Utilizador clone(){
        return new Utilizador(this);
    }
}
