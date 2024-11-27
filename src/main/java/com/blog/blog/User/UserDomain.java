package com.blog.blog.User;

import com.blog.blog.Follow.FollowDomain;
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

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostDomain> posts;

    @OneToMany(mappedBy = "follower")
    private List<FollowDomain> follower_users;

    @OneToMany(mappedBy = "following")
    private List<FollowDomain> following_users;

    public UserDomain() {
    }

    @Builder
    public UserDomain(int userId, String userName, String userPassword, String email
            , List<PostDomain> posts, List<FollowDomain> follower_users, List<FollowDomain> following_users) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.posts = posts;
        this.follower_users = follower_users;
        this.following_users = following_users;

    }


}