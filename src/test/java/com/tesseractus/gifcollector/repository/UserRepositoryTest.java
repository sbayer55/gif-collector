package com.tesseractus.gifcollector.repository;

import com.tesseractus.gifcollector.dao.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void createUser() {
        String stringValue = "TestValue";
        User user = new User();
        user.setUsername(stringValue);
        user.setFirstName(stringValue);
        user.setLastName(stringValue);

        user = userRepository.save(user);

        Optional<User> optionalUser = userRepository.findById(user.getId());

        assertThat(optionalUser).isNotEmpty();
        assertThat(optionalUser.get().getFirstName()).isEqualTo(stringValue);
        assertThat(optionalUser.get().getLastName()).isEqualTo(stringValue);
    }
}