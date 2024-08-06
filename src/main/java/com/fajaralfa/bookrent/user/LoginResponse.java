package com.fajaralfa.bookrent.user;

public record LoginResponse(
        String token,
        Long expiredAt
) {
}
