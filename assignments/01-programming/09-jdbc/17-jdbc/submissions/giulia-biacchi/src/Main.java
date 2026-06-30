import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        List<Film> films = FilmFileReader.readFilms("data/new_films.txt");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            importFilms(conn, films);
            updateRentalRates(conn);
            listFilmsWithRentalDuration99(conn);

        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco de dados: " + e.getMessage());
        }
    }

    private static void importFilms(Connection conn, List<Film> films) throws SQLException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Film film : films) {
                ps.setString(1, film.getTitle());
                ps.setInt(2, film.getLanguageId());
                ps.setInt(3, film.getRentalDuration());
                ps.setDouble(4, film.getRentalRate());
                ps.setDouble(5, film.getReplacementCost());
                ps.executeUpdate();
            }
        }

        System.out.println("Filmes importados com sucesso.");
    }

    private static void updateRentalRates(Connection conn) throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int rows = ps.executeUpdate();
            System.out.println("Valor de locação atualizado em " + rows + " filme(s).");
        }
    }

    private static void listFilmsWithRentalDuration99(Connection conn) throws SQLException {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Filmes com duração de locação igual a 99:");
            while (rs.next()) {
                System.out.println(rs.getString("title") + " - R$ " + rs.getDouble("rental_rate"));
            }
        }
    }
}
