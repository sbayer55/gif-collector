package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.CreateUserDto;
import com.tesseractus.gifcollector.service.SignupService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
public class SignupController {
    private SignupService signupService;

    @PostMapping(value = "/signup")
    public ResponseEntity signup(@RequestBody CreateUserDto createUserDto) {
        try {
            signupService.addUser(createUserDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

