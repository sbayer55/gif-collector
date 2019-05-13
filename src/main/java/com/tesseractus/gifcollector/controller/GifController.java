package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifDTO;
import com.tesseractus.gifcollector.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class GifController {
    private GifService gifService;

    @RequestMapping(value = "/gif", method = RequestMethod.PUT)
    public ResponseEntity put(@RequestBody GifDTO gifDTO) {
        gifService.save(gifDTO);
        return ResponseEntity.ok().build();
    }
}
