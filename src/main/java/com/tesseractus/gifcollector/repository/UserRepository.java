package com.tesseractus.gifcollector.repository;

import com.tesseractus.gifcollector.dao.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
