import java.lang.StringBuilder;
import java.util.Objects;

public class Voluntario extends MeioTransporte{

    /*
     * Construtor por omissão
     */
    public Voluntario(){
        super();
    }

    /*
     * Construtor parametrizado
     */
    public Voluntario(String codigo, String nome, GPS gps, double raio, boolean certificado) {
        super(codigo, nome, gps, raio, certificado);
    }

    /*
     * Construtor de cópia
     */
    public Voluntario(MeioTransporte t) {
        super(t);
    }


    /*
     *                      Transforma o conteúdo de um objeto numa String
     * @return              String com a informação do objeto
     *
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", raio=").append(raio);
        sb.append(", disponivel=").append(disponivel);
        sb.append(", quer_fazer_entrega=").append(quer_fazer_entrega);
        sb.append('}');
        return sb.toString();
    }

    **
     *              Verifica se dois objetos são iguais
     * @param o     Objeto com o qual vamos comparar
     * @return      Booleano a informar se são ou não iguais
     *
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        Voluntario that = (Voluntario) o;
        return Double.compare(that.getRaio(), this.getRaio()) == 0 &&
                this.disponivel == that.isDisponivel() &&
                this.quer_fazer_entrega == that.Quer_fazer_entrega();
    }

    **
     *                      Clona um voluntário
     * @return              Voluntário clone
     */
    public Voluntario clone(){
        return new Voluntario(this);
    }
}
