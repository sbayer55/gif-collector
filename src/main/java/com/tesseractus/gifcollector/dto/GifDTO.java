package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GifDTO {
    private String importDatetime;
    private String trendingDatetime;
    private String title;
    private GifVersionDTO fixedHeight;
    private GifVersionDTO fixedHeightSmallStill;
    private GifVersionDTO fixedWidth;
    private GifVersionDTO fixedWidthSmallStill;
    private GifVersionDTO original;
}
