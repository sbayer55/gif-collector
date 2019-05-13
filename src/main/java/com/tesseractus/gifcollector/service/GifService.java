package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.dao.Gif;
import com.tesseractus.gifcollector.dao.User;
import com.tesseractus.gifcollector.dto.GifDTO;
import com.tesseractus.gifcollector.model.TesseractusUserDetails;
import com.tesseractus.gifcollector.repository.GifRepository;
import com.tesseractus.gifcollector.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GifService {
    private ModelMapper modelMapper;
    private GifRepository gifRepository;
    private UserRepository userRepository;

    public void save(GifDTO gifDTO) {
        Gif gif = modelMapper.map(gifDTO, Gif.class);
        try {
            TesseractusUserDetails userDetails = (TesseractusUserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            User user = userRepository.findByUsername(userDetails.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("User " + userDetails.getUsername() + " not found"));
            gif.setOwnerId(user.getId());
        } catch (Exception e) {
            log.warn("Unable to coerce user from security context");
        }
        gifRepository.save(gif);
    }
}
