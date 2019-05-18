package com.tesseractus.gifcollector.feign;

import com.tesseractus.gifcollector.dto.GiphySearchResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphy", url = "api.giphy.com")
public interface GiphyFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/gifs/search")
    GiphySearchResponseDto findGif(
            @RequestParam String api_key,
            @RequestParam String q,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) String rating,
            @RequestParam(required = false) String lang,
            @RequestParam(required = false) String fmt);
}
