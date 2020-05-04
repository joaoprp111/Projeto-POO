import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaTrazAqui {
    /* Estrutura provisória */
    private List<Utilizador> users;
    private List<Voluntario> voluntarios;
    private List<Loja> lojas;
    private List<Transportadora> transportadoras;
    private List<Encomenda> encomendas;
    private List<String> aceites;

    public SistemaTrazAqui(){
        this.users = new ArrayList<>();
        this.voluntarios = new ArrayList<>();
        this.lojas = new ArrayList<>();
        this.transportadoras = new ArrayList<>();
        this.encomendas = new ArrayList<>();
        this.aceites = new ArrayList<>();
    }

    public SistemaTrazAqui(SistemaTrazAqui s){
        this.users = s.getUsers();
        this.voluntarios = s.getVoluntarios();
        this.lojas = s.getLojas();
        this.transportadoras = s.getTransportadoras();
        this.encomendas = s.getEncomendas();
        this.aceites = s.getAceites();
    }

    /* Getters */
    public List<Utilizador> getUsers(){
        return this.users.stream()
                         .map(Utilizador::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Voluntario> getVoluntarios(){
        return this.voluntarios.stream()
                .map(Voluntario::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Loja> getLojas(){
        return this.lojas.stream()
                .map(Loja::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Transportadora> getTransportadoras(){
        return this.transportadoras.stream()
                .map(Transportadora::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Encomenda> getEncomendas(){
        return this.encomendas.stream()
                .map(Encomenda::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getAceites(){
        List<String> res = new ArrayList<>();
        for(String s: this.aceites) res.add(s);
        return res;
    }

    public void parse(){
        Parsing p = new Parsing();
        List<String> linhas = p.lerFicheiro("logs_20200416.txt");
        linhas = linhas.stream().skip(43).collect(Collectors.toList()); /* Este comando dá skip nas primeiras 43 linhas do ficheiro de logs, que é informação não útil para o programa */
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Utilizador":
                    Utilizador u = p.parseUtilizador(linhaPartida[1]); // criar um Utilizador
                    users.add(u.clone());
                    break;
                case "Loja":
                    Loja l = p.parseLoja(linhaPartida[1]);
                    lojas.add(l.clone());
                    break;
                case "Voluntario":
                    Voluntario v = p.parseVoluntario(linhaPartida[1]);
                    voluntarios.add(v.clone());
                    break;
                case "Transportadora":
                    Transportadora t = p.parseTransportadora(linhaPartida[1]);
                    transportadoras.add(t.clone());
                    break;
                case "Encomenda":
                    Encomenda e = p.parseEncomenda(linhaPartida[1]);
                    encomendas.add(e.clone());
                    break;
                case "Aceite":
                    aceites.add(linhaPartida[1]);
                    break;
                default:
                    break;
            }

        }
        System.out.println("done!");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SistemaTrazAqui{");
        sb.append("users=").append(users).append("\n");
        sb.append(", voluntarios=").append(voluntarios).append("\n");
        sb.append(", lojas=").append(lojas).append("\n");
        sb.append(", transportadoras=").append(transportadoras).append("\n");
        sb.append(", encomendas=").append(encomendas).append("\n");
        sb.append(", aceites=").append(aceites);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemaTrazAqui that = (SistemaTrazAqui) o;
        return this.users.equals(that.getUsers()) &&
               this.voluntarios.equals(that.getVoluntarios()) &&
               this.lojas.equals(that.getLojas()) &&
               this.transportadoras.equals(that.getTransportadoras()) &&
               this.encomendas.equals(that.getEncomendas()) &&
               this.aceites.equals(that.getAceites());
    }

    public SistemaTrazAqui clone(){
        return new SistemaTrazAqui(this);
    }
}
