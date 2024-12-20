package com.blog.blog.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain, Integer> {


    List<UserDomain> findAll();

    Optional<UserDomain> findById(Integer userId);

    <S extends UserDomain> S save(S entity);

    void deleteById(Integer id);

}
