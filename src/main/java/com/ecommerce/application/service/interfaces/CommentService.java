package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    ResponseEntity<Comment> get(Long id);
    ResponseEntity<Comment> add(Comment Comment);
    ResponseEntity<Comment> update(Comment Comment);
    void delete(Long id);
    ResponseEntity<List<Comment>> getAll();
}
