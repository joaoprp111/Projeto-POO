public abstract class MeioTransporte extends Entidade{
    private double raio;
    private double velocidade;
    private boolean disponivel;
    private boolean quer_fazer_entrega;
    private boolean aceitoMeds;
    private boolean certificado;

    /*
     * Construtor por omissao
     */
    public MeioTransporte(){
        super();
        this.raio = 0.0;
        this.velocidade = 0.0;
        this.disponivel = false;
        this.quer_fazer_entrega = false;
        this.aceitoMeds = false;
        this.certificado = false;
    }

    /*
     * Construtor parametrizado
     */
    public MeioTransporte(String codigo, String nome, GPS gps, double raio, boolean certificado) {
        super(codigo, nome, gps);
        this.raio = raio;
        this.velocidade = 0.0;
        this.disponivel = false;
        this.quer_fazer_entrega = false;
        this.aceitoMeds = false;
        this.certificado = certificado;
    }

    /*
     * Construtor por cópia
     */
    public MeioTransporte(MeioTransporte t) {
        super(t);
        this.raio = t.getRaio();
        this.velocidade = t.getVelocidade();
        this.disponivel = t.isDisponivel();
        this.quer_fazer_entrega = t.Quer_fazer_entrega();
        this.aceitoMeds = t.aceitoTransporteMedicamentos();
        this.certificado = t.isCertificado();
    }

    /*
     * Getters
     */

    /**
     *                      Devolve o raio de transporte
     * @return              Raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     *                      Devolve a velocidade do meio de transporte
     * @return              Velocidade
     */
    public double getVelocidade() {
        return velocidade;
    }

    /**
     *                      Informa se o meio de transporte está ou não disponível
     * @return              true se estiver disponivel, false caso contrário
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     *                      Informa se o meio de transporte quer fazer a entrega
     * @return              true se quiser, false caso contrário
     */
    public boolean Quer_fazer_entrega() {
        return quer_fazer_entrega;
    }

    /**
     *                      Informa se o meio de transporte aceita fazer transporte de medicamentos
     * @return              true se quiser, false caso contrário
     */
    public boolean aceitoTransporteMedicamentos(){
        return aceitoMeds;
    }

    /**
     *                      Informa se o meio de transporte é certificado
     * @return              true se quiser, false caso contrário
     */
    public boolean isCertificado(){ return certificado; }


    /*
     * Setters
     */

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void setVelocidade(double velocidade){
        this.velocidade = velocidade;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public void setQuer_fazer_entrega(boolean quer_fazer_entrega){
        this.quer_fazer_entrega = quer_fazer_entrega;
    }

    public void setAceitaMedicamentos(boolean state){
        this.aceitoMeds = state;
    }

    public void setCertificado(boolean certificado){
        this.certificado = certificado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MeioTransporte that = (MeioTransporte) o;
        return Double.compare(that.getRaio(), getRaio()) == 0 &&
                Double.compare(that.getVelocidade(), getVelocidade()) == 0 &&
                isDisponivel() == that.isDisponivel() &&
                quer_fazer_entrega == that.quer_fazer_entrega &&
                aceitoMeds == that.aceitoMeds &&
                isCertificado() == that.isCertificado();
    }

    @Override
    public String toString() {
        return "MeioTransporte{" +
                "raio=" + raio +
                ", velocidade=" + velocidade +
                ", disponivel=" + disponivel +
                ", quer_fazer_entrega=" + quer_fazer_entrega +
                ", aceitoMeds=" + aceitoMeds +
                ", certificado=" + certificado +
                '}';
    }

    public abstract MeioTransporte clone();
}
