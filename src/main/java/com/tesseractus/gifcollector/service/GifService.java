package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.config.GiphyConfig;
import com.tesseractus.gifcollector.dto.GiphySearchResponseDTO;
import com.tesseractus.gifcollector.feign.GiphyFeign;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GifService {
    private GiphyFeign giphyFeign;
    private GiphyConfig giphyConfig;

    public GiphySearchResponseDTO findGif(String q) {
        log.trace("Calling GiphyFeign.findGif");
        return giphyFeign.findGif(giphyConfig.getApiToken(), q, null, null, giphyConfig.getSearchRating(), null, null);
    }
}
