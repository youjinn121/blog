package com.blog.blog.Follow;

import com.blog.blog.User.UserDomain;
import com.blog.blog.User.UserRepository;
import com.blog.blog.User.UserResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public FollowService(FollowRepository followRepository, UserRepository userRepository) {

        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    public FollowResponseDto createFollow(UserResponseDto follower, UserResponseDto following) {
        FollowDomain follow = FollowDomain.builder()
                .follower(new UserDomain(follower.getUserId(), follower.getUserName()))
                .following(new UserDomain(following.getUserId(), following.getUserName()))
                .create_date(LocalDateTime.now())
                .build();

        FollowDomain savedFollow = followRepository.save(follow);
        return FollowResponseDto.from(savedFollow);
    }

    public List<FollowResponseDto> getFollowers(int userId) {

        UserDomain user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<FollowDomain> followers = followRepository.findFollowersByUserId(user.getUserId());

        return followers.stream()
                .map(FollowResponseDto::from)
                .toList();
    }


    public List<FollowResponseDto> getFollowings(int userId) {

        UserDomain user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<FollowDomain> followings = followRepository.findFollowingByUserId(user.getUserId());
        return followings.stream()
                .map(FollowResponseDto::from)
                .toList();
    }

    public void deleteByFollowing(int userId, int followerId) {

        followRepository.deleteByFollowing(userId, followerId);
    }

}
