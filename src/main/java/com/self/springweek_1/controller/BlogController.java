package com.self.springweek_1.controller;

import com.self.springweek_1.dto.BlogDetailRequestDto;
import com.self.springweek_1.Repository.BlogRepository;
import com.self.springweek_1.dto.BlogRequestDto;
//import com.self.springweek_1.service.BlogService;
import com.self.springweek_1.dto.BlogSimpleResponseDto;
import com.self.springweek_1.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
@Slf4j
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

    //게시글 등록
    @PostMapping("")
    public Long saveNewPost(@RequestBody BlogRequestDto requestDto) {
        return blogService.save(requestDto);

    }
    //게시글 목록 조회
    @GetMapping("")
    public List<BlogSimpleResponseDto> getPost() {
         return blogService.findAll();
    }

    //특정 게시글 조회
    @GetMapping("/{id}")
    public BlogDetailRequestDto getPost(@PathVariable Long id){
        System.out.println(blogService.findById(id));
        return blogService.findById(id);
    }



}
