package com.tesseractus.gifcollector.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Setter
public class GiphyDataDTO {
    private String type;
    private String id;
    private String slug;
    private String url;
    @JsonProperty("bitly_url")
    private String bitlyUrl;
    private String embedUrl;
    private String username;
    private String source;
    private String rating;
    private String contentUrl;
    private String sourceTld;
    private String sourcePostUrl;
    private Boolean isSticker;
    private String importDatetime;
    private String trendingDatetime;
    private GiphyImagesDTO images;
    private String title;
    private GiphyAnalyticsDto analytics;
}
