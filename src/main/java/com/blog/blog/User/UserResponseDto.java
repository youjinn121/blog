package com.blog.blog.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private int userId;
    private String userName;
    private String email;

    @Builder
    public UserResponseDto(UserDomain user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }
}

// 게시글 전체 조회 아님 id를 통한 부분 조회

