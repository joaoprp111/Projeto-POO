import java.time.LocalDateTime;

public class ServicoEntrega {

    // ATRIBUTOS

    private int classificacao; /// int >= 0 && int <= 5
    private EstadoEncomenda estado;
    private LocalDateTime dataNova;
    private LocalDateTime dataProntaASerEntregue;
    private LocalDateTime dataEmAceitacao;
    private LocalDateTime dataEmTransporte;
    private LocalDateTime dataEntregue;
    private double custoTransporte;


    // CONSTRUTOR

    public ServicoEntrega() {
        this.estado = EstadoEncomenda.NOVA;
        this.dataNova = LocalDateTime.now();
    }


    // GETTERS E SETTERS

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        if(classificacao >= 0 && classificacao <= 5)
            this.classificacao = classificacao;
    }

    public EstadoEncomenda getEstado() {
        return estado;
    }

    public void setEstado(EstadoEncomenda estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataNova() {
        return dataNova;
    }

    public void setDataNova(LocalDateTime dataNova) {
        this.dataNova = dataNova;
    }

    public LocalDateTime getDataProntaASerEntregue() {
        return dataProntaASerEntregue;
    }

    public void setDataProntaASerEntregue(LocalDateTime dataProntaASerEntregue) {
        this.dataProntaASerEntregue = dataProntaASerEntregue;
    }

    public LocalDateTime getDataEmAceitacao() {
        return dataEmAceitacao;
    }

    public void setDataEmAceitacao(LocalDateTime dataEmAceitacao) {
        this.dataEmAceitacao = dataEmAceitacao;
    }

    public LocalDateTime getDataEmTransporte() {
        return dataEmTransporte;
    }

    public void setDataEmTransporte(LocalDateTime dataEmTransporte) {
        this.dataEmTransporte = dataEmTransporte;
    }

    public LocalDateTime getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(LocalDateTime dataEntregue) {
        this.dataEntregue = dataEntregue;
    }

    public double getCustoTransporte() {
        return custoTransporte;
    }

    public void setCustoTransporte(double custoTransporte) {
        this.custoTransporte = custoTransporte;
    }

    @Override
    public String toString() {
        return "ServicoEntrega{" +
                "classificacao=" + classificacao +
                ", estado=" + estado +
                ", dataNova=" + dataNova +
                ", dataProntaASerEntregue=" + dataProntaASerEntregue +
                ", dataEmAceitacao=" + dataEmAceitacao +
                ", dataEmTransporte=" + dataEmTransporte +
                ", dataEntregue=" + dataEntregue +
                ", custoTransporte=" + custoTransporte +
                '}';
    }
}
