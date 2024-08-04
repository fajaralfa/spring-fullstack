package com.fajaralfa.bookrent.loanbook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoanBookService {
    private LoanBookRepository loanBookRepository;
    private LoanBookItemRepository loanBookItemRepository;

    public LoanBookService(LoanBookRepository loanBookRepository, LoanBookItemRepository loanBookItemRepository) {
        this.loanBookRepository = loanBookRepository;
        this.loanBookItemRepository = loanBookItemRepository;
    }

    public LoanBook store(LoanBookRequest request) {
        var loanBook = new LoanBook();
        loanBook.setStudentId(request.studentId());
        loanBook.setBorrowTime(request.borrowTime());
        loanBook.setExpectedReturnTime(request.expectedReturnTime());

        loanBook = loanBookRepository.save(loanBook);

        ArrayList<LoanBookItem> loanBookItems = new ArrayList();
        for (Integer bookId : request.bookIds()) {
            var item = new LoanBookItem();
            item.setBookId(bookId);
            item.setLoanBookId(loanBook.getId());

            loanBookItems.add(item);
        }

        loanBookItemRepository.saveAll(loanBookItems);

        return loanBook;
    }
}
