import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class Utilizador extends Entidade{
    Collection<Encomenda> encsFeitas;
    Collection<Encomenda> encsEntregues;
    Collection<Proposta> propostas;

    /*
     * Construtor por omissão
     */
    public Utilizador(){
        super();
        encsEntregues = new ArrayList<>();
        encsFeitas = new ArrayList<>();
        propostas = new ArrayList<>();
    }

    /*
     * Construtor parametrizado
     */
    public Utilizador(String id, String nome, GPS gps) {
        super(id, nome, gps);
        encsEntregues = new ArrayList<>();
        encsFeitas = new ArrayList<>();
        propostas = new ArrayList<>();
    }

    /*
     * Construtor por cópia
     */
    public Utilizador(Utilizador user){
        super(user);
        setEncsFeitas(user.getEncsFeitas());
        setEncsEntregues(user.getEncsEntregues());
    }

    public Collection<Encomenda> getEncsFeitas(){
        return this.encsFeitas.stream()
                .map(Encomenda::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public Collection<Encomenda> getEncsEntregues(){
        return this.encsEntregues.stream()
                .map(Encomenda::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public Collection<Proposta> getPropostas() {
        return this.propostas.stream()
                .map(Proposta::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public void setEncFeita(Encomenda e){
        this.encsFeitas.add(e.clone());
    }

    public void setEncsFeitas(Collection<Encomenda> c){
        this.encsFeitas = new ArrayList<>();
        for(Encomenda e: c) this.encsFeitas.add(e.clone());
    }

    public void setEncsEntregues(Collection<Encomenda> c){
        this.encsEntregues = new ArrayList<>();
        for(Encomenda e: c) this.encsEntregues.add(e.clone());
    }

    public void setPropostas(Collection<Proposta> propostas) {
        this.propostas = new ArrayList<>();
        for (Proposta p: propostas) this.propostas.add(p.clone());
    }

    public void setProposta (Proposta p){
        this.propostas.add(p.clone());
    }

    /**
     *              Verifica se dois objetos são iguais
     * @param o     Objeto com o qual vamos comparar
     * @return      Booleano a informar se são ou não iguais
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Utilizador that = (Utilizador) o;
        return Objects.equals(encsFeitas, that.getEncsFeitas()) &&
                Objects.equals(encsEntregues, that.getEncsEntregues());
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilizador{");
        sb.append("encsFeitas=").append(encsFeitas);
        sb.append(", encsEntregues=").append(encsEntregues);
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
