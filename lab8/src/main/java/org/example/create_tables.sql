CREATE TABLE IF NOT EXISTS books (
                                     id SERIAL PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
    publication_date DATE,
    language VARCHAR(50),
    num_pages INT
    );

CREATE TABLE IF NOT EXISTS authors (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS book_authors (
                                            book_id INT,
                                            author_id INT,
                                            FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id),
    PRIMARY KEY (book_id, author_id)
    );
