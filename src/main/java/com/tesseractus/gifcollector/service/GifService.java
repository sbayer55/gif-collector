package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.dao.Gif;
import com.tesseractus.gifcollector.dao.GifTag;
import com.tesseractus.gifcollector.dao.User;
import com.tesseractus.gifcollector.dto.GifDto;
import com.tesseractus.gifcollector.dto.TagRequestDto;
import com.tesseractus.gifcollector.repository.GifRepository;
import com.tesseractus.gifcollector.repository.GifTagRepository;
import com.tesseractus.gifcollector.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class GifService {
    private ModelMapper modelMapper;
    private GifRepository gifRepository;
    private GifTagRepository gifTagRepository;
    private UserRepository userRepository;

    public void save(Principal principal, GifDto gifDTO) {
        Gif gif = modelMapper.map(gifDTO, Gif.class);
        try {
            User user = userRepository.findByUsername(principal.getName())
                    .orElseThrow(() -> new UsernameNotFoundException("User " + principal.getName() + " not found"));
            gif.setOwnerId(user.getId());
        } catch (Exception e) {
            log.warn("Unable to coerce user from security context");
        }
        gifRepository.save(gif);
    }

    public void tagGif(TagRequestDto tagRequestDto) {
        GifTag tag = new GifTag();
        tag.setName(tagRequestDto.getName());
        tag.setGifId(tagRequestDto.getGifId());
        gifTagRepository.save(tag);
    }

    public List<GifDto> findAll() {
        List<Gif> gifs = new ArrayList<>();

        gifRepository.findAll().forEach(gifs::add);

        log.info("Found {} gifs!", gifs.size());
        List<GifDto> gifDtos = gifs.stream()
                .map(gif -> modelMapper.map(gif, GifDto.class))
                .collect(Collectors.toList());
        return gifDtos;
    }
}
