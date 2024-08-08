package com.fajaralfa.bookrent.loanbook;

import com.fajaralfa.bookrent.book.Book;
import com.fajaralfa.bookrent.student.Student;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loan_books")
public class LoanBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

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

    public LoanBook(Integer id, String borrowTime, String returnTime) {
        this.id = id;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Integer studentId) {
//        this.studentId = studentId;
//    }

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
