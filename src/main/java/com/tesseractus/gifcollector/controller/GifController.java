package com.tesseractus.gifcollector.controller;

import com.tesseractus.gifcollector.dto.GiphySearchResponseDTO;
import com.tesseractus.gifcollector.feign.GiphyFeign;
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
    public GiphySearchResponseDTO findGif(@RequestParam String q) {
        return gifService.findGif(q);
    }
}
