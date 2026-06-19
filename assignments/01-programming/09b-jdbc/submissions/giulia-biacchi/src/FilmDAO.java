import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public int insert(Connection conn, Film film) throws SQLException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, film.getTitle());
            ps.setInt(2, film.getLanguageId());
            ps.setInt(3, film.getRentalDuration());
            ps.setDouble(4, film.getRentalRate());
            ps.setDouble(5, film.getReplacementCost());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }

        throw new SQLException("Não foi possível obter o ID do filme inserido.");
    }

    public Film findById(Connection conn, int filmId) throws SQLException {
        String sql = "SELECT film_id, title, language_id, rental_duration, rental_rate, replacement_cost FROM film WHERE film_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, filmId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Film(
                            rs.getInt("film_id"),
                            rs.getString("title"),
                            rs.getInt("language_id"),
                            rs.getInt("rental_duration"),
                            rs.getDouble("rental_rate"),
                            rs.getDouble("replacement_cost")
                    );
                }
            }
        }

        return null;
    }

    public boolean update(Connection conn, Film film) throws SQLException {
        String sql = "UPDATE film SET title = ?, language_id = ?, rental_duration = ?, rental_rate = ?, replacement_cost = ? WHERE film_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, film.getTitle());
            ps.setInt(2, film.getLanguageId());
            ps.setInt(3, film.getRentalDuration());
            ps.setDouble(4, film.getRentalRate());
            ps.setDouble(5, film.getReplacementCost());
            ps.setInt(6, film.getFilmId());

            return ps.executeUpdate() > 0;
        }
    }

    public List<String> listActorNames(Connection conn, int filmId) throws SQLException {
        String sql = "SELECT a.first_name, a.last_name FROM actor a "
                + "JOIN film_actor fa ON fa.actor_id = a.actor_id "
                + "WHERE fa.film_id = ? ORDER BY a.last_name, a.first_name";

        List<String> atores = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, filmId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    atores.add(rs.getString("first_name") + " " + rs.getString("last_name"));
                }
            }
        }

        return atores;
    }
}
