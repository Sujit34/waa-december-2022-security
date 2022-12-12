package edu.miu.springdata1Assignment.controller;

import edu.miu.springdata1Assignment.dto.UserDto;
import edu.miu.springdata1Assignment.entity.User;
import edu.miu.springdata1Assignment.model.LoginRequest;
import edu.miu.springdata1Assignment.model.LoginResponse;
import edu.miu.springdata1Assignment.model.RefreshTokenRequest;
import edu.miu.springdata1Assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/uaa")
@RequiredArgsConstructor

public class UaaController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body("Registered New User Successfully");
    }
    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return userService.refreshToken(refreshTokenRequest);
    }
}
