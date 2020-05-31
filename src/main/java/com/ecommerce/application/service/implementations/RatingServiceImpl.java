package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.Rating;
import com.ecommerce.application.repository.RatingRepository;
import com.ecommerce.application.service.interfaces.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public ResponseEntity<Rating> get(Long id) {
        return new ResponseEntity<>(ratingRepository.findById(id).orElse(new Rating()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rating> add(Rating rating) {
        return new ResponseEntity<>(ratingRepository.save(rating), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Rating> update(Rating rating) {
        return new ResponseEntity<>(ratingRepository.save(rating), HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<List<Rating>> getAll() {
        return new ResponseEntity<>(ratingRepository.findAll(), HttpStatus.OK);
    }
}
