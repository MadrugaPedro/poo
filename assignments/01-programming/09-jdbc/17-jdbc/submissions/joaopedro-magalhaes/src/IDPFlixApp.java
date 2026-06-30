import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class MovieImporter {

    public static void main(String[] args) {

        Properties config = loadConfiguration();

        if (config == null) {
            return;
        }

        List<Film> films = CsvFilmReader.loadFilms("../../data/new_films.txt");

        try (Connection connection = DriverManager.getConnection(
                config.getProperty("db.url"),
                config.getProperty("db.user"),
                config.getProperty("db.password"))) {

            importFilms(connection, films);

            increaseRentalRates(connection);

            showLongRentalFilms(connection);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static Properties loadConfiguration() {

        Properties properties = new Properties();

        try (FileInputStream file = new FileInputStream("db.properties")) {

            properties.load(file);
            return properties;

        } catch (IOException exception) {

            exception.printStackTrace();
            return null;
        }
    }

    private static void importFilms(Connection connection, List<Film> films)
            throws SQLException {

        String sql =
                "INSERT INTO film " +
                "(title, language_id, rental_duration, rental_rate, replacement_cost) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            for (Film film : films) {

                statement.setString(1, film.getTitle());
                statement.setInt(2, film.getLanguageId());
                statement.setInt(3, film.getRentalDuration());
                statement.setDouble(4, film.getRentalRate());
                statement.setDouble(5, film.getReplacementCost());

                statement.executeUpdate();
            }
        }
    }

    private static void increaseRentalRates(Connection connection)
            throws SQLException {

        String sql =
                "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.executeUpdate();
        }
    }

    private static void showLongRentalFilms(Connection connection)
            throws SQLException {

        String sql =
                "SELECT title, rental_rate " +
                "FROM film " +
                "WHERE rental_duration = 99";

        try (
                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet result =
                        statement.executeQuery()
        ) {

            while (result.next()) {

                String title = result.getString("title");
                double rate = result.getDouble("rental_rate");

                System.out.println(title + " - " + rate);
            }
        }
    }
}