import java.util.Collection;

public interface IModelo {
    void loadFromLogs();
    Collection<Utilizador> getUsers();
    MeioTransporte getTransportador(String codigo);
    Collection<MeioTransporte> getTransportadores();
    Collection<Loja> getLojas();
    boolean lojaTemMedicamentos(String codLoja);
    Collection<Encomenda> getEncomendas();
    String toString();
    boolean equals(Object o);
    boolean existeConta(String codigo);
    boolean passCorreta(String codigo, String pass);
    void novoUtilizador(String codigo, String nome, GPS gps, String email, String password);
    void novoVoluntario(String codigo, String nome, GPS gps, String email, String password, double raio);
    void novaTransportadora(String codigo, String nome, GPS gps, String email, String password, String nif, double raio, double preco,
                            boolean variasEncs);
    void novaLoja(String code, String nome, GPS gps, String email,
                  String pw, boolean infoFilas, boolean temMeds);
    String lojasDisponiveis();
    boolean existeLoja(String cod);
    String buscarProdsAoCat(String loja, int p);
    boolean existeProdutoNaLoja(String codLoja, String codProd);
    LinhaEncomenda criarLinha(double qtd, String cod, String codLoja);
    String estadoEncomenda(Collection<LinhaEncomenda> c);
    double calculaPesoCarrinho(Collection<LinhaEncomenda> carrinho);
    boolean existeCodEnc(String cod);
    String gerarCodigoEnc();
    String encomendasFeitasUtilizador(String cod);
    void adicionarEncFeita(Encomenda e, String codUser);
    void adicionarNaLoja(Encomenda e, String codLoja);
    String pessoasEmEspera(String cod);
    String encomendasLoja (String cod);
    boolean existeEncLoja (String enc, String loja);
    boolean existeEncNova (String enc, String loja);
    Collection<Encomenda> encomendasNovas(String loja);
    boolean alteraDisponibilidadeTransportadora(String codT);
}
