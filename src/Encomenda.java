import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Encomenda implements Comparable<Encomenda>{
    // variáveis de instância
    private String cod_enc;
    private String cod_user;
    private String cod_loja;
    private double peso;
    private LocalDateTime data;
    private List<LinhaEncomenda> linhas;

    /**
     * Construtores para objetos da classe Encomenda
     */
    public Encomenda(){
        this.cod_enc = new String();
        this.cod_user = new String();
        this.cod_loja = new String();
        this.peso = 0.0;
        this.data = LocalDateTime.now();
        this.linhas = new ArrayList<>();
    }

    public Encomenda(String enc, String user, String loja, double peso, List<LinhaEncomenda> linhas){
        this.cod_enc = enc;
        this.cod_user = user;
        this.cod_loja = loja;
        this.peso = peso;
        this.data = LocalDateTime.now();
        this.setLinhas(linhas);
    }

    public Encomenda(String enc, String user, String loja, double peso){
        this.cod_enc = enc;
        this.cod_user = user;
        this.cod_loja = loja;
        this.peso = peso;
        this.data = LocalDateTime.now();
        this.linhas = new ArrayList<>();
    }

    public Encomenda(Encomenda e){
        this.cod_enc = e.getCodEnc();
        this.cod_user = e.getCodUser();
        this.cod_loja = e.getCodLoja();
        this.peso = e.getPeso();
        this.data = e.getData();
        this.linhas = e.getLinhas();
    }

    /**
     * Metodos de instancia
     */

    public String getCodEnc(){
        return this.cod_enc;
    }

    public String getCodUser(){
        return this.cod_user;
    }

    public String getCodLoja(){
        return this.cod_loja;
    }

    public double getPeso(){
        return this.peso;
    }

    public LocalDateTime getData(){
        return this.data;
    }

    public List<LinhaEncomenda> getLinhas(){
        List<LinhaEncomenda> novo;

        novo = this.linhas.stream()
                   .map(LinhaEncomenda::clone).collect(Collectors.toCollection(ArrayList::new));

        return novo;
    }

    public void setCodEnc(String code){
        this.cod_enc = code;
    }

    public void setCodUser(String code){
        this.cod_user = code;
    }

    public void setCodLoja(String code){
        this.cod_loja = code;
    }

    public void setPeso(double p){
        this.peso = p;
    }

    public void setData(LocalDateTime d){
        this.data = d;
    }

    public void setLinhas(List<LinhaEncomenda> linhas){
        this.linhas = new ArrayList<>();

        for(LinhaEncomenda le: linhas) this.linhas.add(le.clone());
    }

    public void addLinha(LinhaEncomenda le){
        this.linhas.add(le.clone());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return Double.compare(encomenda.getPeso(), this.peso) == 0 &&
               this.cod_enc.equals(encomenda.getCodEnc()) &&
               this.cod_user.equals(encomenda.getCodUser()) &&
               this.cod_loja.equals(encomenda.getCodLoja()) &&
               this.data.equals(encomenda.getData()) &&
               this.linhas.equals(encomenda.getLinhas());
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Encomenda{");
        sb.append("cod_enc='").append(cod_enc).append('\'');
        sb.append(", cod_user='").append(cod_user).append('\'');
        sb.append(", cod_loja='").append(cod_loja).append('\'');
        sb.append(", peso=").append(peso);
        sb.append(", data=").append(data);
        sb.append(", linhas=").append(linhas);
        sb.append('}');
        return sb.toString();
    }

    public Collection<String> produtosEncomendados(){
        return linhas.stream().map(LinhaEncomenda::getDesc)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int compareTo(Encomenda e){
        return this.cod_enc.compareTo(e.getCodEnc());
    }
}
