package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.config.GiphyConfig;
import com.tesseractus.gifcollector.dto.GifSearchResponseDto;
import com.tesseractus.gifcollector.dto.GiphySearchResponseDto;
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

    public GifSearchResponseDto findGif(String q, Integer limit, Integer offset) {
        log.trace("Calling GiphyFeign.findGif");
        GiphySearchResponseDto giphySearchResponse = giphyFeign.findGif(giphyConfig.getApiToken(), q, limit, offset, giphyConfig.getSearchRating(), null, null);
        GifSearchResponseDto response = modelMapper.map(giphySearchResponse, GifSearchResponseDto.class);

        log.debug("Found {} gifs", giphySearchResponse.getPagination().getTotalCount());
        return response;
    }
}
