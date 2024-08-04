package com.fajaralfa.bookrent.loanbook;

import com.fajaralfa.bookrent.book.Book;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loan_books")
public class LoanBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "borrow_time")
    private String borrowTime;

    @Column(name = "expected_return_time")
    private String expectedReturnTime;

    @Column(name = "return_time")
    private String returnTime;

    @ManyToMany
    @JoinTable(
            name = "loan_book_items",
            joinColumns = @JoinColumn(name = "loan_book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private List<Book> books;

    public LoanBook() {
    }

    public LoanBook(Integer id, Integer studentId, String borrowTime, String returnTime) {
        this.id = id;
        this.studentId = studentId;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getExpectedReturnTime() {
        return expectedReturnTime;
    }

    public void setExpectedReturnTime(String expectedReturnTime) {
        this.expectedReturnTime = expectedReturnTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
