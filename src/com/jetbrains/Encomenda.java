package com.jetbrains;

import java.time.LocalDate;
import java.util.ArrayList;
public class Encomenda{
    // variáveis de instância
    private String nome;
    private String nif;
    private String morada;
    private int num;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas;

    /**
     * Construtores para objetos da classe Encomenda
     */
    public Encomenda(){
        this.nome = new String();
        this.nif = new String();
        this.morada = new String();
        this.num = 0;
        this.data = LocalDate.now();
        this.linhas = new ArrayList<>();
    }

    public Encomenda(String name, String nif, String m, int n, ArrayList<LinhaEncomenda> linhas){
        this.nome = name;
        this.nif = nif;
        this.morada = m;
        this.num = n;
        this.data = LocalDate.now();
        this.setLinhas(linhas);
    }

    public Encomenda(Encomenda e){
        this.nome = e.getNome();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.num = e.getNum();
        this.data = e.getData();
        this.linhas = e.getLinhas();
    }

    /**
     * Metodos de instancia
     */

    public String getNome(){
        return this.nome;
    }

    public String getNif(){
        return this.nif;
    }

    public String getMorada(){
        return this.morada;
    }

    public int getNum(){
        return this.num;
    }

    public LocalDate getData(){
        return this.data;
    }

    public ArrayList<LinhaEncomenda> getLinhas(){
        ArrayList<LinhaEncomenda> novo = new ArrayList<>();

        for(LinhaEncomenda le: this.linhas) novo.add(le);

        return novo;
    }

    /**
     * b) i.
     */

    public void setNome(String name){
        this.nome = name;
    }

    public void setNif(String n){
        this.nif = n;
    }

    public void setMorada(String m){
        this.morada = m;
    }

    public void setNum(int n){
        this.num = n;
    }

    public void setData(LocalDate d){
        this.data = d;
    }

    public void setLinhas(ArrayList<LinhaEncomenda> linhas){
        this.linhas = new ArrayList<>();

        for(LinhaEncomenda le: linhas) this.linhas.add(le);
    }

    public boolean equals(Object obj){
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        Encomenda e = (Encomenda) obj;
        return e.getNome().equals(this.nome) &&
                e.getNif().equals(this.nif) &&
                e.getMorada().equals(this.morada) &&
                e.getNum() == this.num &&
                e.getData().equals(this.data) &&
                e.getLinhas().equals(this.linhas);
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append(" ");
        sb.append("NIF: ").append(this.nif).append(" ");
        sb.append("Morada: ").append(this.morada).append(" ");
        sb.append("Numero: ").append(this.num).append(" ");
        sb.append("Data: ").append(this.data).append(" ");
        sb.append("Linhas: ");

        for(LinhaEncomenda le: this.linhas) sb.append(le.toString());

        return sb.toString();
    }

    /**
     * b) ii.
     */

    public double calculaValorTotal(){
        double valorTotal = 0.0;

        for(LinhaEncomenda le: this.linhas) valorTotal += le.calculaValorLinhaEnc();

        return valorTotal;
    }

    /**
     * b) iii.
     */

    public double calculaValorDesconto(){
        double total = 0.0;

        for(LinhaEncomenda le: this.linhas) total += le.calculaValorDesconto();

        return total;
    }

    /**
     * b) iv.
     */

    public int numeroTotalProdutos(){
        int total = 0;

        for(LinhaEncomenda le: this.linhas) total += le.getQtd();

        return total;
    }

    /**
     * b) v.
     */

    public boolean existeProdutoEncomenda(String refProduto){
        boolean res = false;

        for(LinhaEncomenda le: this.linhas) if(le.getRef().equals(refProduto)) res = true;

        return res;
    }

    /**
     * b) vi.
     */

    public void adicionaLinha(LinhaEncomenda linha){
        this.linhas.add(linha);
    }

    /**
     * b) vii.
     */

    public void removeProduto(String codProd){
        int pos = 0;
        int i = 0;
        boolean encontrado = false;

        for(LinhaEncomenda le: this.linhas){
            if(le.getRef().equals(codProd) == true){
                pos = i;
                encontrado = true;
            }
            i++;
        }

        if(encontrado == true) this.linhas.remove(pos);

    }
}
