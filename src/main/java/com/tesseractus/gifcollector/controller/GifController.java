package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifDto;
import com.tesseractus.gifcollector.dto.TagRequestDto;
import com.tesseractus.gifcollector.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gif")
public class GifController {
    private GifService gifService;

    @PutMapping
    public ResponseEntity put(Principal principal, @RequestBody GifDto gifDto) {
        gifService.save(principal, gifDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tag")
    public ResponseEntity putTag(@RequestBody TagRequestDto tagRequestDto) {
        gifService.tagGif(tagRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<GifDto> findAll() {
        return gifService.findAll();
    }
}
