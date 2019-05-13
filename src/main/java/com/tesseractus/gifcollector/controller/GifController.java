package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifDTO;
import com.tesseractus.gifcollector.dto.TagRequestDto;
import com.tesseractus.gifcollector.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/gif")
public class GifController {
    private GifService gifService;

    @PutMapping
    public ResponseEntity put(@RequestBody GifDTO gifDTO) {
        gifService.save(gifDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tag")
    public ResponseEntity putTag(@RequestBody TagRequestDto tagRequestDto) {
        gifService.tagGif(tagRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<GifDTO> findAll() {
        return gifService.findAll();
    }
}
