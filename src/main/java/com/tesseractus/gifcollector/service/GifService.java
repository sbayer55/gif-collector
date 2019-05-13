package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.dao.Gif;
import com.tesseractus.gifcollector.dto.GifDTO;
import com.tesseractus.gifcollector.repository.GifRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GifService {
    private ModelMapper modelMapper;
    private GifRepository gifRepository;

    public void save(GifDTO gifDTO) {
        Gif gif = modelMapper.map(gifDTO, Gif.class);
        gifRepository.save(gif);
    }
}
