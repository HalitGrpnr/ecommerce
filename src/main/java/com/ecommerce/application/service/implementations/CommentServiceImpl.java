package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.Comment;
import com.ecommerce.application.repository.CommentRepository;
import com.ecommerce.application.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public ResponseEntity<Comment> get(Long id) {
        return new ResponseEntity<>(commentRepository.findById(id).orElse(new Comment()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Comment> add(Comment comment) {
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Comment> update(Comment comment) {
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<List<Comment>>getAll() {
        return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
    }
}
