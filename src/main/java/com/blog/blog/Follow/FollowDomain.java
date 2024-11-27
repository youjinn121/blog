package com.blog.blog.Follow;

import com.blog.blog.User.UserDomain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Follow")
public class FollowDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int follow_id;

    @ManyToOne
    @JoinColumn(name = "follower_name", nullable =true)
    private UserDomain user_following; // 유저를 팔로우

    @ManyToOne
    @JoinColumn(name = "following_name", nullable =true)
    private UserDomain user_followed; // 유저가 팔로우

    public FollowDomain() {

    }

    @Builder
    public FollowDomain(int follow_id, UserDomain user_following, UserDomain user_followed) {
        this.follow_id = follow_id;
        this.user_following = user_following;
        this.user_followed = user_followed;
    }


}
