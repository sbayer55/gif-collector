package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifSearchResponseDTO;
import com.tesseractus.gifcollector.service.GifSearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/gif-search")
public class GifSearchController {

    private GifSearchService gifSearchService;

    @GetMapping
    public GifSearchResponseDTO findGif(@RequestParam String q,
                                        @RequestParam(required = false) Integer limit,
                                        @RequestParam(required = false) Integer offset) {
        return gifSearchService.findGif(q, limit, offset);
    }
}
