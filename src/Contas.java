import java.util.HashMap;
import java.util.Map;

public class Contas {
    private Map<String, String> emails;
    private Map<String, String> passwords;

    public Contas(){
        this.emails = new HashMap<>();
        this.passwords = new HashMap<>();
    }

    public Contas(Map<String, String> emails, Map<String, String> passwords) {
        setEmails(emails);
        setPasswords(passwords);
    }

    public Contas(Contas c){
        this.emails = c.getEmails();
        this.passwords = c.getPasswords();
    }

    private Map<String, String> getEmails() {
        Map<String, String> res = new HashMap<>();
        for(Map.Entry<String, String> par: this.emails.entrySet()){
            res.put(par.getKey(), par.getValue());
        }
        return res;
    }

    private void setEmails(Map<String, String> emails) {
        this.emails = new HashMap<>(emails);
    }

    private Map<String, String> getPasswords() {
        Map<String, String> res = new HashMap<>();
        for(Map.Entry<String, String> par: this.emails.entrySet()){
            res.put(par.getKey(), par.getValue());
        }
        return res;
    }

    private void setPasswords(Map<String, String> passwords) {
        this.passwords = new HashMap<>(passwords);
    }

    public boolean adicionarRegisto(String email, String password){
        Vista v = new Vista();
        boolean res = false;
        String[] parse = email.split("@");
        if(this.emails.containsKey(parse[0])) v.showMessage("Este email já está associado a uma conta!\n");
        else{
            this.emails.put(parse[0], email);
            this.passwords.put(parse[0], password);
            res = true;
        }
        return res;
    }

    public boolean loginCorreto(String email, String password){
        String[] parse = email.split("@");
        return (this.emails.containsKey(parse[0]) && this.passwords.containsKey(parse[0]));
    }
}
