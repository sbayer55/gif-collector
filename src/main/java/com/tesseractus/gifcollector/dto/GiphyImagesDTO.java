package com.tesseractus.gifcollector.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GiphyImagesDTO {
    private GiphyFixedDTO fixedHeight;
    private GiphyStillDTO fixedHeightStill;
    private GiphyFixedWebpDTO fixedHeightDownsampled;
    private GiphyFixedDTO fixedWidth;
    private GiphyStillDTO fixedWidthStill;
    private GiphyFixedWebpDTO fixedWidthDownsampled;
    private GiphyFixedDTO fixedHeightSmall;
    private GiphyStillDTO fixedHeightSmallStill;
    private GiphyFixedDTO fixedWidthSmall;
    private GiphyStillDTO fixedWidthSmallStill;
    private GiphyMP4DTO downsized;
    private GiphyStillDTO downsizedStill;
    private GiphyMP4DTO downsizedLarge;
    private GiphyMP4DTO downsizedMedium;
    private GiphyMP4DTO downsizedSmall;
    private GiphyOriginalDTO original;
    private GiphyStillDTO originalStill;
    private GiphyMP4DTO looping;
    private GiphyMP4DTO preview;
    private GiphyStillDTO previewGif;
}
