import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(";");
                String title = parts[0].trim();
                int languageId = Integer.parseInt(parts[1].trim());
                int rentalDuration = Integer.parseInt(parts[2].trim());
                double rentalRate = Double.parseDouble(parts[3].trim());
                double replacementCost = Double.parseDouble(parts[4].trim());

                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return films;
    }
}
