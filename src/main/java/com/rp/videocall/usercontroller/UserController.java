package com.rp.videocall.usercontroller;

import com.rp.videocall.model.User;
import com.rp.videocall.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping
    public void register(User user) {
        userService.register(user);
    }

    @PostMapping("/login")
    public User login(User user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public void logout(String email) {
        userService.logout(email);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
