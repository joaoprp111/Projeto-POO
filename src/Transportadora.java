import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Transportadora extends MeioTransporte {
    private String nif;
    private double preco; // preco por km
    private int ocupacao;
    private Collection<Encomenda> encs;
    private boolean fazVariasEnc;
    private boolean disponivel;

    public Transportadora(){
        super();
        this.nif = "";
        this.preco = 0.0;
        this.ocupacao = 0;
        this.encs = new ArrayList<>();
        this.fazVariasEnc = false;
        this.disponivel = false;
    }

    public Transportadora(String codigo, String nome, GPS gps, double raio, boolean certificado, String nif, double preco, boolean fazVarEn,boolean disponivel) {
        super(codigo, nome, gps, raio, certificado);
        this.nif = nif;
        this.preco = preco;
        this.ocupacao = 0;
        this.encs = new ArrayList<>();
        this.fazVariasEnc = fazVarEn;
        this.disponivel = disponivel;
    }

    public Transportadora(Transportadora t) {
        super(t);
        this.nif = t.getNif();
        this.preco = t.getPreco();
        this.ocupacao = t.getOcupacao();
        setEncs(t.getEncs());
        this.fazVariasEnc = t.isFazVariasEnc();
        this.disponivel = t.isDisponivel();
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

    public boolean isFazVariasEnc(){ return this.fazVariasEnc; }

    public boolean isDisponivel(){ return this.disponivel; }

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

    public void setFazVariasEnc(boolean fazVariasEnc) { this.fazVariasEnc = fazVariasEnc; }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Transportadora that = (Transportadora) o;
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

    public Transportadora clone(){
        return new Transportadora(this);
    }


    public double calculaPrecoTransporte(double peso, double distLoja, double distUser){
        double distTotal = distLoja + distUser;
        return (preco * distTotal) + peso;
    }


}





