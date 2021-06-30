package com.self.springweek_1.service;

import com.self.springweek_1.dto.BlogDetailRequestDto;
import com.self.springweek_1.models.Blog;
import com.self.springweek_1.models.BlogRepository;
import com.self.springweek_1.dto.BlogRequestDto;
import com.self.springweek_1.dto.BlogSimpleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 포스트 생성
    @Transactional
    public Long save(BlogRequestDto requestDto){
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog).getId();
    }

    // 게시글 리스트 불러오기
    @Transactional // 트랜잭션 범위는 유지하되 조회기능만 남겨서 조회속도가 개선
    public List<BlogSimpleResponseDto> findAll(){
        return blogRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(post -> new BlogSimpleResponseDto(post))
                .collect(Collectors.toList());
        // postsRepository.findAll()는 List<Post>를 반환하는데
        // 이를 List<PostSimpleResponseDto>로 바꿔서 반환
    }
    //게시글 상세 조회
    @Transactional
    public BlogDetailRequestDto findById(Long id){
        Blog entity = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id="+id));
        return new BlogDetailRequestDto(entity);
    }

//    @Transactional
//    public Long update(Long id, BlogRequestDto requestDto){
//        Blog blog = blogRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        blog.update(requestDto);
//        return blog.getId();
//    }
}
