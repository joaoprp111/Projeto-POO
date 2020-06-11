import java.io.*;

/**
 * Onde o programa inicia
 */
public class Main {

    public static void main(String[] args) {
        SistemaTrazAqui m;
        File f = new File("./sistemaTrazAqui.data");

        if (f.exists() && !f.isDirectory()) {
            try {
                m = readFile("./sistemaTrazAqui.data");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                m = new SistemaTrazAqui();
            }
        } else {
            m = new SistemaTrazAqui();
        }

        IVista v = new Vista();
        IControlador c = new Controlador(v, m);
        c.run();
    }

    /**
     * Guarda o estado atual em ficheiro
     */
    public static void writeInFile(SistemaTrazAqui s) throws IOException {
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("./sistemaTrazAqui.data"));
        o.writeObject(s);
        o.flush();
        o.close();
    }

    /**
     * Carrega de um ficheiro um estado
     */
    public static SistemaTrazAqui readFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));
        SistemaTrazAqui s = (SistemaTrazAqui) o.readObject();
        o.close();
        return s;
    }
}
