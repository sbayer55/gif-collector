package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifSearchResponseDto;
import com.tesseractus.gifcollector.service.GifSearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gif-search")
public class GifSearchController {

    private GifSearchService gifSearchService;

    @GetMapping
    public GifSearchResponseDto findGif(@RequestParam String q,
                                        @RequestParam(required = false) Integer limit,
                                        @RequestParam(required = false) Integer offset) {
        return gifSearchService.findGif(q, limit, offset);
    }
}
