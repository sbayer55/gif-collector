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
import java.util.Optional;
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
            User user = userRepository.findByUsername(username)
                    .orElseThrow(RuntimeException::new);
            TesseractusUserDetails userDetails = new TesseractusUserDetails(user.getUsername(),
                    user.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
            log.info("User details: {}", userDetails);
            return userDetails;
        } catch (Exception e) {
            log.warn("Unsuccessful attempt to authenticate from {}", username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database", e);
        }
    }
}
