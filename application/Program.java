package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votes = new LinkedHashMap<>(); //LINKED = ORDEM QUE FOR ADD.

        System.out.print("ENTER A PATH: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine(); //LER A LINHA
            while (line != null){ //ENQUANTO LINE FOR DIFERENTE DE NULO
                String[] fields = line.split(","); //ARRAY DE STRINGS - SPLIT QUEBRA O VALOR NA VIRGULA.
                String name = fields[0]; //DEPOIS DE QUEBRAR, VOU OBTER OS VALORES DO NAME[0].
                int count = Integer.parseInt(fields[1]); //TRANSFORMAR OS VOTES DE STRING PARA INTEGER.POSICAO [1].


                if(votes.containsKey(name)){ //SE O VOTES CONTEM O NOME.
                    int voteSoFar = votes.get(name); //OBTER O NUMERO DE VOTOS
                    votes.put(name, count + voteSoFar); //SOMAR COM O VALOR QUE ESTÁ LENDO
                } else {
                    votes.put(name, count);
                }
                line = br.readLine(); //AO LER O FINAL DA LINHA, IRA PARA A PROXIMA LINHA.
            }

            for (String key : votes.keySet()){
                System.out.println(key + ": " + votes.get(key));
            }
        } catch (IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }

        sc.close();
    }
}