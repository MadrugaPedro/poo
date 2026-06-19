package flix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeitorFilmes {

    public static List<Film> lerArquivo(String caminho) {
        List<Film> filmes = new ArrayList<>();
        Path path = Paths.get(caminho);

        try {
            List<String> linhas = Files.readAllLines(path);

            for (String linha : linhas) {
                String[] dados = linha.split(";");

                if (dados.length == 5) {
                    try {
                        String title = dados[0];
                        int languageId = Integer.parseInt(dados[1]);
                        int rentalDuration = Integer.parseInt(dados[2]);
                        double rentalRate = Double.parseDouble(dados[3]);
                        double replacementCost = Double.parseDouble(dados[4]);

                        filmes.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                    } catch (NumberFormatException e) {
                        System.err.println("Linha ignorada devido a erro de formatação: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }

        return filmes;
    }
}