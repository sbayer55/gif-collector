package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GifSearchResponseDTO {
    private List<GifDTO> gifs;
    private Integer totalCount;
    private Integer count;
    private Integer offset;
}
