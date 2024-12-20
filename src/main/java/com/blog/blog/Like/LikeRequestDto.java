package com.blog.blog.Like;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LikeRequestDto {

    private int likeNumber;
    private int userId;
    private int postId;

    public LikeRequestDto() {

    }

    @Builder
    public LikeRequestDto(int likeNumber, int user, int post) {
        this.likeNumber = likeNumber;
        this.userId = user;
        this.postId = post;
    }
}
