package com.jetbrains;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Parsing {

    public Utilizador parseUtilizador(String input){
        String[] campos = input.split(",");
        String id = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        return new Utilizador(id, nome, gpsx, gpsy);
    }

    public Loja parseLoja(String input){
        String[] campos = input.split(",");
        String codigo = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        return new Loja(codigo, nome, gpsx, gpsy);
    }

    public Voluntario parseVoluntario(String input){
        String[] campos = input.split(",");
        String id = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        double raio = Double.parseDouble(campos[4]);
        return new Voluntario(id, nome, gpsx, gpsy, raio);
    }

    public Transportadora parseTransportadora(String input){
        String[] campos = input.split(",");
        String id = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        String nif = campos[4];
        double raio = Double.parseDouble(campos[5]);
        double preco = Double.parseDouble(campos[6]);
        return new Transportadora(id, nome, gpsx, gpsy, nif, raio, preco);
    }

    public Encomenda parseEncomenda(String input){
        String[] campos = input.split(",");
        String codEnc = campos[0];
        String codUser = campos[1];
        String codLoja = campos[2];
        double peso = Double.parseDouble(campos[3]);
        Encomenda e = new Encomenda(codEnc, codUser, codLoja, peso);
        int i = 4;
        int size = campos.length;
        while( i < size){
            String codP = campos[i++];
            String desc = campos[i++];
            double preco = Double.parseDouble(campos[i++]);
            double qtd = Double.parseDouble(campos[i++]);
            LinhaEncomenda le = new LinhaEncomenda(codP, desc, preco, qtd);
            e.addLinha(le);
        }
        return e;
    }

    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println(exc.getMessage()); }
        return lines;
    }
}
