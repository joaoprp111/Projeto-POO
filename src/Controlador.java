public class Controlador {
    private final Vista v;
    private final SistemaTrazAqui s;

    public Controlador(){
        this.v = new Vista();
        this.s = new SistemaTrazAqui();
    }

    public void run(){
        Input i = new Input();
        v.clear();
        s.loadFromLogs();

        int input = -1;

        while(input != 0){
            v.menuInicial();
            v.menuOpcoes();
            input = i.lerInt();
            switch(input){
                case 1:
                    novaConta();
                    break;
                case 2:
                    login();
                    break;
            }
            v.clear();
        }
    }

    private void novaConta(){
        Input i = new Input();
        boolean criada = false;
        int qualConta = -1;
        while(!criada){
            v.clear();
            v.criarConta();
            v.tipoDeConta();
            qualConta = i.lerInt();
            switch(qualConta){
                case 1:
                    novoUtilizador();
                    criada = true;
                    break;
                case 2:
                    novoVoluntario();
                    criada = true;
                    break;
                case 3:
                    novaLoja();
                    criada = true;
                    break;
                case 4:
                    novaTransportadora();
                    criada = true;
                    break;
                case 0:
                    return;
                default:
                    v.showMessage("Opção inválida\n");
            }
        }
    }

    public void novoUtilizador(){
        boolean confirmado = false;
        int opcao = -1;
        Input i = new Input();
        double x;
        double y;
        while(!confirmado){
            String nome;
            String codigo;
            String email;
            String password;
            opcao = -1;
            v.criarConta();
            v.showMessage("\n1. Nome completo: ");
            nome = i.lerString();
            v.criarConta();
            v.showMessage("\n2. Escolha um nickname [ u(número), exemplo -> u89 ]: ");
            codigo = i.lerString();
            while(s.existeConta(codigo) || codigo.charAt(0) != 'u'){
                v.criarConta();
                v.showMessage("\nCódigo inválido ou já existe, escolha outro: ");
                codigo = i.lerString();
            }
            v.criarConta();
            v.showMessage("\n3. Email: ");
            email = i.lerString();
            v.criarConta();
            v.showMessage("\n4. Password: ");
            password = i.lerString();
            v.criarConta();
            v.showMessage("\n5. Localização (x): ");
            x = i.lerDouble();
            v.showMessage("   Localização (y): ");
            y = i.lerDouble();
            v.criarConta();
            v.showMessage("\nNome: ");v.showMessage(nome);
            v.showMessage("\n\nNickname: ");v.showMessage(codigo);
            v.showMessage("\n\nEmail: ");v.showMessage(email);
            v.showMessage("\n\nPassword: ");v.showMessage(password);
            v.showMessage("\n\nLocalização: (");v.showMessage(x);v.showMessage(", ");v.showMessage(y);v.showMessage(")");
            while(opcao != 1 && opcao != 2) {
                v.showMessage("\n\nQuer criar a conta com estes dados? (1) Sim (2) Criar outra > ");
                opcao = i.lerInt();
            }
            if(opcao == 1){
                confirmado = true;
                GPS gps = new GPS(x,y);
                s.novoUtilizador(codigo, nome, gps, email, password);
            }
        }
        v.showMessage("\nConta criada, clique em (0) para voltar > ");
        while(opcao != 0){
            opcao = i.lerInt();
        }
    }

    public void novoVoluntario(){
        boolean confirmado = false;
        int opcao = -1;
        Input i = new Input();
        double x;
        double y;
        double raio;
        while(!confirmado){
            String nome;
            String codigo;
            String email;
            String password;
            opcao = -1;
            v.criarConta();
            v.showMessage("\n1. Nome completo: ");
            nome = i.lerString();
            v.criarConta();
            v.showMessage("\n2. Escolha um nickname [ v(número), exemplo -> v56 ]: ");
            codigo = i.lerString();
            while(s.existeConta(codigo) || codigo.charAt(0) != 'v'){
                v.criarConta();
                v.showMessage("\nCódigo inválido ou já existe, escolha outro: ");
                codigo = i.lerString();
            }
            v.criarConta();
            v.showMessage("\n3. Email: ");
            email = i.lerString();
            v.criarConta();
            v.showMessage("\n4. Password: ");
            password = i.lerString();
            v.criarConta();
            v.showMessage("\n5. Localização (x): ");
            x = i.lerDouble();
            v.showMessage("   Localização (y): ");
            y = i.lerDouble();
            v.criarConta();
            v.showMessage("\n6. O seu raio de ação (km): ");
            raio = i.lerDouble();
            v.criarConta();
            v.showMessage("\nNome: ");v.showMessage(nome);
            v.showMessage("\n\nNickname: ");v.showMessage(codigo);
            v.showMessage("\n\nEmail: ");v.showMessage(email);
            v.showMessage("\n\nPassword: ");v.showMessage(password);
            v.showMessage("\n\nLocalização: (");v.showMessage(x);v.showMessage(", ");v.showMessage(y);v.showMessage(")");
            v.showMessage("\n\nRaio de ação (km): ");v.showMessage(raio);
            while(opcao != 1 && opcao != 2) {
                v.showMessage("\n\nQuer criar a conta com estes dados? (1) Sim (2) Criar outra > ");
                opcao = i.lerInt();
            }
            if(opcao == 1){
                confirmado = true;
                GPS gps = new GPS(x,y);
                s.novoVoluntario(codigo, nome, gps, email, password, raio);
            }
        }
        v.showMessage("\nConta criada, clique em (0) para voltar > ");
        while(opcao != 0){
            opcao = i.lerInt();
        }
    }

    public void novaTransportadora(){
        boolean confirmado = false;
        boolean variasEncomendas = false;
        int opcao = -1;
        Input i = new Input();
        while(!confirmado){
            double x;
            double y;
            double preco;
            double raio;
            String nome;
            String codigo;
            String email;
            String password;
            String nif;
            opcao = -1;
            v.criarConta();
            v.showMessage("\n1. Nome da Empresa: ");
            nome = i.lerString();
            v.criarConta();
            v.showMessage("\n2. Escolha um código de acesso [ t(número), exemplo -> t111 ]: ");
            codigo = i.lerString();
            while(s.existeConta(codigo) || codigo.charAt(0) != 't'){
                v.criarConta();
                v.showMessage("\nCódigo inválido ou já existe, escolha outro: ");
                codigo = i.lerString();
            }
            v.criarConta();
            v.showMessage("\n3. Email: ");
            email = i.lerString();
            v.criarConta();
            v.showMessage("\n4. Password: ");
            password = i.lerString();
            v.criarConta();
            v.showMessage("\n5. Localização (x): ");
            x = i.lerDouble();
            v.showMessage("   Localização (y): ");
            y = i.lerDouble();
            v.criarConta();
            v.showMessage("\n6. NIF da Empresa: ");
            nif = i.lerString();
            v.criarConta();
            v.showMessage("\n7. Taxa de transporte (por km): ");
            preco = i.lerDouble();
            v.criarConta();
            v.showMessage("\n8. Pode transportar mais do que uma encomenda de cada vez? (1) Sim (2) Não ");
            opcao = i.lerInt();
            while(opcao != 1 && opcao != 2){
                v.showMessage("Opção inválida > ");
                opcao = i.lerInt();
            }
            if(opcao == 1) variasEncomendas = true;
            opcao = -1;
            v.criarConta();
            v.showMessage("\n\n9. Raio limite para transportações (km): ");
            raio = i.lerDouble();
            v.criarConta();
            v.showMessage("\nEmpresa: ");v.showMessage(nome);
            v.showMessage("\n\nCódigo de acesso: ");v.showMessage(codigo);
            v.showMessage("\n\nEmail: ");v.showMessage(email);
            v.showMessage("\n\nPassword: ");v.showMessage(password);
            v.showMessage("\n\nLocalização: (");v.showMessage(x);v.showMessage(", ");v.showMessage(y);v.showMessage(")");
            v.showMessage("\n\nNIF: ");v.showMessage(nif);
            v.showMessage("\n\nTaxa de transporte (por km): ");v.showMessage(preco);
            v.showMessage("\n\nRaio de transporte: ");v.showMessage(raio);
            v.showMessage("\n\nTransporte de várias encomendas: ");
            if(variasEncomendas) v.showMessage("Sim.");
            else v.showMessage("Não.");
            while(opcao != 1 && opcao != 2) {
                v.showMessage("\n\nQuer criar a conta com estes dados? (1) Sim (2) Criar outra > ");
                opcao = i.lerInt();
            }
            if(opcao == 1){
                confirmado = true;
                GPS gps = new GPS(x,y);
                s.novaTransportadora(codigo, nome, gps, email, password, nif, raio, preco, variasEncomendas);
            }
        }
        v.showMessage("\nConta criada, clique em (0) para voltar > ");
        while(opcao != 0){
            opcao = i.lerInt();
        }
    }

    public void novaLoja(){
        boolean confirmado = false;
        int opcao = -1;
        Input i = new Input();
        while(!confirmado){
            opcao = -1;
            boolean infoFilas = false;
            String nome, codigo, email, password;
            double x, y;
            v.criarConta();
            v.showMessage("\n1. Nome da Loja: ");
            nome = i.lerString();
            v.criarConta();
            v.showMessage("\n2. Escolha um código de acesso [ l(número), exemplo -> l120 ]: ");
            codigo = i.lerString();
            while(s.existeConta(codigo) || codigo.charAt(0) != 'l'){
                v.criarConta();
                v.showMessage("\nCódigo inválido ou já existe, escolha outro: ");
                codigo = i.lerString();
            }
            v.criarConta();
            v.showMessage("\n3. Email: ");
            email = i.lerString();
            v.criarConta();
            v.showMessage("\n4. Password: ");
            password = i.lerString();
            v.criarConta();
            v.showMessage("\n5. Localização (x): ");
            x = i.lerDouble();
            v.showMessage("   Localização (y): ");
            y = i.lerDouble();
            v.criarConta();
            v.showMessage("\n6. Pretende dar informação sobre filas de espera na loja? (1) Sim (2) Não > ");
            opcao = i.lerInt();
            while(opcao != 1 && opcao !=2){
                v.showMessage("\nOpção inválida, introduza outra > ");
                opcao = i.lerInt();
            }
            if(opcao == 1) infoFilas = true;
            opcao = -1;
            v.criarConta();
            v.showMessage("\nLoja: ");v.showMessage(nome);
            v.showMessage("\n\nCódigo de acesso: ");v.showMessage(codigo);
            v.showMessage("\n\nEmail: ");v.showMessage(email);
            v.showMessage("\n\nPassword: ");v.showMessage(password);
            v.showMessage("\n\nLocalização: (");v.showMessage(x);v.showMessage(", ");v.showMessage(y);v.showMessage(")");
            v.showMessage("\n\nInformação de filas de espera: ");
            if(infoFilas) v.showMessage("Sim.");
            else v.showMessage("Não.");
            while(opcao != 1 && opcao != 2) {
                v.showMessage("\n\nQuer criar a conta com estes dados? (1) Sim (2) Criar outra > ");
                opcao = i.lerInt();
            }
            if(opcao == 1){
                confirmado = true;
                GPS gps = new GPS(x,y);
                s.novaLoja(codigo, nome, gps, email, password, infoFilas);
            }
        }
        v.showMessage("\nConta criada, clique em (0) para voltar > ");
        while(opcao != 0){
            opcao = i.lerInt();
        }
    }

    public void login() {
        Input i = new Input();
        int opcao = -1;
        while (opcao != 2 && opcao != 0) {
            v.login();
            opcao = -1;
            v.showMessage("\nCódigo de acesso: ");
            String codigo = i.lerString();
            if (!s.existeConta(codigo)) {
                while (opcao != 1 && opcao != 2) {
                    v.login();
                    v.showMessage("\nCódigo inválido\n");
                    v.showMessage("\n(1) Tentar novamente");
                    v.showMessage("\n(2) Voltar para o menu\n > ");
                    opcao = i.lerInt();
                }
            }
            if (opcao != 2 && opcao != 1) {
                v.showMessage("\nPassword: ");
                String password = i.lerString();
                if (!s.passCorreta(codigo, password)) {
                    while (opcao != 1 && opcao != 2) {
                        v.login();
                        v.showMessage("\nPassword incorreta\n");
                        v.showMessage("\n(1) Tentar novamente");
                        v.showMessage("\n(2) Voltar para o menu\n > ");
                        opcao = i.lerInt();
                    }
                }
                else {
                    v.login();
                    opcao = -1;
                    while (opcao != 0) {
                        v.showMessage("Login efetuado!\nPressione (0) para aceder às funcionalidades ");
                        opcao = i.lerInt();
                    }
                }
            }
        }
    }
}
