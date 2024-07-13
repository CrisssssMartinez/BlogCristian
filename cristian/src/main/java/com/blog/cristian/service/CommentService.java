package com.blog.cristian.services;

import com.blog.cristian.dto.CommentDTO;
import com.blog.cristian.entities.Comment;
import com.blog.cristian.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setUser(commentDTO.getUser());
        comment.setMessage(commentDTO.getMessage());
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
