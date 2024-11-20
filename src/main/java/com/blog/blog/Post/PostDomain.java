package com.blog.blog.Post;

import com.blog.blog.User.UserDomain;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Post")

public class PostDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id", nullable = false)
    private int postId;

    @Column(length = 10, nullable = false)
    private String username;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime create_date;

    @UpdateTimestamp
    private LocalDateTime update_date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDomain user;

    public PostDomain() {
    }

    @Builder
    public PostDomain(int postId, String title, String content, String username,
                      LocalDateTime create_date, LocalDateTime update_date) {
        this.postId = postId;
        this.username = username;
        this.title = title;
        this.content = content;
        this.create_date = create_date;
        this.update_date = update_date;
    }

}

// 전체 or 특정 게시물 조회 시-> username, title, content, createdate, updatedate 반환
// 게시물 생성 or 수정 시-> username, title, content 입력, 반환은 responseDto
