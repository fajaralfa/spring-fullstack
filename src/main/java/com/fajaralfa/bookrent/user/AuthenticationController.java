package com.fajaralfa.bookrent.user;

import com.fajaralfa.bookrent.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = authenticationService.authenticate(request);
        String jwt = jwtService.generateToken(user);
        LoginResponse response = new LoginResponse(jwt, jwtService.getExpirationTime());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody RegisterRequest request) {
        User user = authenticationService.signup(request);

        UserResponse response = new UserResponse(
                user.getId(), user.getName(), user.getUsername()
        );
        return ResponseEntity.ok(response);
    }

}
