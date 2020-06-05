public class Proposta {
    private String transporte;
    private double custo;
    private double distancia;

    public Proposta() {
        this.transporte = "";
        this.custo = this.distancia = 0.0;
    }

    public Proposta(String transporte, double custo, double distancia) {
        this.transporte = transporte;
        this.custo = custo;
        this.distancia = distancia;
    }

    public  Proposta(Proposta p){
        this.transporte = p.getTransporte();
        this.custo = p.getCusto();
        this.distancia = p.getDistancia();
    }

    public String getTransporte() {
        return transporte;
    }

    public double getCusto() {
        return custo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Proposta{");
        sb.append("transporte='").append(transporte).append('\'');
        sb.append(", custo=").append(custo);
        sb.append(", distancia=").append(distancia);
        sb.append('}');
        return sb.toString();
    }

    public Proposta clone(){
        return new Proposta(this);
    }
}
