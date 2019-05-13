package com.tesseractus.gifcollector.repository;

import com.tesseractus.gifcollector.dao.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("FROM application_user WHERE username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
