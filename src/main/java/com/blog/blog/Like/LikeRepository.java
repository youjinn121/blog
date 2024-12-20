package com.blog.blog.Like;

import com.blog.blog.Post.PostDomain;
import com.blog.blog.User.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeDomain, Integer> {

    List<LikeDomain> findAllByUserId_UserId(int userId);

    boolean existsByUserIdAndPostId(UserDomain user, PostDomain post);

    Optional<LikeDomain> findByUserIdAndPost(int userId, int postId);

}
