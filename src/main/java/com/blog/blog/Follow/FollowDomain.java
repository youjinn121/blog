package com.blog.blog.Follow;

import com.blog.blog.User.UserDomain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    @JoinColumn(name = "follower_name", nullable =true) //
    private UserDomain following; // 유저를 팔로우

    @ManyToOne
    @JoinColumn(name = "following_name", nullable =true)
    private UserDomain follower; // 유저가 팔로우

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime create_date;

    public FollowDomain() {

    }

    @Builder
    public FollowDomain(int follow_id, UserDomain following, UserDomain follower, LocalDateTime create_date) {
        this.follow_id = follow_id;
        this.following = following;
        this.follower = follower;
        this.create_date = create_date;
    }


}
