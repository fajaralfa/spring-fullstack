package com.fajaralfa.bookrent.loanbook;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_book_items")
public class LoanBookItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "loan_book_id")
    private Integer loanBookId;

    public LoanBookItem() {
    }

    public LoanBookItem(Integer id, Integer bookId, Integer loanBookId) {
        this.id = id;
        this.bookId = bookId;
        this.loanBookId = loanBookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getLoanBookId() {
        return loanBookId;
    }

    public void setLoanBookId(Integer loanBookId) {
        this.loanBookId = loanBookId;
    }
}
