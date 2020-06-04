import java.util.Objects;

public class TransportadoraUmaEnc extends MeioTransporte {
    private String nif;
    private double preco; // preco por km
    private int ocupacao;
    private Encomenda enc;

    public TransportadoraUmaEnc(){
        super();
        this.nif = "";
        this.preco = 0.0;
        this.ocupacao = 0;
        this.enc = null;
    }

    public TransportadoraUmaEnc(String codigo, String nome, GPS gps, double raio, boolean certificado, String nif, double preco) {
        super(codigo, nome, gps, raio, certificado);
        this.nif = nif;
        this.preco = preco;
        this.ocupacao = 0;
        this.enc = null;
    }

    public TransportadoraUmaEnc(TransportadoraUmaEnc t) {
        super(t);
        this.nif = t.getNif();
        this.preco = t.getPreco();
        this.ocupacao = t.getOcupacao();
        if(this.ocupacao > 0) this.enc = t.getEnc();
        else this.enc = null;
    }

    public String getNif() {
        return nif;
    }

    public double getPreco() {
        return preco;
    }

    public Encomenda getEnc() {
        return enc.clone();
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

    public void setEnc(Encomenda enc) {
        this.enc = enc.clone();
    }

    public void setOcupacao(int ocup){
        this.ocupacao = ocup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransportadoraUmaEnc that = (TransportadoraUmaEnc) o;
        return Double.compare(that.getPreco(), getPreco()) == 0 &&
                getOcupacao() == that.getOcupacao() &&
                getNif().equals(that.getNif()) &&
                Objects.equals(getEnc(), that.getEnc());
    }

    @Override
    public String toString() {
        return "TransportadoraUmaEnc{" +
                "nif='" + nif + '\'' +
                ", preco=" + preco +
                ", ocupacao=" + ocupacao +
                ", enc=" + enc +
                '}';
    }

    public TransportadoraUmaEnc clone(){
        return new TransportadoraUmaEnc(this);
    }

    public double calculaPrecoTransporte(double peso, double distLoja, double distUser){
        double distTotal = distLoja + distUser;
        return (preco * distTotal) + peso;
    }
}

