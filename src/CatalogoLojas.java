import java.util.*;
import java.util.stream.Collectors;

public class CatalogoLojas implements Catalogos{
    private Map<String, Collection<String>> catLojas;

    public CatalogoLojas(){
        catLojas = new HashMap<>();
    }

    public void carregaLoja(Collection<String> prods, String codLoja){
        if(catLojas.containsKey(codLoja)){
            catLojas.get(codLoja).addAll(prods);
        }
        else{
            Set<String> produtos = new HashSet<>(prods);
            catLojas.put(codLoja, produtos);
        }
    }

    public Collection<String> getProdutosLoja(String codLoja, int p) throws Exception{
        if(!catLojas.containsKey(codLoja)) throw new Exception("Não existe essa loja!");
        Collection<String> produtos = catLojas.get(codLoja);

        produtos = produtos.stream().skip(10 * (p-1)).collect(Collectors.toList());
        Collection<String> res = new ArrayList<>();

        Iterator it = produtos.iterator();
        int i = 0;
        while(it.hasNext() && i < 10){
            String s = (String) it.next();
            res.add(s);
            i++;
        }

        return res;
    }

    public boolean existeProduto(String codLoja, String prod){
        /* Neste método a chave é sempre válida (a loja) */
        return catLojas.get(codLoja).contains(prod);
    }
}
