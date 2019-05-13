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

@Slf4j
@Service
@AllArgsConstructor
public class TesseractusUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        log.debug("User detail request for username: \"{}\"", username);
        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(RuntimeException::new);

            return new TesseractusUserDetails(user.getUsername(),
                    user.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        } catch (Exception e) {
            log.warn("Unsuccessful attempt to authenticate for username {}", username, e);
            throw new UsernameNotFoundException("User " + username + " was not found in the database", e);
        }
    }
}
