package com.self.springweek_1.controller;

import com.self.springweek_1.Repository.CommentRepository;
import com.self.springweek_1.dto.CommentRequestDto;
import com.self.springweek_1.model.Comment;
import com.self.springweek_1.service.CommentService;
import com.self.springweek_1.utils.CommentSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

//    @GetMapping("/api/comments")
//    public List<Comment> getComment(){
//        return commentRepository.findAllByOrderByModifiedAtDesc();
//    }


    @GetMapping("/api/comment/{article_id}")
    public List<Comment> getComment(@PathVariable Long article_id){
        return commentRepository.findAll(CommentSpecs.withArticle_id(article_id));
    }


    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto){
        Comment comment = new Comment(commentRequestDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.update_comment(id, commentRequestDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}