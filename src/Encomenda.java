import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Encomenda implements Comparable<Encomenda> {
    // variáveis de instância
    private String cod_enc;
    private String cod_user;
    private String cod_loja;
    private double peso;
    private boolean encomendaMedica;
    private String transportador;
    private final ServicoEntrega servicoEntrega;
    private List<LinhaEncomenda> linhas;

    /**
     * Construtores para objetos da classe Encomenda
     */
    public Encomenda() {
        this.cod_enc = "";
        this.cod_user = "";
        this.cod_loja = "";
        this.peso = 0.0;
        this.encomendaMedica = false;
        this.transportador = "";
        this.servicoEntrega = new ServicoEntrega();
        this.linhas = new ArrayList<>();
    }

    public Encomenda(String enc, String user, String loja, double peso, boolean encomendaMedica, Collection<LinhaEncomenda> linhas) {
        this.cod_enc = enc;
        this.cod_user = user;
        this.cod_loja = loja;
        this.peso = peso;
        this.encomendaMedica = encomendaMedica;
        this.servicoEntrega = new ServicoEntrega();
        this.setLinhas(linhas);
    }

    public Encomenda(String enc, String user, String loja, double peso, boolean encomendaMedica) {
        this.cod_enc = enc;
        this.cod_user = user;
        this.cod_loja = loja;
        this.peso = peso;
        this.encomendaMedica = encomendaMedica;
        this.servicoEntrega = new ServicoEntrega();
        this.linhas = new ArrayList<>();
    }

    public Encomenda(Encomenda e) {
        this.cod_enc = e.getCodEnc();
        this.cod_user = e.getCodUser();
        this.cod_loja = e.getCodLoja();
        this.peso = e.getPeso();
        this.encomendaMedica = e.isEncomendaMedica();
        this.transportador = e.getTransportador();
        this.servicoEntrega = e.getServicoEntrega();
        this.linhas = e.getLinhas();
    }

    /**
     * Metodos de instancia
     */

    public String getCodEnc() {
        return this.cod_enc;
    }

    public String getCodUser() {
        return this.cod_user;
    }

    public String getCodLoja() {
        return this.cod_loja;
    }

    public double getPeso() {
        return this.peso;
    }

    public boolean isEncomendaMedica() {
        return this.encomendaMedica;
    }

    public String getTransportador() { return this.transportador; }

    public ServicoEntrega getServicoEntrega() {
        return servicoEntrega;
    }

    public List<LinhaEncomenda> getLinhas() {
        List<LinhaEncomenda> novo;

        novo = this.linhas.stream()
                .map(LinhaEncomenda::clone).collect(Collectors.toCollection(ArrayList::new));

        return novo;
    }

    public void setCodEnc(String code) {
        this.cod_enc = code;
    }

    public void setCodUser(String code) {
        this.cod_user = code;
    }

    public void setCodLoja(String code) {
        this.cod_loja = code;
    }

    public void setPeso(double p) {
        this.peso = p;
    }

    public void setEncomendaMedica(boolean encomendaMedica) {
        this.encomendaMedica = encomendaMedica;
    }

    public void setLinhas(Collection<LinhaEncomenda> linhas) {
        this.linhas = new ArrayList<>();

        for (LinhaEncomenda le : linhas) this.linhas.add(le.clone());
    }

    public void addLinha(LinhaEncomenda le) {
        this.linhas.add(le.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return Double.compare(encomenda.getPeso(), getPeso()) == 0 &&
                isEncomendaMedica() == encomenda.isEncomendaMedica() &&
                cod_enc.equals(encomenda.cod_enc) &&
                cod_user.equals(encomenda.cod_user) &&
                cod_loja.equals(encomenda.cod_loja) &&
                getLinhas().equals(encomenda.getLinhas());
    }

    public Encomenda clone() {
        return new Encomenda(this);
    }

    @Override
    public String toString() {
        return "Encomenda{" +
                "cod_enc='" + cod_enc + '\'' +
                ", cod_user='" + cod_user + '\'' +
                ", cod_loja='" + cod_loja + '\'' +
                ", peso=" + peso +
                ", encomendaMedica=" + encomendaMedica +
                ", linhas=" + linhas +
                '}';
    }

    public Collection<String> produtosEncomendados() {
        return linhas.stream().map(LinhaEncomenda::getDesc)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public int compareTo(Encomenda e) {
        return this.cod_enc.compareTo(e.getCodEnc());
    }

    public void mudaEstado(EstadoEncomenda novoEstado){
        if(novoEstado != EstadoEncomenda.NOVA){
            this.servicoEntrega.setEstado(novoEstado);
            switch (novoEstado){
                case PRONTA_A_SER_ENTREGUE:
                    this.servicoEntrega.setDataProntaASerEntregue(LocalDateTime.now());
                case EM_ACEITACAO:
                    this.servicoEntrega.setDataEmAceitacao(LocalDateTime.now());
                case EM_TRANSPORTE:
                    this.servicoEntrega.setDataEmTransporte(LocalDateTime.now());
                case ENTREGUE:
                    this.servicoEntrega.setDataEntregue(LocalDateTime.now());
            }
        }
    }

    public void setClassificacaoDeTransporte(int classificacao){
        this.servicoEntrega.setClassificacao(classificacao);
    }

}
