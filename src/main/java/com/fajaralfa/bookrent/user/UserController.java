package com.fajaralfa.bookrent.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public UserController(AuthenticationService authenticationService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @GetMapping("/current")
    public ResponseEntity<UserResponse> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        UserResponse response = new UserResponse(user.getId(), user.getName(), user.getUsername());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<UserResponse> signup(@RequestBody RegisterRequest request) {
        User user = authenticationService.signup(request);

        UserResponse response = new UserResponse(
                user.getId(), user.getName(), user.getUsername()
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{username}")
    @Transactional
    public void delete(@PathVariable("username") String username) {
        userRepository.deleteByUsername(username);
    }
}
