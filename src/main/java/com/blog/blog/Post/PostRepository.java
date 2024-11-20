package com.blog.blog.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostDomain, Integer> {

    List<PostDomain> findAll();

    Optional<PostDomain> findById(Integer id);

    <NewPost extends PostDomain> NewPost save(NewPost post);

    void deleteById(Integer id);
}
