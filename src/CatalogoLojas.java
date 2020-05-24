import java.util.*;
import java.util.stream.Collectors;

public class CatalogoLojas implements Catalogos{
    private Map<String,Collection<LinhaEncomenda>> infoProdutos;

    public CatalogoLojas(){
        infoProdutos = new HashMap<>();
    }

    public void insereProduto(String codLoja, LinhaEncomenda le){
        if(!infoProdutos.containsKey(codLoja)){
            Collection<LinhaEncomenda> nova = new ArrayList<>();
            nova.add(le.clone());
            infoProdutos.put(codLoja, nova);
        }
        else{
            Collection<LinhaEncomenda> c = infoProdutos.get(codLoja);
            int numRepetidos = (int) c.stream()
                    .filter(l -> l.getDesc().equals(le.getDesc())).count();
            if(numRepetidos == 0) c.add(le.clone());
        }
    }

    public String separaPorPaginas(String codLoja, int p) {
        if(infoProdutos.containsKey(codLoja)) {
            StringBuilder sb;
            Collection<LinhaEncomenda> c = infoProdutos.get(codLoja);
            String res = "";
            Iterator it = c.stream().skip((p - 1) * 10).
                    collect(Collectors.toCollection(ArrayList::new)).iterator();
            int i = 0;
            sb = new StringBuilder();
            sb.append("Produto | Preço/unidade | Código do Produto\n\n");
            while (it.hasNext() && i < 10) {
                LinhaEncomenda le = (LinhaEncomenda) it.next();
                sb.append(le.getDesc()).append(" | ")
                        .append(le.getValorUnitario()).append(" € | ").append(le.getCod()).append("\n");
                i++;
            }
            res = sb.toString();
            if(i == 0) return "Não existe catálogo para esta loja!\n";
            else return res;
        }
        else return "Não existe catálogo para esta loja!\n";
    }

    public boolean existeProduto(String codLoja, String codProd){
        if(!infoProdutos.containsKey(codLoja)) return false;
        else{
            Collection<LinhaEncomenda> c = infoProdutos.get(codLoja);
            for(LinhaEncomenda le : c) if(le.getCod().equals(codProd)) return true;
        }
        return false;
    }

    public double precoDeUmProduto(String codProd, String codLoja){
        Collection<LinhaEncomenda> c = infoProdutos.get(codLoja);
        Iterator it = c.iterator();
        boolean encontrado = false; double res = 0.0;
        while(it.hasNext() && !encontrado){
            LinhaEncomenda le = (LinhaEncomenda) it.next();
            if (codProd.equals(le.getCod())){
                encontrado = true;
                res = le.getValorUnitario();
            }
        }
        return res;
    }

    public String nomeDeUmProduto(String codProd, String codLoja){
        Collection<LinhaEncomenda> c = infoProdutos.get(codLoja);
        Iterator it = c.iterator();
        boolean encontrado = false; String res = "";
        while(it.hasNext() && !encontrado){
            LinhaEncomenda le = (LinhaEncomenda) it.next();
            if (codProd.equals(le.getCod())){
                encontrado = true;
                res = le.getDesc();
            }
        }
        return res;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogoLojas{");
        sb.append("infoProdutos=").append(infoProdutos.keySet());
        sb.append('}');
        return sb.toString();
    }

    public boolean existeLoja(String codLoja){
        return infoProdutos.containsKey(codLoja);
    }
}
