package mavsreclaim;

import java.sql.*;
import java.nio.charset.StandardCharsets;

public class Db {
    private static final String URL = "jdbc:sqlite:mavsreclaim.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void init() {
        try (var in = Db.class.getResourceAsStream("/schema.sql")) {
            String sql = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            try (Connection c = connect(); Statement s = c.createStatement()) {
                for (String stmt : sql.split(";")) {
                    if (!stmt.isBlank()) s.execute(stmt);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("schema init failed", e);
        }
    }
}
