package com.tesseractus.gifcollector.repository;

import com.tesseractus.gifcollector.dao.GifTag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GifTagRepository extends CrudRepository<GifTag, Integer> {
    @Query("FROM gif_tag WHERE name = :name")
    Optional<GifTag> findByName(@Param("name") String name);
}
