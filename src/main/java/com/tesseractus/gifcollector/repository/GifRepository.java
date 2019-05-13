package com.tesseractus.gifcollector.repository;

import com.tesseractus.gifcollector.dao.Gif;
import org.springframework.data.repository.CrudRepository;

public interface GifRepository extends CrudRepository<Gif, Integer> {
}
