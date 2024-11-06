package com.blog.blog.repository;

import com.blog.blog.domain.Post;
import com.blog.blog.dto.response.PostResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<PostResponseDTO> findAllByOrderByModifiedAtDesc();
}