import java.time.LocalDateTime;
import java.util.Objects;

public class ServicoEntrega {

    // ATRIBUTOS

    private int classificacao; // int >= 0 && int <= 5
    private EstadoEncomenda estado;
    private LocalDateTime dataNova;
    private LocalDateTime dataProntaASerEntregue;
    private LocalDateTime dataEmAceitacao;
    private LocalDateTime dataEmTransporte;
    private LocalDateTime dataEntregue;

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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoEntrega that = (ServicoEntrega) o;
        return classificacao == that.getClassificacao() &&
                estado == that.getEstado() &&
                Objects.equals(dataNova, that.getDataNova()) &&
                Objects.equals(dataProntaASerEntregue, that.getDataProntaASerEntregue()) &&
                Objects.equals(dataEmAceitacao, that.getDataEmAceitacao()) &&
                Objects.equals(dataEmTransporte, that.getDataEmTransporte()) &&
                Objects.equals(dataEntregue, that.getDataEntregue());
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("ServicoEntrega{");
        sb.append("classificacao=").append(classificacao);
        sb.append(", estado=").append(estado);
        sb.append(", dataNova=").append(dataNova);
        sb.append(", dataProntaASerEntregue=").append(dataProntaASerEntregue);
        sb.append(", dataEmAceitacao=").append(dataEmAceitacao);
        sb.append(", dataEmTransporte=").append(dataEmTransporte);
        sb.append(", dataEntregue=").append(dataEntregue);
        sb.append('}');
        return sb.toString();
    }
}
