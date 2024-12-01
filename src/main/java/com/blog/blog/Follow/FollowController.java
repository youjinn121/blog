package com.blog.blog.Follow;

import com.blog.blog.User.UserDomain;
import com.blog.blog.User.UserRequestDto;
import com.blog.blog.User.UserResponseDto;
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

    @PostMapping("/{followerId}/follow/{followingId}")
    public FollowResponseDto followUser(@PathVariable int followerId, @PathVariable int followingId) {
        UserResponseDto follower = userService.getUserById(followerId);
        UserResponseDto following = userService.getUserById(followingId);

        FollowResponseDto follow_request = followService.createFollow(follower, following);

        return follow_request;
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // 팔로워 목록 조회
    @GetMapping("/{id}/followers")
    public List<FollowResponseDto> getFollowers(@PathVariable int id) {
        List<FollowResponseDto> followers = followService.getFollowers(id);
        return followers;  // User에서 정보찾고 follow에서 객체 생성 후 반환 어떻게? 외래키로 받아와서 리스트?
    }  // List<FollowDomain>을 반환 -> FollowResponseDto가 List<FollowDomain>을 반환

    // 팔로잉 목록 조회
    @GetMapping("/{id}/followings")
    public List<FollowResponseDto> getFollowings(@PathVariable int id) {
        List<FollowResponseDto> followings = followService.getFollowings(id);
        return followings;
    } // List<FollowDomain> 반환

    @DeleteMapping("/{userId}/unfollow/{followerId}")
    public List<FollowResponseDto> unfollowUser(@PathVariable int userId, @PathVariable int followerId) {
        // 팔로잉 관계 삭제
        followService.deleteByFollowing(userId, followerId);

        // 업데이트된 팔로잉 리스트 반환
        return followService.getFollowings(userId);
    }



    }
