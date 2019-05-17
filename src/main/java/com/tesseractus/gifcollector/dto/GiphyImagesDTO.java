package com.tesseractus.gifcollector.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GiphyImagesDto {
    private GiphyFixedDto fixedHeight;
    private GiphyStillDto fixedHeightStill;
    private GiphyFixedWebpDto fixedHeightDownsampled;
    private GiphyFixedDto fixedWidth;
    private GiphyStillDto fixedWidthStill;
    private GiphyFixedWebpDto fixedWidthDownsampled;
    private GiphyFixedDto fixedHeightSmall;
    private GiphyStillDto fixedHeightSmallStill;
    private GiphyFixedDto fixedWidthSmall;
    private GiphyStillDto fixedWidthSmallStill;
    private GiphyMP4Dto downsized;
    private GiphyStillDto downsizedStill;
    private GiphyMP4Dto downsizedLarge;
    private GiphyMP4Dto downsizedMedium;
    private GiphyMP4Dto downsizedSmall;
    private GiphyOriginalDto original;
    private GiphyStillDto originalStill;
    private GiphyMP4Dto looping;
    private GiphyMP4Dto preview;
    private GiphyStillDto previewGif;
}
