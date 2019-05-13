package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifSearchResponseDTO;
import com.tesseractus.gifcollector.service.GifSearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class GifSearchController {

    private GifSearchService gifSearchService;

    @RequestMapping("/gif-search")
    public GifSearchResponseDTO findGif(@RequestParam String q,
                                        @RequestParam(required = false) Integer limit,
                                        @RequestParam(required = false) Integer offset) {
        return gifSearchService.findGif(q, limit, offset);
    }
}
