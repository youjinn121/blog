package com.blog.blog.Post;

import com.blog.blog.User.UserRequestDto;
import com.blog.blog.User.UserResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public PostResponseDto getPostById(@PathVariable int id) { // url 경로의 {id}를 매개변수로 받음
        return postService.getPostById(id); // id를 전달 후, 사용자 정보 조회
    } // 서비스에서 데이터베이스 조회 후, id에 맞는 사용자 dto로 반환

    // 데이터를 http body에 담아 요청, 사용자 생성
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){  // client 요청(UserRequestDto)를 객체에 담아 responseDTO로 내보냄
        return postService.createPost(requestDto);
    }

    // 사용자 정보 수정
    @PutMapping("/posts/{id}")  // url경로의 {id}를 받을 때 pathvariable, http body의 json데이터를 dto객체로 변환하여 받음
    public PostResponseDto updatePost(@PathVariable int id, @RequestBody PostRequestDto requestDto){  // Userrequestdto는 사용자 생성 요청에 필요한 필드를 가지고 있음, 유저네임, 패스워드, 이메일 등
        return postService.updatePost(id, requestDto);
    }

    //해당 id 사용자 삭제
    @DeleteMapping("/posts/{id}")
    public PostResponseDto deletePost(@PathVariable int id){
        return postService.deletePost(id);
    }
}
