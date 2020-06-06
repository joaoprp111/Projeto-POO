import java.util.*;
import java.util.stream.Collectors;

public class SistemaTrazAqui implements IModelo{
    /* Estrutura provisória */
    private Map<String, Utilizador> users;
    private Map<String, Loja> lojas;
    private Map<String, MeioTransporte> transportadores;
    private Collection<Encomenda> encomendas;
    private Collection<String> aceites;
    private CatalogoLojas cat;
    private Contas registos;
    private Vista v;

    public SistemaTrazAqui(){
        this.users = new HashMap<>();
        this.lojas = new HashMap<>();
        this.transportadores = new HashMap<>();
        this.encomendas = new TreeSet<>();
        this.aceites = new ArrayList<>();
        this.registos = new Contas();
        this.cat = new CatalogoLojas();
        this.v = new Vista();
    }

    /* Getters */
    public Collection<Utilizador> getUsers(){
        Collection<Utilizador> res = new TreeSet<>();

        for(Utilizador u : this.users.values()){
            res.add(u.clone());
        }

        return res;
    }

    public MeioTransporte getTransportador(String codigo){

        for(MeioTransporte t : this.transportadores.values()){
            if(codigo.equals(t.getCodigo())) {
                return t;
            }
        }
        return null;

    }

    public Collection<Loja> getLojas(){
        return this.lojas.values()
                .stream().map(Loja::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean lojaTemMedicamentos(String codLoja){
            return lojas.get(codLoja)
                    .getTemMedicamentos();
    }

    public Collection<MeioTransporte> getTransportadores(){
        return this.transportadores.values()
                .stream().map(MeioTransporte::clone).collect(Collectors.toCollection(TreeSet::new));
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
        users.put(id, u.clone());
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
                    users.put(u.getCodigo(), u.clone());
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
                    transportadores.put(v.getCodigo(),v.clone());
                    String idV = v.getCodigo();
                    StringBuilder sbV = new StringBuilder(idV);
                    sbV.append("@gmail.com");
                    registos.adicionarRegisto(idV, sbV.toString(),idV);
                    break;
                case "Transportadora":
                    MeioTransporte t = p.parseTransportadora(linhaPartida[1]);
                    transportadores.put(t.getCodigo(),t.clone());
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
        sb.append(", lojas=").append(lojas).append("\n");
        sb.append(", transportadoras=").append(transportadores).append("\n");
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
               this.lojas.equals(that.getLojas()) &&
               this.transportadores.equals(that.getTransportadores()) &&
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
        users.put(codigo, u.clone());
        registos.adicionarRegisto(codigo, email, password);
    }

    public void novoVoluntario(String codigo, String nome, GPS gps, String email, String password, double raio){
        Voluntario v = new Voluntario(codigo, nome, gps, raio, false);
        transportadores.put(codigo, v.clone());
        registos.adicionarRegisto(codigo, email, password);
    }

    public void novaTransportadora(String codigo, String nome, GPS gps, String email, String password, String nif, double raio, double preco,
                                   boolean variasEncs){
        MeioTransporte t;
        t = new Transportadora(codigo, nome, gps, raio, false, nif, preco,variasEncs,false);
        transportadores.put(codigo, t.clone());
        registos.adicionarRegisto(codigo, email, password);
    }

    public void novaLoja(String code, String nome, GPS gps, String email,
                         String pw, boolean infoFilas, boolean temMeds){
        Loja l = new Loja(code, nome, gps, infoFilas, temMeds);
        lojas.putIfAbsent(code, l.clone());
        registos.adicionarRegisto(code, email, pw);
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

    public LinhaEncomenda criarLinha(double qtd, String cod, String codLoja){
        double precoUnitario = cat.precoDeUmProduto(cod, codLoja);
        String nomeProd = cat.nomeDeUmProduto(cod, codLoja);
        double pesoProd = cat.pesoDeUmProduto(cod, codLoja);
        return new LinhaEncomenda(cod, nomeProd, precoUnitario, qtd, pesoProd);
    }

    public String estadoEncomenda(Collection<LinhaEncomenda> c){
        StringBuilder sb = new StringBuilder(); int i = 1;
        double precoTotal = 0.0;
        double pesoTotal = 0.0;
        for(LinhaEncomenda le: c){
            sb.append("Produto ").append(i++)
                    .append(": ").append(le.getDesc()).append(" | Unidades: ").append(le.getQtd())
                    .append(" | Preço total: ").append(le.calculaValorLinhaEnc())
                    .append(" € | Peso total: ").append(le.calculaPeso()).append(" kg\n");
            precoTotal += le.calculaValorLinhaEnc();
            pesoTotal += le.calculaPeso();
        }
        sb.append("Preço total da encomenda: ").append(precoTotal).append(" €\n");
        sb.append("Peso total da encomenda: ").append(pesoTotal).append(" kg\n");
        return sb.toString();
    }

    public double calculaPesoCarrinho(Collection<LinhaEncomenda> carrinho){
        return carrinho.stream()
                .mapToDouble(LinhaEncomenda::calculaPeso).reduce(0.0, (ac, el) -> ac + el);
    }

    public boolean existeCodEnc(String cod){
        return this.encomendas.stream()
                .anyMatch(e -> e.getCodEnc().equals(cod));
    }

    public String gerarCodigoEnc(){
        String res = "";
        while(!existeCodEnc(res)){
            int num = 1 + (int) (Math.random() * ((10000-1) + 1));
            String numstr = String.valueOf(num);
            StringBuilder sb = new StringBuilder("e");
            sb.append(numstr);
            res = sb.toString();
        }
        return res;
    }

    public String encomendasFeitasUtilizador(String cod){
        Utilizador u = users.get(cod);
        StringBuilder sb = new StringBuilder();
        Collection<Encomenda> c = u.getEncsFeitas();
        if(c.size() == 0) return "Não existem encomendas feitas ainda!\n";
        sb.append("\nEncomendas feitas:\n");
        int i = 1;
        for(Encomenda e: c){
            sb.append("\nEncomenda ").append(i++).append(": ").append("Loja: ")
                    .append(lojas.get(e.getCodLoja()).getNome()).append(" | Código da encomenda: ").append(e.getCodEnc())
                    .append(" | Data da encomenda: ").append(e.dataEncomenda()).append("\n");
        }
        return sb.toString();
    }

    public void adicionarEncFeita(Encomenda e, String codUser){
        Utilizador u = users.get(codUser);
        u.setEncFeita(e);
    }

    public void adicionarNaLoja(Encomenda e, String codLoja){
        if(lojas.containsKey(codLoja)){
            Loja l = lojas.get(codLoja);
            l.setEnc(e);
        }
    }

    public String pessoasEmEspera(String cod){
        StringBuilder sb = new StringBuilder();
        Loja l = lojas.get(cod);
        sb.append(l.getPessoasEmEspera());
        return sb.toString();
    }

    public String encomendasLoja (String cod){
        Loja l = lojas.get(cod);
        StringBuilder sb = new StringBuilder();
        for (Encomenda e : l.getEncs().values())
            sb.append(e.toString()).append("\n");
        return sb.toString();
    }

    public boolean existeEncLoja (String enc, String loja){
        Loja l = lojas.get(loja);
        return l.getEncs().values().stream()
                          .anyMatch(e -> e.getCodEnc().equals(enc));
    }

    public boolean existeEncNova (String enc, String loja){
        Collection<Encomenda> c = encomendasNovas(loja);
        return c.stream().anyMatch(e -> e.getCodEnc().equals(enc));
    }

    public Collection<Encomenda> encomendasNovas(String loja){
        Loja l = lojas.get(loja);
        StringBuilder sb = new StringBuilder();
        return (l.getEncs().values().stream().filter(e -> e.getEstado() == EstadoEncomenda.NOVA).collect(Collectors.toCollection(ArrayList::new)));
    }

    /*public String enviarPropostas (String loja, String enc){
        Loja l = lojas.get(loja);
        Collection<Proposta> propostas = new ArrayList<>();
        l.getEncs().get(enc).setEstado(EstadoEncomenda.EM_ACEITACAO);
        Encomenda e = l.getEncs().get(enc);
        Utilizador u = users.get(e.getCodUser());
        if (e.isEncomendaMedica()){
            Iterator it = transportadores.values().iterator();
            int flag = 0;
            while(it.hasNext() && flag == 0){
                Voluntario v = (Voluntario) it.next();
                if (v.aceitoTransporteMedicamentos() && v.isDisponivel()
                    &&  GPS.dist(v.getGps(),l.getGps()) <= v.getRaio()
                    && GPS.dist(l.getGps(),u.getGps()) <= v.getRaio())
                        Proposta p = new Proposta(e.getCodEnc(),v.getCodigo(),0.0,)

            }
        }

    }*/

    public boolean alteraDisponibilidadeTransportadora(String codT){
        Transportadora t = (Transportadora) transportadores.get(codT);
        t.setDisponivel(!t.isDisponivel());

        return !t.isDisponivel();
    }
}
