package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiphyStillDTO extends GiphyUrlDTO {
    private String width;
    private String height;
    private String size;
}
