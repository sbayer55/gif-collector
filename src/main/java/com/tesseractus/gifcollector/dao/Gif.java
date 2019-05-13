package com.tesseractus.gifcollector.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "gif")
public class Gif {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime importDatetime;
    private LocalDateTime trendingDatetime;
    private String title;
    private String fixedHeightUrl;
    private Integer fixedHeightWidth;
    private Integer fixedHeightHeight;
    private String fixedHeightSmallStillUrl;
    private Integer fixedHeightSmallStillWidth;
    private Integer fixedHeightSmallStillHeight;
    private String originalUrl;
    private Integer originalWidth;
    private Integer originalHeight;
}
