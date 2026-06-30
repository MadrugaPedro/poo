import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "igormn";

    public static void main(String[] args) {
        FilmFileReader reader = new FilmFileReader();
        List<Film> films = reader.readFilms("src/new_films.txt");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            insertFilms(conn, films);
            updateRentalRates(conn);
            listFilmsWithDuration99(conn);

        } catch (Exception e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    private static void insertFilms(Connection conn, List<Film> films) {
        String sql = "INSERT INTO film " +
                "(title, language_id, rental_duration, rental_rate, replacement_cost) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (Film film : films) {
                stmt.setString(1, film.getTitle());
                stmt.setInt(2, film.getLanguageId());
                stmt.setInt(3, film.getRentalDuration());
                stmt.setDouble(4, film.getRentalRate());
                stmt.setDouble(5, film.getReplacementCost());

                stmt.executeUpdate();
            }

            System.out.println("Filmes importados com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao inserir filmes: " + e.getMessage());
        }
    }

    private static void updateRentalRates(Connection conn) {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            int total = stmt.executeUpdate();
            System.out.println("Valores de locação atualizados: " + total);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar valores: " + e.getMessage());
        }
    }

    private static void listFilmsWithDuration99(Connection conn) {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, 99);

            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println();
                System.out.println("Filmes com duração igual a 99:");

                while (rs.next()) {
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");

                    System.out.println(title + " - " + rentalRate);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar filmes: " + e.getMessage());
        }
    }
}