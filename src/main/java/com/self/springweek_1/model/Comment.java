package com.self.springweek_1.model;

import com.self.springweek_1.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long article_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Comment (CommentRequestDto commentRequestDto){
        this.article_id = commentRequestDto.getArticle_id();
        this.username = commentRequestDto.getUsername();
        this.contents = commentRequestDto.getContents();
    }

    public void update_comment(CommentRequestDto commentRequestDto){
        this.article_id = commentRequestDto.getArticle_id();
        this.username = commentRequestDto.getUsername();
        this.contents = commentRequestDto.getContents();
    }

}

