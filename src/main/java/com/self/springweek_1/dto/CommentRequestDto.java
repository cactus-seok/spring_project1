package com.self.springweek_1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private Long article_id;
    private String username;
    private String contents;

}
