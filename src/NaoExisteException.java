import java.io.Serializable;

public class NaoExisteException extends Exception implements Serializable {

    public NaoExisteException() {
        super();
    }

    public NaoExisteException(String s) {
        super(s);
    }
}
