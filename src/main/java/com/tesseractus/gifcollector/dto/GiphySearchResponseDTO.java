package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GiphySearchResponseDTO {
    private List<GiphyDataDTO> data;
    private GiphyPaginationDTO pagination;
    private GiphyMetaDTO meta;
}
