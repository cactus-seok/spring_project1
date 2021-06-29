package com.self.springweek_1.controller;

import com.self.springweek_1.models.Blog;
import com.self.springweek_1.models.BlogRepository;
import com.self.springweek_1.models.BlogRequestDto;
//import com.self.springweek_1.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class BlogController {

    private final BlogRepository blogRepository;


    @PostMapping("")
    public Blog saveNewPost(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);

    }

    @GetMapping("")
    public List<Blog> getPost() {
         return blogRepository.findAll();
    }



}
