package com.fajaralfa.bookrent.loanbook;

import com.fajaralfa.bookrent.student.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class LoanBookService {
    private LoanBookRepository loanBookRepository;
    private LoanBookItemRepository loanBookItemRepository;
    private StudentRepository studentRepository;

    public LoanBookService(LoanBookRepository loanBookRepository, LoanBookItemRepository loanBookItemRepository, StudentRepository studentRepository) {
        this.loanBookRepository = loanBookRepository;
        this.loanBookItemRepository = loanBookItemRepository;
        this.studentRepository = studentRepository;
    }

    public LoanBook store(LoanBookRequest request) {
        var loanBook = new LoanBook();
        var student = studentRepository.findById(request.studentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not found"));
        loanBook.setStudent(student);
        loanBook.setBorrowTime(request.borrowTime());
        loanBook.setExpectedReturnTime(request.expectedReturnTime());

        loanBook = loanBookRepository.save(loanBook);

        ArrayList<LoanBookItem> loanBookItems = new ArrayList<LoanBookItem>();
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
