package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiphyAnalyticsDto {
    private GiphyUrlDTO onload;
    private GiphyUrlDTO onclick;
    private GiphyUrlDTO onsent;
}
