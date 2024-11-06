package com.blog.blog.dto.response;

import com.blog.blog.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PostResponseDTO {
    private String title;
    private String content;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public PostResponseDTO(Post post) {
        this.title = post.getTitle();
        this.create_date = post.getCreate_date();
        this.update_date = post.getUpdate_date();
    }
}
