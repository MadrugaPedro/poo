package submissions.pedro_lucas_lopes_monteiro.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {

    public static List<Film> readFilmsFromFile(String filePath) {
        List<Film> films = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            // Lê todas as linhas do arquivo de texto
            List<String> lines = Files.readAllLines(path);
            
            // Pula o cabeçalho (index 0) e processa os dados
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;

                // Divide a linha usando o ponto e vírgula como separador
                String[] data = line.split(";");
                
                String title = data[0];
                int languageId = Integer.parseInt(data[1]);
                int rentalDuration = Integer.parseInt(data[2]);
                double rentalRate = Double.parseDouble(data[3]);
                double replacementCost = Double.parseDouble(data[4]);

                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de filmes: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Erro de formatação de número no arquivo: " + e.getMessage());
        }

        return films;
    }
}