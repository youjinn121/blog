package com.blog.blog.Like;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/likes")
    public LikeResponseDto createLike(@RequestBody LikeRequestDto requestDto) {
        LikeResponseDto myLike = likeService.createLike(requestDto);
        return myLike;
    }

    @GetMapping("/likes/{id1}")
    public List<LikeResponseDto> getLike(@PathVariable int userId) {
        List<LikeResponseDto> likelist = likeService.getLike(userId);
        return likelist;
    }

    @DeleteMapping("/dlikes/{id1}/{id2}")
    public List<LikeResponseDto> deleteLikeById(@RequestParam int userId, @RequestParam int postId) {
        List<LikeResponseDto> likelist = likeService.deleteLikeByUserIdAndPostId(userId, postId);

        return likelist;
    }

}
