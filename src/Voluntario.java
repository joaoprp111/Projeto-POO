import java.lang.StringBuilder;
import java.util.Objects;

public class Voluntario extends Entidade{
    private double raio;
    private boolean disponivel;
    private boolean quer_fazer_entrega;
    private boolean aceitoMeds;

    /*
     * Construtor por omissão
     */
    public Voluntario(){
        super();
        this.raio = 0.0;
        this.disponivel = this.quer_fazer_entrega = false; /* por omissão */
        this.aceitoMeds = false;
    }

    /*
     * Construtor parametrizado
     */
    public Voluntario(String id, String nome, GPS gps, double raio, boolean disponivel, boolean quer_fazer_entrega, boolean aceitoMeds) {
        super(id, nome, gps);
        this.raio = raio;
        this.disponivel = disponivel;
        this.quer_fazer_entrega = quer_fazer_entrega;
        this.aceitoMeds = aceitoMeds;
    }

    /*
     * Construtor de cópia
     */
    public Voluntario(Voluntario v){
        super(v);
        this.raio = v.getRaio();
        this.disponivel = v.isDisponivel();
        this.quer_fazer_entrega = v.Quer_fazer_entrega();
        this.aceitoMeds = v.aceitoTransporteMedicamentos();
    }

    /*
     * Getters
     */

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

    public boolean aceitoTransporteMedicamentos(){
        return this.aceitoMeds;
    }

    /*
     * Setters
     */

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

    public void aceitaMedicamentos(boolean state){
        this.aceitoMeds = state;
    }

    /**
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
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
        if(!super.equals(o)) return false;
        Voluntario that = (Voluntario) o;
        return Double.compare(that.getRaio(), this.getRaio()) == 0 &&
                this.disponivel == that.isDisponivel() &&
                this.quer_fazer_entrega == that.Quer_fazer_entrega();
    }

    /**
     *                      Clona um voluntário
     * @return              Voluntário clone
     */
    public Voluntario clone(){
        return new Voluntario(this);
    }
}
