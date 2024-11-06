package com.blog.blog.dto.request;

import com.blog.blog.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class PostRequestDTO {
    private String title;

    private String content;

    private String username;

}
