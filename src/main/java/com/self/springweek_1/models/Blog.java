package com.self.springweek_1.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Blog extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Blog(String username, String title, String contents){
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public Blog (BlogRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.username = requestDto.getTitle();
        this.username = requestDto.getContents();

    }
}
