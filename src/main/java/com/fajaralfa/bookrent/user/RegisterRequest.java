package com.fajaralfa.bookrent.user;

public record RegisterRequest(
        String name,
        String username,
        String password
) {
}
