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
    private Vista v;

    public SistemaTrazAqui(){
        this.users = new TreeMap<>();
        this.voluntarios = new TreeMap<>();
        this.lojas = new TreeMap<>();
        this.transportadoras = new TreeMap<>();
        this.encomendas = new TreeMap<>();
        this.aceites = new ArrayList<>();
        this.v = new Vista();
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

    public void setUtilizador(String id, String nome, GPS gps){
        Utilizador u = new Utilizador(id, nome, gps);
        users.putIfAbsent(id, u.clone());
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
                    users.putIfAbsent(u.getCodigo(), u.clone());
                    break;
                case "Loja":
                    Loja l = p.parseLoja(linhaPartida[1]);
                    lojas.putIfAbsent(l.getCodigo(), l.clone());;
                    break;
                case "Voluntario":
                    Voluntario v = p.parseVoluntario(linhaPartida[1]);
                    voluntarios.putIfAbsent(v.getCodigo(), v.clone());
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
    }

    public void criaUtilizador(){
        Input i = new Input();
        int confirmado = 2;
        int voltar = -1;
        while(confirmado == 2) {
            v.clear();
            v.criarConta();
            v.showMessage("\n1. Introduza o seu nome completo > ");
            String nome = i.lerString();
            v.clear();
            v.criarConta();
            v.showMessage("\n2. Escolha o seu código de acesso (u(número), por exemplo u31) > ");
            String id = i.lerString();
            while (id.charAt(0) != 'u') {
                v.clear();
                v.criarConta();
                v.showMessage("\nCódigo inválido, introduza outro > ");
                id = i.lerString();
            }
            while (users.containsKey(id)) {
                v.clear();
                v.criarConta();
                v.showMessage("\nCódigo de utilizador já registado, por favor escolha outro > ");
                id = i.lerString();
                while (id.charAt(0) != 'u') {
                    v.clear();
                    v.criarConta();
                    v.showMessage("\nCódigo inválido, introduza outro > ");
                    id = i.lerString();
                }
            }
            v.clear();
            v.criarConta();
            v.showMessage("\n3. Indique as coordenadas da sua localização (x, y)");
            v.showMessage("\nCoordenada x > ");
            double x = i.lerDouble();
            v.showMessage("\nCoordenada y > ");
            double y = i.lerDouble();
            v.clear();
            v.criarConta();
            v.showMessage("\nConfirmação dos dados:\n");
            v.showMessage("\n1. Nome -> ");
            v.showMessage(nome);
            v.showMessage("\n\n2. Código de utilizador -> ");
            v.showMessage(id);
            v.showMessage("\n\n3. Coordenadas -> (");
            v.showMessage(x);
            v.showMessage(", ");
            v.showMessage(y);
            v.showMessage(")");
            v.showMessage("\n\n4. Email associado -> ");
            v.showMessage(id);
            v.showMessage("@gmail.com");
            v.showMessage("\n\n5. Password -> ");
            v.showMessage(id);
            v.showMessage("\n\nConfirmar os dados? (1) Sim (2) Não > ");
            confirmado = i.lerInt();
            if(confirmado == 1){
                GPS gps = new GPS(x, y);
                Utilizador novo = new Utilizador(id, nome, gps);
                users.put(id, novo.clone());
            }
        }
        v.clear();
        v.showMessage("\nConta criada!\n");
        while(voltar != 1){
            v.showMessage("Pressione (1) para voltar ao menu principal > \n");
            voltar = i.lerInt();
        }
    }

    public void login(){
        Input i = new Input();
        String email;
        int x = -1;
        String pw;
            v.clear();
            v.login();
            v.showMessage("\n1. Email [(código)@gmail.com] > ");
            email = i.lerString();
            String id = "";
                try {
                    id = email.split("@")[0];
                    email = email.split("@")[1];
                } catch (Exception e) {
                    v.showMessage(e.getMessage());
                }
            if (!users.containsKey(id) || !email.equals("gmail.com")) {
                v.clear();
                v.login();
                v.showMessage("\nUtilizador não encontrado!");
                while(x != 1){
                    v.showMessage("\nPrima 1 para voltar ao menu principal > ");
                    x = i.lerInt();
                }
            }
            else{
                v.clear();
                v.login();
                v.showMessage("\n2. Password (código do utilizador) > ");
                pw = i.lerString();
                while(!pw.equals(id)){
                    v.clear();
                    v.login();
                    v.showMessage("\nIntroduza a password correta > ");
                    pw = i.lerString();
                }
                v.clear();
                v.showMessage("\nSucesso!");
                while(x != 1){
                    v.showMessage("\nPressione (1) para continuar > ");
                    x = i.lerInt();
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
