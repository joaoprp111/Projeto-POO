import java.util.Objects;

public class TransportadoraUmaEnc extends Transportadora {
    int ocupacao;
    private Encomenda enc;

    public TransportadoraUmaEnc(){
        super();
        this.ocupacao = 0;
        this.enc = null;
    }

    public TransportadoraUmaEnc(String codigo, String nome, GPS gps, String nif, double raio, double preco) {
        super(codigo, nome, gps, nif, raio, preco);
        this.ocupacao = 0;
        this.enc = null;
    }

    public TransportadoraUmaEnc(TransportadoraUmaEnc t) {
        super(t);
        this.ocupacao = t.getOcupacao();
        if(this.ocupacao > 0) this.enc = t.getEnc();
        else this.enc = null;
    }

    public Encomenda getEnc() {
        return enc.clone();
    }

    public int getOcupacao(){
        return this.ocupacao;
    }

    public void setEnc(Encomenda enc) {
        this.enc = enc.clone();
    }

    public void setOcupacao(int ocup){
        this.ocupacao = ocup;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransportadoraUmaEnc that = (TransportadoraUmaEnc) o;
        return Objects.equals(enc, that.getEnc());
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(enc);
        sb.append('}');
        return sb.toString();
    }

    public TransportadoraUmaEnc clone(){
        return new TransportadoraUmaEnc(this);
    }
}
