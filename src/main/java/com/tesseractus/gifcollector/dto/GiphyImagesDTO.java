package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiphyImagesDTO {
    private GiphyFixedDTO fixedHeight;
    private GiphyStillDTO fixedHeightStill;
    private GiphyFixedWebpdDTO fixedHeightDownsampled;
    private GiphyFixedDTO fixedWidth;
    private GiphyStillDTO fixedWidthStill;
    private GiphyFixedWebpdDTO fixedWidthDownsampled;
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
