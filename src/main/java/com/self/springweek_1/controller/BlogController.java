package com.self.springweek_1.controller;

import com.self.springweek_1.models.Blog;
import com.self.springweek_1.models.BlogRepository;
import com.self.springweek_1.models.BlogRequestDto;
import com.self.springweek_1.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @PostMapping("")
    public Blog createBlogPost(@RequestBody BlogRequestDto requestDto){
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @GetMapping
}
