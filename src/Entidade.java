import java.util.Objects;

abstract class Entidade {
    private String codigo;
    private String nome;
    private GPS gps;

    public Entidade(){
        this.codigo = "";
        this.nome = "";
        this.gps = new GPS();
    }

    public Entidade(String codigo, String nome, GPS gps) {
        this.codigo = codigo;
        this.nome = nome;
        this.gps = gps.clone();
    }

    public Entidade(Entidade e) {
        this.codigo = e.getCodigo();
        this.nome = e.getNome();
        this.gps = e.getGps();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GPS getGps() {
        return gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entidade entidade = (Entidade) o;
        return Objects.equals(codigo, entidade.getCodigo()) &&
                Objects.equals(nome, entidade.getNome()) &&
                Objects.equals(gps, entidade.getGps());
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Entidade{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", gps=").append(gps);
        sb.append('}');
        return sb.toString();
    }

    public abstract Entidade clone();
}
