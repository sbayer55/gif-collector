package com.tesseractus.gifcollector.config;

import com.tesseractus.gifcollector.dao.User;
import com.tesseractus.gifcollector.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Collectors;

@Slf4j
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(GiphyStillDTO.class, GifVersionDTO.class)
                .addMapping(GiphyStillDTO::getHeight, GifVersionDTO::setHeight)
                .addMapping(GiphyStillDTO::getWidth, GifVersionDTO::setWidth)
                .addMapping(GiphyStillDTO::getUrl, GifVersionDTO::setUrl);

        modelMapper.createTypeMap(GiphyDataDTO.class, GifDTO.class)
                .addMapping(data -> data.getImages().getFixedHeight(), GifDTO::setFixedHeight)
                .addMapping(data -> data.getImages().getFixedHeightSmallStill(), GifDTO::setFixedHeightSmallStill)
                .addMapping(data -> data.getImages().getOriginal(), GifDTO::setOriginal);

        modelMapper.createTypeMap(GiphySearchResponseDTO.class, GifSearchResponseDTO.class)
                .addMapping(GiphySearchResponseDTO::getData, GifSearchResponseDTO::setGifs)
                .addMapping(res -> res.getPagination().getTotalCount(), GifSearchResponseDTO::setTotalCount)
                .addMapping(res -> res.getPagination().getOffset(), GifSearchResponseDTO::setOffset)
                .addMapping(res -> res.getPagination().getCount(), GifSearchResponseDTO::setCount);

        return modelMapper;
    }
}
