import java.util.Collection;

public interface Catalogos {
    void carregaLoja(Collection<String> produtos, String loja);
    Collection<String> getProdutosLoja(String codLoja, int pagina) throws Exception;
}
