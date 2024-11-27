package com.blog.blog.Follow;

import com.blog.blog.User.UserDomain;
import com.blog.blog.User.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follows/")
public class FollowController {

    private final UserService userService;
    private final FollowService followService;

    public FollowController(UserService userService, FollowService followService) {
        this.userService = userService;
        this.followService = followService;
    }

    @GetMapping("/follows/{username}/following")
    public List<FollowResponseDto> getFollowing(@PathVariable String username) {
        UserDomain following = userService.getFollowingUsers(username);


    }

    @GetMapping("/follows/{username}/follower")


    @PostMapping("/follows/{username}/")



    }
