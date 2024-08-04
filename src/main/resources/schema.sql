CREATE TABLE IF NOT EXISTS users (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS students (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nis VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    description VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS loan_books (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_id INTEGER NOT NULL,
    borrow_time TIMESTAMP NOT NULL,
    expected_return_time TIMESTAMP NOT NULL,
    return_time TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE TABLE IF NOT EXISTS loan_book_items (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    book_id INTEGER NOT NULL,
    loan_book_id INTEGER NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (loan_book_id) REFERENCES loan_books(id) ON DELETE CASCADE
);