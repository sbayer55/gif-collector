package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.dao.User;
import com.tesseractus.gifcollector.model.TesseractusUserDetails;
import com.tesseractus.gifcollector.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@AllArgsConstructor
public class TesseractusUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        try {
            log.info("User detail request for \"{}\"", username);
            User user = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                    .filter(userEntity -> userEntity.getUsername().equals(username))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
            TesseractusUserDetails userDetails = new TesseractusUserDetails("",
                    user.getUsername(),
                    true,
                    true,
                    true,
                    true,
                    Collections.singleton(new SimpleGrantedAuthority("USER")));
            log.info("User details: {}", userDetails);
            return userDetails;
        } catch (Exception e) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database", e);
        }
    }
}
