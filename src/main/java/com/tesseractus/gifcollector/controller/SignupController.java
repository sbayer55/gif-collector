package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.UserDTO;
import com.tesseractus.gifcollector.service.SignupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class SignupController {
    private SignupService signupService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signup(@RequestBody UserDTO userDTO) {
        signupService.addUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

