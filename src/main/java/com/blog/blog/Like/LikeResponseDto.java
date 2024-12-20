package com.blog.blog.Like;

import com.blog.blog.Post.PostDomain;
import com.blog.blog.User.UserDomain;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class LikeResponseDto {

    private int likeId;
    private int likeNumber;
    private LocalDateTime likeDate;
    private int userId;
    private int postId;

    @Builder
    public LikeResponseDto(LikeDomain like) {
        this.likeId = like.getLikeId();
        this.likeNumber = like.getLikeNumber();
        this.likeDate = LocalDateTime.now();
        this.userId = like.getUserId().getUserId();
        this.postId = like.getPostId().getPostId();
    }
}
