package com.blog.blog.controller;

import com.blog.blog.dto.request.PostRequestDTO;
import com.blog.blog.dto.response.PostResponseDTO;
import org.springframework.ui.Model;
import com.blog.blog.domain.Post;
import com.blog.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    public final BlogService blogService;

    public BlogController(BlogService blogService) { //
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public PostResponseDTO createBoard(@RequestBody PostRequestDTO requestDTO){
        PostResponseDTO post = blogService.register(requestDTO);
        return post;
    }

    @GetMapping("/blog/list")
    public List<PostResponseDTO> getAllBoards() {
        return blogService.findAllPost();
    }

    @PutMapping("/blog/{id}")
    public int updateBoard(@PathVariable int id, @RequestBody PostRequestDTO requestDTO) {
        return blogService.updatePost(id,requestDTO);
    }

    @DeleteMapping("/blog/{id}")
    public int deleteBoard(@PathVariable int id) {
        return  blogService.deletePost(id);
    }

}
