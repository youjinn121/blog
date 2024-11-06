package com.blog.blog.service;

import com.blog.blog.domain.Post;
import com.blog.blog.dto.request.PostRequestDTO;
import com.blog.blog.dto.response.PostResponseDTO;
import com.blog.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class BlogService {
    private final PostRepository postRepository;

    public BlogService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDTO register(PostRequestDTO requestDTO) {
        Post post = new Post(requestDTO);
        postRepository.save(post);
        return new PostResponseDTO(post);
    }

    public List<PostResponseDTO> findAllPost() {
        List<Post> postList = postRepository.findAll();  // 주입받은 postRepository 사용
        List<PostResponseDTO> responseDTO = new ArrayList<>();

        for (Post post : postList) {
            responseDTO.add(new PostResponseDTO(post));
        }

        return responseDTO;
    }

    @Transactional
    public int updatePost(int id, PostRequestDTO requestDTO) {
        Post post = postRepository.findById(id).orElseThrow();
        post.update(requestDTO);
        return post.getId();
    }

    @Transactional
    public int deletePost(int id) {
        postRepository.deleteById(id);
        return id;
    }
}
