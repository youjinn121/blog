package com.blog.blog.User;

import com.blog.blog.Post.PostDomain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="User")
public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(length = 10, nullable = false)
    private String userName;

    @Column(length = 20, nullable = false)
    private String userPassword;

    @Column(length = 20, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostDomain> posts;

    public UserDomain() {
    }

    @Builder
    public UserDomain(int userId, String userName, String userPassword, String email) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
    }


}

// 전체 or 특정 이용자 조회 시-> id, name, email 반환
// 이용자 생성 or 수정 시-> name, email, password 입력, 반환은 responseDto