import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class TransportadoraVariasEncs extends Transportadora {
    int ocupacao;
    private Collection<Encomenda> encs;

    public TransportadoraVariasEncs(){
        super();
        this.ocupacao = 0;
        this.encs = new ArrayList<>();
    }

    public TransportadoraVariasEncs(String codigo, String nome, GPS gps, String nif, double raio, double preco) {
        super(codigo, nome, gps, nif, raio, preco);
        this.ocupacao = 0;
        this.encs = new ArrayList<>();
    }

    public TransportadoraVariasEncs(TransportadoraVariasEncs t) {
        super(t);
        this.ocupacao = t.getOcupacao();
        setEncs(t.getEncs());
    }

    public Collection<Encomenda> getEncs() {
        List<Encomenda> res = new ArrayList<>();
        for(Encomenda e : this.encs) res.add(e.clone());
        return res;
    }

    public int getOcupacao(){
        return this.ocupacao;
    }

    public void setEncs(Collection<Encomenda> enc) {
        this.encs = new ArrayList<>();
        for(Encomenda e : enc) this.encs.add(e.clone());
    }

    public void setOcupacao(int ocup){
        this.ocupacao = ocup;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransportadoraVariasEncs that = (TransportadoraVariasEncs) o;
        return Objects.equals(encs, that.getEncs());
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(encs);
        sb.append('}');
        return sb.toString();
    }

    public TransportadoraVariasEncs clone(){
        return new TransportadoraVariasEncs(this);
    }
}
