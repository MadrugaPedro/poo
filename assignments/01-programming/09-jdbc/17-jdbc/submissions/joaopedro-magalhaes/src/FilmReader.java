import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFilmReader {

    public static List<Film> loadFilms(String filePath) {

        List<Film> movieList = new ArrayList<>();

        try {

            List<String> rows = Files.readAllLines(Path.of(filePath));

            for (int index = 1; index < rows.size(); index++) {

                String currentRow = rows.get(index);

                if (currentRow.isBlank()) {
                    continue;
                }

                String[] values = currentRow.split(";");

                Film film = new Film(
                        values[0],
                        Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]),
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4])
                );

                movieList.add(film);
            }

        } catch (IOException exception) {
            System.out.println("Erro ao ler arquivo: " + exception.getMessage());
        }

        return movieList;
    }
}