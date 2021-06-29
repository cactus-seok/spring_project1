//package com.self.springweek_1.service;
//
//import com.self.springweek_1.models.Blog;
//import com.self.springweek_1.models.BlogRepository;
//import com.self.springweek_1.models.BlogRequestDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@RequiredArgsConstructor
//@Service
//public class BlogService {
//
//    private final BlogRepository blogRepository;
//    private final BlogService blogService;
//
//    @Transactional
//    public Long update(Long id, BlogRequestDto requestDto){
//        Blog blog = blogRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        blog.update(requestDto);
//        return blog.getId();
//    }
//}
