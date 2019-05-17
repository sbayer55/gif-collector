package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.model.TesseractusUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public TesseractusUserDetails get(@AuthenticationPrincipal final TesseractusUserDetails userDetails) {
        return userDetails;
    }
}
