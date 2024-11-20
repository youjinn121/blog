package com.blog.blog.Post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> new PostResponseDto(post))
                .collect(Collectors.toList());
    }

    // 특정 게시물 조회
    public PostResponseDto getPostById(int id) {
        PostDomain post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));
        return new PostResponseDto(post);
    }

    public PostResponseDto createPost(PostRequestDto requestDto) {
        PostDomain post = PostDomain.builder()
                .username(requestDto.getUsername())
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .build();

        PostDomain savedPost = postRepository.save(post);
        return new PostResponseDto(savedPost);
    }


    // 게시물 정보 수정
    @Transactional
    public PostResponseDto updatePost(int id, PostRequestDto requestDto) {
        PostDomain existingPost = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));

        PostDomain updatedPost = PostDomain.builder()
                .postId(existingPost.getPostId())
                .username(requestDto.getUsername())
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .build();

        PostDomain savedPost = postRepository.save(updatedPost);
        return new PostResponseDto(savedPost);
    }

    @Transactional
    public PostResponseDto deletePost(int id) {
        PostDomain post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));

        postRepository.deleteById(id);
        return new PostResponseDto(post);
    }
}
