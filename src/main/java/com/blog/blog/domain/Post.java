package com.blog.blog.domain;

import com.blog.blog.dto.request.PostRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Controller;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "Post")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String username;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime create_date;

    @UpdateTimestamp
    private LocalDateTime update_date;

    public Post(PostRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.content = requestDTO.getContent();
        this.username = requestDTO.getUsername();
    }

    // 업데이트 메소드
    public void update(PostRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.content = requestDTO.getContent();
        this.username = requestDTO.getUsername();
    }

}
