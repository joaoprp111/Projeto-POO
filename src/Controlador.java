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
            v.clear();
            switch(input){
                case 1:
                    s.criaUtilizador();
                    break;
                case 2:
                    s.login();
                    break;
            }
            v.clear();
        }
    }
}
