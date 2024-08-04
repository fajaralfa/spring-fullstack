package com.fajaralfa.bookrent.loanbook;

public record LoanBookRequest(
        Integer studentId,
        Integer[] bookIds,
        String borrowTime,
        String expectedReturnTime
) {
}
