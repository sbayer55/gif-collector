package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GifSearchResponseDTO;
import com.tesseractus.gifcollector.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class GifController {

    private GifService gifService;

    @RequestMapping("/gif")
    public GifSearchResponseDTO findGif(@RequestParam String q,
                                        @RequestParam(required = false) Integer limit,
                                        @RequestParam(required = false) Integer offset) {
        return gifService.findGif(q, limit, offset);
    }
}
