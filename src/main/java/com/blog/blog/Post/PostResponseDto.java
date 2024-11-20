package com.blog.blog.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponseDto {

    private int postid;
    private String username;
    private String title;
    private String content;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    @Builder
    public PostResponseDto(PostDomain post) {
        this.postid = post.getPostId();
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.create_date = post.getCreate_date();
        this.update_date = post.getUpdate_date();
    }
}


