package com.blog.blog.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// entity에 의해 생성된 db에 접근하는 메서드, dbㅇ[ crud 명령을 실행시킴
public interface UserRepository extends JpaRepository<UserDomain, Integer> {


    List<UserDomain> findAll();

    Optional<UserDomain> findById(Integer userId);

    <S extends UserDomain> S save(S entity);

    void deleteById(Integer id);

}
