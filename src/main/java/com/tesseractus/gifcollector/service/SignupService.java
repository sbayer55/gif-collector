package com.tesseractus.gifcollector.service;

import com.tesseractus.gifcollector.dao.User;
import com.tesseractus.gifcollector.dto.CreateUserDto;
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

    public User addUser(CreateUserDto createUserDto) {
        userRepository.findByUsername(createUserDto.getUsername())
                .ifPresent(user -> {
                    log.warn("Attempt to create duplicate user {}", user.getUsername());
                    throw new DuplicateKeyException(user.getUsername());
                });
        User user = new User(null,
                createUserDto.getUsername(),
                passwordEncoder.encode(createUserDto.getPassword()),
                createUserDto.getFirstName(),
                createUserDto.getLastName());
        return userRepository.save(user);
    }
}
