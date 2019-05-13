package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.UserDTO;
import com.tesseractus.gifcollector.service.SignupService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SignupController {
    private SignupService signupService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signup(@RequestBody UserDTO userDTO) {
        try {
            signupService.addUser(userDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

