package com.tesseractus.gifcollector.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tesseractus.gifcollector.jackson.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private GifVersionDTO fixedHeight;
    private GifVersionDTO fixedHeightSmallStill;
    private GifVersionDTO original;
    private Integer id;

}
