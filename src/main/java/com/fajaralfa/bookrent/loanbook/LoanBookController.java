package com.fajaralfa.bookrent.loanbook;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookloans")
public class LoanBookController {
    private LoanBookRepository loanBookRepository;
    private LoanBookItemRepository loanBookItemRepository;
    private LoanBookService loanBookService;

    public LoanBookController(
            LoanBookRepository loanBookRepository,
            LoanBookItemRepository loanBookItemRepository,
            LoanBookService loanBookService
    ) {
        this.loanBookRepository = loanBookRepository;
        this.loanBookItemRepository = loanBookItemRepository;
        this.loanBookService = loanBookService;
    }

    @GetMapping
    public List<LoanBook> index() {
        return loanBookRepository.findAll();
    }

    @PostMapping
    public Integer store(@RequestBody LoanBookRequest request) {
        return loanBookService.store(request).getId();
    }

    @GetMapping("/{id}")
    public Optional<LoanBook> get(@PathVariable("id") Integer id) {
        return loanBookRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        loanBookItemRepository.deleteAllByLoanBookId(id);
        loanBookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void returned(@RequestBody BookReturnRequest request, @PathVariable("id") Integer id) {
        loanBookRepository.findById(id).ifPresent(loanBook -> {
            loanBook.setReturnTime(request.returnTime());
            loanBookRepository.save(loanBook);
        });

    }
}
