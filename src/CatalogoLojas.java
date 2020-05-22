import javax.print.DocFlavor;
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
            StringBuilder sb;
            Collection<LinhaEncomenda> c = infoProdutos.get(codLoja);
            String res = "";
            Iterator it = c.stream().skip((p-1) * 10).
                    collect(Collectors.toCollection(ArrayList::new)).iterator();
            int i = 0;
            sb = new StringBuilder();
            sb.append("Produto | Preço/unidade | Código do Produto\n\n");
            while(it.hasNext() && i < 10){
                LinhaEncomenda le = (LinhaEncomenda) it.next();
                sb.append(le.getDesc()).append(" | ")
                        .append(le.getValorUnitario()).append(" | ").append(le.getCod()).append("\n");
                i++;
            }
            res = sb.toString();
            if(i == 0) return "Não existe catálogo para esta loja!\n";
            else return res;
    }

    public boolean existeProduto(String codLoja, String codProd){
        if(!infoProdutos.containsKey(codLoja)) return false;
        else{
            Collection<LinhaEncomenda> c = infoProdutos.get(codLoja);
            for(LinhaEncomenda le : c) if(le.getDesc().equals(codProd)) return true;
        }
        return false;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogoLojas{");
        sb.append("infoProdutos=").append(infoProdutos);
        sb.append('}');
        return sb.toString();
    }
}
