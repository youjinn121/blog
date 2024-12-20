package com.blog.blog.Like;

import com.blog.blog.Post.PostDomain;
import com.blog.blog.Post.PostRepository;
import com.blog.blog.Post.PostResponseDto;
import com.blog.blog.User.UserDomain;
import com.blog.blog.User.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public LikeService(LikeRepository likeRepository, UserRepository userRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public LikeResponseDto createLike(LikeRequestDto requestDto) {

        UserDomain user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + requestDto.getUserId()));

        PostDomain post = postRepository.findById(requestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + requestDto.getPostId()));

        boolean likeExists = likeRepository.existsByUserIdAndPostId(user, post);
        if (likeExists) {
            throw new IllegalStateException("Like already exists!");
        }

        LikeDomain like = LikeDomain.builder()
                .likeNumber(requestDto.getLikeNumber())
                .likeDate(LocalDateTime.now())
                .userId(user)
                .postId(post)
                .build();

        LikeDomain savedLike = likeRepository.save(like);

        return new LikeResponseDto(savedLike);
    }

    public List<LikeResponseDto> getLike(int userId) {
        return likeRepository.findAllByUserId_UserId(userId).stream()
                .map(LikeResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<LikeResponseDto> deleteLikeByUserIdAndPostId(int userId, int postId) {

        LikeDomain like = likeRepository.findByUserIdAndPost(userId, postId)
                .orElseThrow(()-> new IllegalArgumentException("Like not found"));

        likeRepository.delete(like);

        List<LikeDomain> likeLists = likeRepository.findAllByUserId_UserId(userId);

        return likeLists.stream()
                .map(l -> new LikeResponseDto(l))
                .collect(Collectors.toList());
    }

}
