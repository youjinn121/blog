package com.blog.blog.Follow;

import lombok.Getter;

@Getter
public class FollowRequestDto {

    private Long followerId; // 팔로우를 요청하는 사용자 ID
    private Long followingId; // 팔로우 당하는 사용자 ID

    // 기본 생성자
    public FollowRequestDto() {
    }

    // 매개변수 생성자
    public FollowRequestDto(Long followerId, Long followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    // Getter와 Setter
    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Long followingId) {
        this.followingId = followingId;
    }
}
