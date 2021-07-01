package com.self.springweek_1.dto;

import com.self.springweek_1.models.Blog;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlogDetailRequestDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final String username;
    private final LocalDateTime createdAt;

    public BlogDetailRequestDto(Blog blog){
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.contents = blog.getContents();
        this.username = blog.getUsername();
        this.createdAt = blog.getCreatedAt();
    }
}
