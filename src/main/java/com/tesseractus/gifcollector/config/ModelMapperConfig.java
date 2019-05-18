package com.tesseractus.gifcollector.config;

import com.tesseractus.gifcollector.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(GiphyStillDto.class, GifVersionDto.class)
                .addMapping(GiphyStillDto::getHeight, GifVersionDto::setHeight)
                .addMapping(GiphyStillDto::getWidth, GifVersionDto::setWidth)
                .addMapping(GiphyStillDto::getUrl, GifVersionDto::setUrl);

        modelMapper.createTypeMap(GiphyDataDto.class, GifDto.class)
                .addMapping(data -> data.getImages().getFixedHeight(), GifDto::setFixedHeight)
                .addMapping(data -> data.getImages().getFixedHeightSmallStill(), GifDto::setFixedHeightSmallStill)
                .addMapping(data -> data.getImages().getOriginal(), GifDto::setOriginal)
                .addMapping(data -> null, GifDto::setId);

        modelMapper.createTypeMap(GiphySearchResponseDto.class, GifSearchResponseDto.class)
                .addMapping(GiphySearchResponseDto::getData, GifSearchResponseDto::setGifs)
                .addMapping(res -> res.getPagination().getTotalCount(), GifSearchResponseDto::setTotalCount)
                .addMapping(res -> res.getPagination().getOffset(), GifSearchResponseDto::setOffset)
                .addMapping(res -> res.getPagination().getCount(), GifSearchResponseDto::setCount);

        return modelMapper;
    }
}
