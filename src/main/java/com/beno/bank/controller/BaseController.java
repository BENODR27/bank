package com.beno.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beno.bank.utils.CustomResponse;

@RestController
@RequestMapping("/")
public class BaseController {
    @RequestMapping
    public ResponseEntity<CustomResponse> index() {
        return ResponseEntity.ok(CustomResponse.builder()
                .message("Hello World!")
                .status("200")
                .data(null)
                .error(null)
                .build());
    }

}
