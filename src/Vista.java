public class Vista {

    public void menuInicial(){
        clear();
        System.out.println("\n|-------------------------------------------------------------------------------------------------|");
        System.out.println("|-------------------------------------------------------------------------------------------------|");
        System.out.println("|                                           Traz Aqui!                                            |");
        System.out.println("|                                      Entrega de Encomendas                                      |");
        System.out.println("|-------------------------------------------------------------------------------------------------|");
        System.out.println("|-------------------------------------------------------------------------------------------------|");
    }

    public void menuOpcoes(){
        System.out.println("\n> (1) Crie uma conta");
        System.out.println("\n> (2) Faça login");
        System.out.println("\n> (0) Sair da aplicação");
        System.out.println("\n\n> Opção: ");
    }

    public void showMessage(Object o){
        System.out.print(o);
    }

    public void clear(){
        System.out.print("\033[H\033[2J");
    }

    public void criarConta(){
        clear();
        System.out.println("\n|-------------------------------------------------------------------------------------------------|");
        System.out.println("|                                           Criar conta                                           |");
        System.out.println("|-------------------------------------------------------------------------------------------------|");
    }

    public void tipoDeConta(){
        System.out.println("\n(1) Utilizador");
        System.out.println("\n(2) Voluntario");
        System.out.println("\n(3) Loja");
        System.out.println("\n(4) Empresa transportadora");
        System.out.println("\n(0) Voltar");
        System.out.println("\n> Opção: ");
    }

    public void login(){
        clear();
        System.out.println("\n|-------------------------------------------------------------------------------------------|");
        System.out.println("|                                           Login                                           |");
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }

    public void user(){
        clear();
        System.out.println("\n|-------------------------------------------------------------------------------------------|");
        System.out.println("|                                        Utilizador                                         |");
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }

    public void funcionalidadesUtilizador(){
        System.out.println("\n(1) Realizar encomenda");
        System.out.println("\n(0) Logout");
        System.out.println("\n> Opção: ");
    }

    public void escolherLojaParaEncomenda(){
        clear();
        System.out.println("\n|-------------------------------------------------------------------------------------------|");
        System.out.println("|                                   Escolha a loja                                          |");
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }

    public void produtosLoja(){
        clear();
        System.out.println("\n|-------------------------------------------------------------------------------------------|");
        System.out.println("|                                  Escolha um produto                                       |");
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }
}
