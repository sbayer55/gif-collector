package com.tesseractus.gifcollector.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tesseractus.gifcollector.dao.GifTag;
import com.tesseractus.gifcollector.jackson.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class GifDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = LocalDateTimeDeserializer.GIPHY_DATETIME_FORMAT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime importDatetime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = LocalDateTimeDeserializer.GIPHY_DATETIME_FORMAT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime trendingDatetime;
    private String title;
    private GifVersionDto fixedHeight;
    private GifVersionDto fixedHeightSmallStill;
    private GifVersionDto original;
    private Integer gifId;

    private Set<GifTagDto> tags;
}
