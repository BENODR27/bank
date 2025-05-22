package com.beno.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beno.bank.dto.UserDto;
import com.beno.bank.service.AuthenticationService;
import com.beno.bank.utils.CustomResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomResponse> login(@RequestBody UserDto request) {
        return ResponseEntity.ok(CustomResponse.builder()
                .message("Login successful")
                .data(authenticationService.login(request))
                .status("success")
                .build());
    }

}
