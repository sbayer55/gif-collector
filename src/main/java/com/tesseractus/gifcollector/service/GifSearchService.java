package com.tesseractus.gifcollector.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesseractus.gifcollector.config.GiphyConfig;
import com.tesseractus.gifcollector.dto.GifSearchResponseDTO;
import com.tesseractus.gifcollector.dto.GiphySearchResponseDTO;
import com.tesseractus.gifcollector.feign.GiphyFeign;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GifSearchService {
    private GiphyFeign giphyFeign;
    private GiphyConfig giphyConfig;
    private ModelMapper modelMapper;

    public GifSearchResponseDTO findGif(String q, Integer limit, Integer offset) {
        log.trace("Calling GiphyFeign.findGif");
        GiphySearchResponseDTO giphySearchResponse = giphyFeign.findGif(giphyConfig.getApiToken(), q, limit, offset, giphyConfig.getSearchRating(), null, null);
        return modelMapper.map(giphySearchResponse, GifSearchResponseDTO.class);
    }
}
