package com.fajaralfa.bookrent.user;

public record LoginRequest(
        String username, String password
) {
}
