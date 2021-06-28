package com.self.springweek_1.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BlogRequestDto {
    private final String title;
    private final String username;
    private final String contents;
}
