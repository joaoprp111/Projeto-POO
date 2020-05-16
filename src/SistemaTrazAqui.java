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
