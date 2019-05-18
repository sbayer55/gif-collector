package com.tesseractus.gifcollector.dao;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "gif_tag_link")
public class GifTagLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gifLinkId;

    @ManyToOne
    @JoinColumn(name = "gif_id")
    private Gif gif;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private GifTag tag;
}
