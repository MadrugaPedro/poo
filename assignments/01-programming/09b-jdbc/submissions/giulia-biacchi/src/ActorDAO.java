import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActorDAO {

    public boolean deleteById(Connection conn, int actorId) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM film_actor WHERE actor_id = ?")) {
            ps.setInt(1, actorId);
            ps.executeUpdate();
        }

        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM actor WHERE actor_id = ?")) {
            ps.setInt(1, actorId);
            return ps.executeUpdate() > 0;
        }
    }
}
