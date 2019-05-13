package com.tesseractus.gifcollector.repository;

import com.tesseractus.gifcollector.dao.Gif;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GifRepository extends CrudRepository<Gif, Integer> {
    @Query("SELECT g FROM gif g WHERE g.ownerId = :ownerId")
    List<Gif> findByOwnerId(@Param("ownerId") Integer ownerId);
}
