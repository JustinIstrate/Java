package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() {
        connection = DatabaseConnect.getInstance().getConnection();
    }

    public void addAuthor(String name) {
        String sql = "INSERT INTO authors (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
