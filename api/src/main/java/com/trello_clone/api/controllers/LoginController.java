package com.trello_clone.api.controllers;

import com.trello_clone.api.entity.Login;
import com.trello_clone.api.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class LoginController {
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> credentials(@RequestBody Login credentials) {
        if (credentials.getUsername().trim().isEmpty() || credentials.getPassword().trim().isEmpty()) {
            return new ResponseEntity<>(new ApiResponse<>("Bad Credentials", LocalDateTime.now(), 400), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(new ApiResponse<>("Accepted", LocalDateTime.now(), 200), HttpStatus.OK);
        }
    }
}
