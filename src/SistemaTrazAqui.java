import java.util.*;
import java.util.stream.Collectors;

public class SistemaTrazAqui {
    /* Estrutura provisória */
    private Collection<Utilizador> users;
    private Collection<Voluntario> voluntarios;
    private Collection<Loja> lojas;
    private Collection<Transportadora> transportadoras;
    private Collection<Encomenda> encomendas;
    private Collection<String> aceites;
    private CatalogoLojas cat;
    private Contas registos;
    private Vista v;

    public SistemaTrazAqui(){
        this.users = new TreeSet<>();
        this.voluntarios = new TreeSet<>();
        this.lojas = new TreeSet<>();
        this.transportadoras = new TreeSet<>();
        this.encomendas = new TreeSet<>();
        this.aceites = new ArrayList<>();
        this.registos = new Contas();
        this.cat = new CatalogoLojas();
        this.v = new Vista();
    }

    /* Getters */
    public Collection<Utilizador> getUsers(){
        Collection<Utilizador> res = new TreeSet<>();

        for(Utilizador u : this.users){
            res.add(u.clone());
        }

        return res;
    }

    public Collection<Voluntario> getVoluntarios(){
        Collection<Voluntario> res = new TreeSet<>();

        for(Voluntario v : this.voluntarios){
            res.add(v.clone());
        }

        return res;
    }

    public Collection<Loja> getLojas(){
        Collection<Loja> res = new TreeSet<>();

        for(Loja l : this.lojas){
            res.add(l.clone());
        }

        return res;
    }

    public Collection<Transportadora> getTransportadoras(){
        Collection<Transportadora> res = new TreeSet<>();

        for(Transportadora t : this.transportadoras){
            res.add(t.clone());
        }

        return res;
    }

    public Collection<Encomenda> getEncomendas(){
        Collection<Encomenda> res = new TreeSet<>();

        for(Encomenda e : this.encomendas){
            res.add(e.clone());
        }

        return res;
    }

    public void contas(){
        registos.info();
    }

    public Collection<String> getAceites(){
        return new ArrayList<>(this.aceites);
    }

    public void setUtilizador(String id, String nome, GPS gps){
        Utilizador u = new Utilizador(id, nome, gps);
        users.add(u.clone());
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
                    users.add(u.clone());
                    String codigo = u.getCodigo();
                    StringBuilder sb = new StringBuilder(codigo);
                    sb.append("@gmail.com");
                    registos.adicionarRegisto(codigo, sb.toString(),codigo);
                    break;
                case "Loja":
                    Loja l = p.parseLoja(linhaPartida[1]);
                    lojas.add(l.clone());
                    String idLoja = l.getCodigo();
                    StringBuilder sbL = new StringBuilder(idLoja);
                    sbL.append("@gmail.com");
                    registos.adicionarRegisto(idLoja, sbL.toString(),idLoja);
                    break;
                case "Voluntario":
                    Voluntario v = p.parseVoluntario(linhaPartida[1]);
                    voluntarios.add(v.clone());
                    String idV = v.getCodigo();
                    StringBuilder sbV = new StringBuilder(idV);
                    sbV.append("@gmail.com");
                    registos.adicionarRegisto(idV, sbV.toString(),idV);
                    break;
                case "Transportadora":
                    Transportadora t = p.parseTransportadora(linhaPartida[1]);
                    transportadoras.add(t.clone());
                    String idT = t.getCodigo();
                    StringBuilder sbT = new StringBuilder(idT);
                    sbT.append("@gmail.com");
                    registos.adicionarRegisto(idT, sbT.toString(),idT);
                    break;
                case "Encomenda":
                    Encomenda e = p.parseEncomenda(linhaPartida[1]);
                    encomendas.add(e.clone());
                    Collection<String> prodsEncomendados = e.produtosEncomendados();
                    try {
                        cat.carregaLoja(prodsEncomendados, e.getCodLoja());
                    } catch(Exception exc){
                        this.v.showMessage(exc.getMessage());
                    }
                    break;
                case "Aceite":
                    aceites.add(linhaPartida[1]);
                    break;
                default:
                    break;
            }

        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SistemaTrazAqui{");
        sb.append("users=").append(users).append("\n");
        sb.append(", voluntarios=").append(voluntarios).append("\n");
        sb.append(", lojas=").append(lojas).append("\n");
        sb.append(", transportadoras=").append(transportadoras).append("\n");
        sb.append(", encomendas=").append(encomendas).append("\n");
        sb.append(", aceites=").append(aceites);
        sb.append(", contas=").append(registos.toString());
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

    public boolean existeConta(String codigo){
        return registos.existeConta(codigo);
    }

    public boolean passCorreta(String codigo, String pass){
        return registos.existePass(codigo, pass);
    }

    public void novoUtilizador(String codigo, String nome, GPS gps, String email, String password){
        Utilizador u = new Utilizador(codigo, nome, gps);
        users.add(u.clone());
        registos.adicionarRegisto(codigo, email, password);
    }

    public void novoVoluntario(String codigo, String nome, GPS gps, String email, String password, double raio){
        Voluntario v = new Voluntario(codigo, nome, gps, raio);
        voluntarios.add(v.clone());
        registos.adicionarRegisto(codigo, email, password);
    }

    public void novaTransportadora(String codigo, String nome, GPS gps, String email, String password, String nif, double raio, double preco,
                                   boolean variasEncs){
        Transportadora t;
        if(variasEncs)
            t = new TransportadoraVariasEncs(codigo, nome, gps, nif, raio, preco);
        else
            t = new TransportadoraUmaEnc(codigo, nome, gps, nif, raio, preco);
        transportadoras.add(t.clone());
        registos.adicionarRegisto(codigo, email, password);
    }

    public void novaLoja(String code, String nome, GPS gps, String email,
                         String pw, boolean infoFilas){
        Loja l = new Loja(code, nome, gps, infoFilas);
        lojas.add(l.clone());
        registos.adicionarRegisto(code, email, pw);
    }

    public double calculaDistancia(GPS gps1, GPS gps2){
        return GPS.dist(gps1, gps2);
    }

    public String lojasDisponiveis(){
        StringBuilder sb = new StringBuilder();
        for(Loja l : lojas){
            sb.append(l.getNome()).append(" | Localização: ").append(l.getGps()).append("\n");
        }
        return sb.toString();
    }
}
