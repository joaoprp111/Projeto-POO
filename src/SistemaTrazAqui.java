import java.util.*;
import java.util.stream.Collectors;

public class SistemaTrazAqui {
    /* Estrutura provisória */
    private Collection<Utilizador> users;
    private Collection<Voluntario> voluntarios;
    private Map<String, Loja> lojas;
    private Collection<MeioTransporte> transportadoras;
    private Collection<Encomenda> encomendas;
    private Collection<String> aceites;
    private CatalogoLojas cat;
    private Contas registos;
    private Vista v;

    public SistemaTrazAqui(){
        this.users = new TreeSet<>();
        this.voluntarios = new TreeSet<>();
        this.lojas = new HashMap<>();
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
        return this.lojas.values()
                .stream().map(Loja::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean lojaTemMedicamentos(String codLoja){
            return lojas.get(codLoja)
                    .getTemMedicamentos();
    }

    public Collection<MeioTransporte> getTransportadoras(){
        Collection<MeioTransporte> res = new TreeSet<>();

        for(MeioTransporte t : this.transportadoras){
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
                    lojas.putIfAbsent(l.getCodigo(), l.clone());
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
                    MeioTransporte t = p.parseTransportadora(linhaPartida[1]);
                    transportadoras.add(t.clone());
                    String idT = t.getCodigo();
                    StringBuilder sbT = new StringBuilder(idT);
                    sbT.append("@gmail.com");
                    registos.adicionarRegisto(idT, sbT.toString(),idT);
                    break;
                case "Encomenda":
                    Encomenda e = p.parseEncomenda(linhaPartida[1]);
                    encomendas.add(e.clone());
                    List<LinhaEncomenda> listaLE = e.getLinhas();
                    for(LinhaEncomenda le : listaLE)
                        cat.insereProduto(e.getCodLoja(), le);
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
        Voluntario v = new Voluntario(codigo, nome, gps, raio, false);
        voluntarios.add(v.clone());
        registos.adicionarRegisto(codigo, email, password);
    }

    public void novaTransportadora(String codigo, String nome, GPS gps, String email, String password, String nif, double raio, double preco,
                                   boolean variasEncs){
        MeioTransporte t;
        if(variasEncs)
            t = new TransportadoraVariasEncs(codigo, nome, gps, raio, false, nif, preco);
        else
            t = new TransportadoraUmaEnc(codigo, nome, gps, raio, false, nif, preco);
        transportadoras.add(t.clone());
        registos.adicionarRegisto(codigo, email, password);
    }

    public void novaLoja(String code, String nome, GPS gps, String email,
                         String pw, boolean infoFilas, boolean temMeds){
        Loja l = new Loja(code, nome, gps, infoFilas, temMeds);
        lojas.putIfAbsent(code, l.clone());
        registos.adicionarRegisto(code, email, pw);
    }

    public double calculaDistancia(GPS gps1, GPS gps2){
        return GPS.dist(gps1, gps2);
    }

    public String lojasDisponiveis(){
        StringBuilder sb = new StringBuilder();
        for(Loja l : lojas.values()){
            if(cat.existeLoja(l.getCodigo())) {
                sb.append("\n").append(l.getNome()).append(" | ")
                        .append("Código: ")
                        .append(l.getCodigo()).append(" | ")
                        .append(l.getGps()).append("\n");
            }
        }
        return sb.toString();
    }

    public boolean existeLoja(String cod){
        return lojas.containsKey(cod);
    }

    public String buscarProdsAoCat(String loja, int p){
        return cat.separaPorPaginas(loja, p);
    }

    public boolean existeProdutoNaLoja(String codLoja, String codProd){
        return cat.existeProduto(codLoja, codProd);
    }

    LinhaEncomenda criarLinha(double qtd, String cod, String codLoja){
        double precoUnitario = cat.precoDeUmProduto(cod, codLoja);
        String nomeProd = cat.nomeDeUmProduto(cod, codLoja);
        return new LinhaEncomenda(cod, nomeProd, precoUnitario, qtd);
    }

    public String estadoEncomenda(Collection<LinhaEncomenda> c){
        StringBuilder sb = new StringBuilder(); int i = 1;
        double precoTotal = 0.0;
        double pesoTotal = 0.0;
        for(LinhaEncomenda le: c){
            sb.append("Produto ").append(i++)
                    .append(": ").append(le.getDesc()).append(" | Unidades: ").append(le.getQtd())
                    .append(" | Preço total: ").append(le.calculaValorLinhaEnc())
                    .append(" | Peso total: ").append(le.calculaPeso()).append("\n");
            precoTotal += le.calculaValorLinhaEnc();
            pesoTotal += le.calculaPeso();
        }
        sb.append("Preço total da encomenda: ").append(precoTotal).append("\n");
        sb.append("Peso total da encomenda: ").append(pesoTotal).append("\n");
        return sb.toString();
    }

    public double calculaPesoCarrinho(Collection<LinhaEncomenda> carrinho){
        return carrinho.stream()
                .mapToDouble(LinhaEncomenda::calculaPeso).reduce(0.0, (ac, el) -> ac + el);
    }

    public String gerarCodigoEnc(){
        String res = "";
        while(!encomendas.contains(res)){
            int num = 1 + (int) (Math.random() * ((10000-1) + 1));
            String numstr = String.valueOf(num);
            StringBuilder sb = new StringBuilder("e");
            sb.append(numstr);
            res = sb.toString();
        }
        return res;
    }
}
