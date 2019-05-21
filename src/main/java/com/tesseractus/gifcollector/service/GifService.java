package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.dao.Gif;
import com.tesseractus.gifcollector.dao.GifTag;
import com.tesseractus.gifcollector.dao.GifTagLink;
import com.tesseractus.gifcollector.dto.GifDto;
import com.tesseractus.gifcollector.dto.TagRequestDto;
import com.tesseractus.gifcollector.dto.UserDto;
import com.tesseractus.gifcollector.exception.GifNotFoundException;
import com.tesseractus.gifcollector.model.TesseractusUserDetails;
import com.tesseractus.gifcollector.repository.GifRepository;
import com.tesseractus.gifcollector.repository.GifTagLinkRepository;
import com.tesseractus.gifcollector.repository.GifTagRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class GifService {
    private ModelMapper modelMapper;
    private GifRepository gifRepository;
    private GifTagRepository gifTagRepository;
    private GifTagLinkRepository gifTagLinkRepository;
    private UserService userService;

    public void save(TesseractusUserDetails userDetails, GifDto gifDto) {
        Gif gif = modelMapper.map(gifDto, Gif.class);
        try {
            UserDto userDto = userService.getUser(userDetails.getUsername());
            gif.setOwnerId(userDto.getId());
        } catch (Exception e) {
            log.warn("Unable to coerce user from security context");
        }
        gifRepository.save(gif);
    }

    public void tagGif(TagRequestDto tagRequestDto) {
        Gif gif = gifRepository.findById(tagRequestDto.getGifId())
                .orElseThrow(() -> new GifNotFoundException(tagRequestDto.getGifId()));
        GifTag gifTag = gifTagRepository.findByName(tagRequestDto.getName())
                .orElseGet(() -> gifTagRepository.save(GifTag.builder()
                        .name(tagRequestDto.getName())
                        .build()));
        GifTagLink gifTagLink = GifTagLink.builder()
                .gif(gif)
                .tag(gifTag)
                .build();

        gifTagLinkRepository.save(gifTagLink);
    }

    public List<GifDto> findByPrincipal(TesseractusUserDetails userDetails) {
        UserDto userDto = userService.getUser(userDetails.getUsername());
        return gifRepository.findByOwnerId(userDto.getId()).stream()
                .map(gif -> modelMapper.map(gif, GifDto.class))
                .collect(Collectors.toList());
    }
}
