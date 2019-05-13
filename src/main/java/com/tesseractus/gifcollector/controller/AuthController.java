package com.tesseractus.gifcollector.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AuthController {
    @GetMapping("/auth")
    public ResponseEntity get() {
        return ResponseEntity.accepted().build();
    }
}
