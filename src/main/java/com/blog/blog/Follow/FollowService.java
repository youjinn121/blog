package com.blog.blog.Follow;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    private FollowRepository followRepository;

    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }
    public List<FollowResponseDto> getAllFollowers(U)

}
