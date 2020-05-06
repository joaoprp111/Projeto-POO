import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SistemaTrazAqui {
    /* Estrutura provisória */
    private Map<String, Utilizador> users;
    private Map<String, Voluntario> voluntarios;
    private Map<String, Loja> lojas;
    private Map<String, Transportadora> transportadoras;
    private Map<String, Encomenda> encomendas;
    private List<String> aceites;

    public SistemaTrazAqui(){
        this.users = new TreeMap<>();
        this.voluntarios = new TreeMap<>();
        this.lojas = new TreeMap<>();
        this.transportadoras = new TreeMap<>();
        this.encomendas = new TreeMap<>();
        this.aceites = new ArrayList<>();
    }

    /* Getters */
    public Map<String, Utilizador> getUsers(){
        Map<String, Utilizador> res = new TreeMap<>();

        for(Map.Entry<String,Utilizador> p : this.users.entrySet()){
            res.putIfAbsent(p.getKey(), p.getValue().clone());
        }

        return res;
    }

    public Map<String, Voluntario> getVoluntarios(){
        Map<String, Voluntario> res = new TreeMap<>();

        for(Map.Entry<String,Voluntario> p : this.voluntarios.entrySet()){
            res.putIfAbsent(p.getKey(), p.getValue().clone());
        }

        return res;
    }

    public Map<String, Loja> getLojas(){
        Map<String, Loja> res = new TreeMap<>();

        for(Map.Entry<String,Loja> p : this.lojas.entrySet()){
            res.putIfAbsent(p.getKey(), p.getValue().clone());
        }

        return res;
    }

    public Map<String, Transportadora> getTransportadoras(){
        Map<String, Transportadora> res = new TreeMap<>();

        for(Map.Entry<String,Transportadora> p : this.transportadoras.entrySet()){
            res.putIfAbsent(p.getKey(), p.getValue().clone());
        }

        return res;
    }

    public Map<String, Encomenda> getEncomendas(){
        Map<String, Encomenda> res = new TreeMap<>();

        for(Map.Entry<String,Encomenda> p : this.encomendas.entrySet()){
            res.putIfAbsent(p.getKey(), p.getValue().clone());
        }

        return res;
    }

    public List<String> getAceites(){
        List<String> res = new ArrayList<>();
        for(String s: this.aceites) res.add(s);
        return res;
    }

    public void loadFromLogs(){
        Parsing p = new Parsing();
        List<String> linhas = p.lerFicheiro("logs_20200416.txt");
        linhas = linhas.stream().skip(43).collect(Collectors.toList()); /* Este comando dá skip nas primeiras 43 linhas do ficheiro de logs, que é informação não útil para o programa */
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Utilizador":
                    Utilizador u = p.parseUtilizador(linhaPartida[1]); // criar um Utilizador
                    users.putIfAbsent(u.getId(), u.clone());
                    break;
                case "Loja":
                    Loja l = p.parseLoja(linhaPartida[1]);
                    lojas.putIfAbsent(l.getCodigo(), l.clone());;
                    break;
                case "Voluntario":
                    Voluntario v = p.parseVoluntario(linhaPartida[1]);
                    voluntarios.putIfAbsent(v.getId(), v.clone());
                    break;
                case "Transportadora":
                    Transportadora t = p.parseTransportadora(linhaPartida[1]);
                    transportadoras.putIfAbsent(t.getCodigo(), t.clone());
                    break;
                case "Encomenda":
                    Encomenda e = p.parseEncomenda(linhaPartida[1]);
                    encomendas.putIfAbsent(e.getCodEnc(), e.clone());
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
}
