package com.blog.blog.Follow;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowResponseDto {

    private int follow_id;
    private String follower_name;
    private String following_name;

    @Builder
    public FollowResponseDto(FollowDomain follow){
        this.follow_id = follow.getFollow_id();
        this.follower_name = follow.getUser_followed().getUserName();
        this.following_name = follow.getUser_following(). getUserName();
    }

}
