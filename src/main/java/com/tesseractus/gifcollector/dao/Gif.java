package com.tesseractus.gifcollector.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "gif")
public class Gif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gifId;
    private Integer ownerId;
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

    @OneToMany(mappedBy = "gif")
    private Set<GifTagLink> tagLinks;
}
