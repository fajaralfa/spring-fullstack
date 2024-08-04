package com.fajaralfa.bookrent.loanbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface LoanBookItemRepository extends JpaRepository<LoanBookItem, Integer> {
    @Transactional
    void deleteAllByLoanBookId(Integer loanBookId);
}
