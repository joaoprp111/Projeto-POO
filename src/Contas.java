import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Contas implements Serializable {
    private Map<String, String> emails;
    private Map<String, String> passwords;

    public Contas() {
        this.emails = new HashMap<>();
        this.passwords = new HashMap<>();
    }

    public Contas(Map<String, String> emails, Map<String, String> passwords) {
        setEmails(emails);
        setPasswords(passwords);
    }

    public Contas(Contas c) {
        this.emails = c.getEmails();
        this.passwords = c.getPasswords();
    }

    private Map<String, String> getEmails() {
        Map<String, String> res = new HashMap<>();
        for (Map.Entry<String, String> par : this.emails.entrySet()) {
            res.put(par.getKey(), par.getValue());
        }
        return res;
    }

    private void setEmails(Map<String, String> emails) {
        this.emails = new HashMap<>(emails);
    }

    private Map<String, String> getPasswords() {
        Map<String, String> res = new HashMap<>();
        for (Map.Entry<String, String> par : this.emails.entrySet()) {
            res.put(par.getKey(), par.getValue());
        }
        return res;
    }

    private void setPasswords(Map<String, String> passwords) {
        this.passwords = new HashMap<>(passwords);
    }

    public void adicionarRegisto(String codigo, String email, String password) {
        emails.put(codigo, email);
        passwords.put(codigo, password);
    }

    public boolean loginCorreto(String email, String password) {
        String[] parse = email.split("@");
        return (this.emails.containsKey(parse[0]) && this.passwords.containsKey(parse[0]));
    }

    public boolean existeConta(String codigo) {
        return emails.containsKey(codigo); /* Se existe nos emails também existe nas passwords */
    }

    public boolean existePass(String codigo, String pass) {
        return passwords.get(codigo).equals(pass);
    }

    public void info() {
        for (Map.Entry<String, String> par : emails.entrySet()) System.out.println(par);
        for (Map.Entry<String, String> par : passwords.entrySet()) System.out.println(par);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Contas{");
        sb.append("emails=").append(emails);
        sb.append(", passwords=").append(passwords);
        sb.append('}');
        return sb.toString();
    }
}
