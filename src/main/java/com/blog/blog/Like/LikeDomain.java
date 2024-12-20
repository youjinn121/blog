package com.blog.blog.Like;

import com.blog.blog.Post.PostDomain;
import com.blog.blog.User.UserDomain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity(name = "Like")
public class LikeDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "like_id", nullable = false)
    private int likeId;

    @Column(nullable = false)
    private int likeNumber;

    @Column(nullable = false)
    private LocalDateTime likeDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDomain userId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostDomain postId;

    public LikeDomain() {

    }

    @Builder
    public LikeDomain(int likeId, int likeNumber, LocalDateTime likeDate, UserDomain userId, PostDomain postId) {

        this.likeId = likeId;
        this.likeNumber = likeNumber;
        this.likeDate = likeDate;
        this.userId = userId;
        this.postId = postId;
    }


}
