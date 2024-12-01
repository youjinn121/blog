package com.blog.blog.Follow;

import com.blog.blog.Post.PostDomain;
import com.blog.blog.User.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<FollowDomain, Integer> {


    List<FollowDomain> findFollowersByUserId(int userId);

    List<FollowDomain> findFollowingByUserId(int userId);

    void deleteByFollowing(int userId, int followerId);

}

// 유저 이름와 팔로워를 요청하면 팔로워 수와 팔로워 리스트 반환
// 유저 이름와 팔로잉을 요청하면 팔로잉 수와 팔로잉 리스트를 반환
// 유저 1와 유저2과 팔로잉 요청하면 1이 2의 팔로잉 리스트로
// 유저 1와 유저2와 delete 요청하면 1을 2의 팔로잉 리스트에서 삭제