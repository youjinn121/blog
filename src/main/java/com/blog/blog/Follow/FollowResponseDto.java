package com.blog.blog.Follow;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class FollowResponseDto {

    private int id;
    private String followerName; // 팔로워 이름
    private String followingName; // 팔로우 당하는 유저 이름
    private LocalDateTime createdAt;

    public FollowResponseDto() {
    }

    public FollowResponseDto(int id, String followerName, String followingName, LocalDateTime createdAt) {
        this.id = id;
        this.followerName = followerName;
        this.followingName = followingName;
        this.createdAt = createdAt;
    }


    public static FollowResponseDto from(FollowDomain follow) {
        return  FollowResponseDto.builder()
                .followerName(follow.getFollower().getUserName())
                .followingName(follow.getFollowing().getUserName())
                .createdAt(follow.getCreate_date())
                .build();
    }

}
