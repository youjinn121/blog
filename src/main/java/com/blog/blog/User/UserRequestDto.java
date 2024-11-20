package com.blog.blog.User;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private String userName;
    private String userPassword;
    private String email;

    public UserRequestDto(){

    }

    public UserRequestDto(String userName, String userPassword, String email) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
    }

}





// request가 들어오는 경우 POST, PUT
// 사용자를 생성, 수정할 때, requestdto형식으로 반환
