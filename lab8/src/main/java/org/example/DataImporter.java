package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class DataImporter {
    private static final String file = "books.csv";
    public static void importData() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Extract data from CSV
                int bookID = Integer.parseInt(data[0]);
                String title = data[1];
                String[] authorNames = data[2].split("/");
                String language = data[6];
                int numPages = Integer.parseInt(data[7]);
                Date publicationDate = parseDate(data[10]);

                // Create Book object
                List<Author> authors = new ArrayList<>();
                for (String authorName : authorNames) {
                    Author author = new Author(0, authorName.trim());
                    authors.add(author);
                }
                Book book = new Book(bookID, title, publicationDate, language, numPages, authors);

                insertBookAndAuthors(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("M/d/yyyy").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void insertBookAndAuthors(Book book) {
        try {
            BookDAO bookDAO = new BookDAO();
            AuthorDAO authorDAO = new AuthorDAO();

            // Insert book
            bookDAO.addBook(book);

            // Retrieve the book ID after insertion
            int bookId = book.getId();

            // Insert authors and book_authors entries
            for (Author author : book.getAuthors()) {
                // Check if the author already exists in the database
                Author existingAuthor = authorDAO.getAuthorByName(author.getName());
                if (existingAuthor == null) {
                    // If the author doesn't exist, add them to the database
                    authorDAO.addAuthor(author.getName());
                    existingAuthor = authorDAO.getAuthorByName(author.getName());
                }

                // Insert book_author entry
                if (existingAuthor != null) {
                    bookDAO.addBookAuthorRelation(bookId, existingAuthor.getId());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
