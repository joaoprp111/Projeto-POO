public class Main {

    public static void main(String[] args) {
	    SistemaTrazAqui s = new SistemaTrazAqui();
	    s.loadFromLogs();
	    System.out.println(s.toString());
    }
}
