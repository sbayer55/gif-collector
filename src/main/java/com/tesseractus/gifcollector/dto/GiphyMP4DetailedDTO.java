package com.tesseractus.gifcollector.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GiphyMP4DetailedDTO extends GiphyMP4DTO {
    private String width;
    private String height;
}
