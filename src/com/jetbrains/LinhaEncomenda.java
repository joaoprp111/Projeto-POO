package com.jetbrains;

public class LinhaEncomenda{
    private String ref;
    private String desc;
    private double preco;
    private int qtd;
    private double taxa;
    private double desconto;

    /**
     * Construtores de LinhaEncomenda.
     *
     * Declaracao por omissao (vazio), parametrizada
     * e de copia.
     */

    /**
     * Construtor por omissao de LinhaEncomenda.
     */
    public LinhaEncomenda(){
        this.ref = new String();
        this.desc = new String();
        this.preco = 0.0;
        this.qtd = 0;
        this.taxa = 0.0;
        this.desconto = 0.0;
    }

    /**
     * Construtor parametrizado de LinhaEncomenda.
     */
    public LinhaEncomenda(String ref, String desc, double preco, int qtd, double taxa, double desconto){
        this.ref = ref;
        this.desc = desc;
        this.preco = preco;
        this.qtd = qtd;
        this.taxa = taxa;
        this.desconto = desconto;
    }

    /**
     * Construtor de copia de LinhaEncomenda.
     */
    public LinhaEncomenda(LinhaEncomenda le){
        this.ref = le.getRef();
        this.desc = le.getDesc();
        this.preco = le.getPreco();
        this.qtd = le.getQtd();
        this.taxa = le.getTaxa();
        this.desconto = le.getDesconto();
    }

    /**
     * Metodos de instancia
     */

    public String getRef(){
        return this.ref;
    }

    public String getDesc(){
        return this.desc;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getQtd(){
        return this.qtd;
    }

    public double getTaxa(){
        return this.taxa;
    }

    public double getDesconto(){
        return this.desconto;
    }

    public void setRef(String ref){
        this.ref = ref;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public void setPreco(double p){
        this.preco = p;
    }

    public void setQtd(int q){
        this.qtd = q;
    }

    public void setTaxa(double t){
        this.taxa = t;
    }

    public void setDesconto(double desconto){
        this.desconto = desconto;
    }

    public double calculaValorLinhaEnc(){
        double p = (this.preco * this.qtd);
        p -= p * this.desconto;
        p *= 1 + this.taxa;
        return p;
    }

    public double calculaValorDesconto(){
        double p = (this.preco * this.qtd);
        p *= this.taxa;
        return (this.calculaValorLinhaEnc() - p);
    }

    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }

    public boolean equals(Object obj){
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        LinhaEncomenda le = (LinhaEncomenda) obj;
        return le.getRef().equals(this.ref) &&
                le.getDesc().equals(this.desc) &&
                le.getPreco() == this.preco &&
                le.getQtd() == this.qtd &&
                le.getTaxa() == this.taxa &&
                le.getDesconto() == this.desconto;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Referencia: ").append(this.ref).append(" ");
        sb.append("Descricao: ").append(this.desc).append(" ");
        sb.append("Preco: ").append(this.preco).append(" ");
        sb.append("Quantidade: ").append(this.qtd).append(" ");
        sb.append("Taxa: ").append(this.taxa).append(" ");
        sb.append("Desconto: ").append(this.desconto).append(" | ");

        return sb.toString();
    }
}
