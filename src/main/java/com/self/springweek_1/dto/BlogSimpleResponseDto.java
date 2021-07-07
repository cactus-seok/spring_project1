package com.self.springweek_1.dto;

import com.self.springweek_1.model.Blog;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlogSimpleResponseDto {
    private final Long id;
    private final String title;
    private final String username;
    private final LocalDateTime createdAt;

    public BlogSimpleResponseDto(Blog blog){
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.username = blog.getUsername();
        this.createdAt = blog.getCreatedAt();
    }
}
