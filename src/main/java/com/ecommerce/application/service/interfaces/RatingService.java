package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.entity.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingService {

    ResponseEntity<Rating> get(Long id);
    ResponseEntity<Rating> add(Rating Rating);
    ResponseEntity<Rating> update(Rating Rating);
    void delete(Long id);
    ResponseEntity<List<Rating>> getAll();



}
