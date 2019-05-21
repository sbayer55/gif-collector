package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifDto;
import com.tesseractus.gifcollector.dto.TagRequestDto;
import com.tesseractus.gifcollector.model.TesseractusUserDetails;
import com.tesseractus.gifcollector.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gif")
public class GifController {
    private GifService gifService;

    @PutMapping
    public ResponseEntity put(@AuthenticationPrincipal final TesseractusUserDetails userDetails,
                              @RequestBody GifDto gifDto) {
        gifService.save(userDetails, gifDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tag")
    public ResponseEntity putTag(@RequestBody TagRequestDto tagRequestDto) {
        gifService.tagGif(tagRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<GifDto> findAll(@AuthenticationPrincipal final TesseractusUserDetails userDetails) {
        return gifService.findByPrincipal(userDetails);
    }
}
