package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.dao.User;
import com.tesseractus.gifcollector.dto.UserDTO;
import com.tesseractus.gifcollector.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class SignupService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User addUser(UserDTO userDTO) {
        userRepository.findByUsername(userDTO.getUsername())
                .ifPresent(user -> {
                    log.warn("Attempt to create duplicate user {}", user.getUsername());
                    throw new DuplicateKeyException(user.getUsername());
                });
        User user = new User(null,
                userDTO.getUsername(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getFirstName(),
                userDTO.getLastName());
        return userRepository.save(user);
    }
}
