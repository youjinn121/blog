package com.blog.blog.Post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostRequestDto {

    private String username;
    private String title;
    private String content;

    public PostRequestDto() {

    }

    public PostRequestDto(String username, String title, String content, LocalDateTime create_date, LocalDateTime update_date) {
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
