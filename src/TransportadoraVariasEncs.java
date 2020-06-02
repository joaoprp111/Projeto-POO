import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class TransportadoraVariasEncs extends MeioTransporte {
    private String nif;
    private double preco; // preco por km
    private int ocupacao;
    private Collection<Encomenda> encs;

    public TransportadoraVariasEncs(){
        super();
        this.nif = "";
        this.preco = 0.0;
        this.ocupacao = 0;
        this.encs = new ArrayList<>();
    }

    public TransportadoraVariasEncs(String codigo, String nome, GPS gps, double raio, boolean certificado, String nif, double preco) {
        super(codigo, nome, gps, raio, certificado);
        this.nif = nif;
        this.preco = preco;
        this.ocupacao = 0;
        this.encs = new ArrayList<>();
    }

    public TransportadoraVariasEncs(TransportadoraVariasEncs t) {
        super(t);
        this.nif = t.getNif();
        this.preco = t.getPreco();
        this.ocupacao = t.getOcupacao();
        setEncs(t.getEncs());
    }

    public String getNif() {
        return nif;
    }

    public double getPreco() {
        return preco;
    }

    public Collection<Encomenda> getEncs() {
        List<Encomenda> res = new ArrayList<>();
        for(Encomenda e : this.encs) res.add(e.clone());
        return res;
    }

    public int getOcupacao(){
        return this.ocupacao;
    }


    public void setNif(String nif){
        this.nif = nif;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setEncs(Collection<Encomenda> enc) {
        this.encs = new ArrayList<>();
        for(Encomenda e : enc) this.encs.add(e.clone());
    }

    public void setOcupacao(int ocup){
        this.ocupacao = ocup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransportadoraVariasEncs that = (TransportadoraVariasEncs) o;
        return Double.compare(that.getPreco(), getPreco()) == 0 &&
                getOcupacao() == that.getOcupacao() &&
                getNif().equals(that.getNif()) &&
                Objects.equals(getEncs(), that.getEncs());
    }

    @Override
    public String toString() {
        return "TransportadoraVariasEncs{" +
                "nif='" + nif + '\'' +
                ", preco=" + preco +
                ", ocupacao=" + ocupacao +
                ", encs=" + encs +
                '}';
    }

    public TransportadoraVariasEncs clone(){
        return new TransportadoraVariasEncs(this);
    }
}
