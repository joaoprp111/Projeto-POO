package com.jetbrains;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Parsing {

    public void parse(){
        List<String> linhas = lerFicheiro("logs_20200416.txt");
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Utilizador":
                    if (linhaPartida[1].charAt(0) == '<') System.out.println("Linha inválida!");
                    else {
                        Utilizador u = parseUtilizador(linhaPartida[1]); // criar um Utilizador
                        System.out.println(u.toString()); //enviar para o ecrÃ¡n apenas para teste }
                    }
                    break;
               case "Loja":
                   if (linhaPartida[1].charAt(0) == '<') System.out.println("Linha inválida!");
                   else {
                       Loja l = parseLoja(linhaPartida[1]);
                       System.out.println(l.toString());
                   }
                   break;
                case "Voluntario":
                    if (linhaPartida[1].charAt(0) == '<') System.out.println("Linha inválida!");
                    else {
                        Voluntario v = parseVoluntario(linhaPartida[1]);
                        System.out.println(v.toString());
                    }
                    break;
                case "Transportadora":
                    if (linhaPartida[1].charAt(0) == '<') System.out.println("Linha inválida!");
                    else {
                        Transportadora t = parseTransportadora(linhaPartida[1]);
                        System.out.println(t.toString());
                    }
                default:
                    break;
            }

        }
        System.out.println("done!");
    }

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

    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println(exc.getMessage()); }
        return lines;
    }
}
