package com.tesseractus.gifcollector.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiphyPaginationDTO {
    private Integer totalCount;
    private Integer count;
    private Integer offset;
}
