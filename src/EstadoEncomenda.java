import java.io.Serializable;

public enum EstadoEncomenda implements Serializable {
    NOVA,
    EM_ACEITACAO,
    PRONTA_A_SER_ENTREGUE,
    EM_TRANSPORTE,
    ENTREGUE
}
