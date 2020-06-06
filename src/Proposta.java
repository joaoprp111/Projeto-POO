public class Proposta {
    private String enc;
    private String transporte;
    private double custo;
    private double tempo;

    public Proposta() {
        this.transporte = this.enc = "";
        this.custo = this.tempo = 0.0;
    }

    public Proposta(String enc, String transporte, double custo, double distancia) {
        this.enc = enc;
        this.transporte = transporte;
        this.custo = custo;
        this.tempo = distancia;
    }

    public  Proposta(Proposta p){
        this.enc = p.getEnc();
        this.transporte = p.getTransporte();
        this.custo = p.getCusto();
        this.tempo = p.getTempo();
    }

    public String getEnc() {
        return enc;
    }

    public void setEnc(String enc) {
        this.enc = enc;
    }

    public String getTransporte() {
        return transporte;
    }

    public double getCusto() {
        return custo;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public void setTempo(double distancia) {
        this.tempo = distancia;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Proposta{");
        sb.append("encomenda=").append(enc);
        sb.append(", transporte='").append(transporte);
        sb.append(", custo=").append(custo);
        sb.append(", tempo=").append(tempo);
        sb.append('}');
        return sb.toString();
    }

    public Proposta clone(){
        return new Proposta(this);
    }
}
