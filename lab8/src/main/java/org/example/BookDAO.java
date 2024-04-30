package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class BookDAO {
    private Connection connection;

    public BookDAO() throws SQLException {
        connection = DatabaseConnect.getConnection();
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, publication_date, language, num_pages) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getTitle());
            statement.setDate(2, new java.sql.Date(book.getPublicationDate().getTime()));
            statement.setString(3, book.getLanguage());
            statement.setInt(4, book.getNumberOfPages());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                book.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addBookAuthorRelation(int bookId, int authorId) {
        String sql = "INSERT INTO book_authors (book_id, author_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookId);
            statement.setInt(2, authorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modifyBook(Book book) {
        String sql = "UPDATE books SET title = ?, publication_date = ?, language = ?, num_pages = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setDate(2, new java.sql.Date(book.getPublicationDate().getTime()));
            statement.setString(3, book.getLanguage());
            statement.setInt(4, book.getNumberOfPages());
            statement.setInt(5, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
