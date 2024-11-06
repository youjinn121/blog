# blog
---
## ERD

![Blog ERD](https://github.com/youjinn121/blog/blob/main/erd.png)

ERD는 Post, list, User, Comment, Like 다섯 개 테이블로 구성되어 있다.

1. Post (**post_id**)

user_id를 외래키로 가지고 있으며, User 테이블과 연관된다.

하나의 사용자(User)는 여러 개의 게시물(Post)을 작성할 수 있다.

Comment와 Like 테이블에서 참조되어, 각 게시물에 달린 댓글과 좋아요 정보를 관리한다.

List 테이블에서 참조되어 각 게시물이 포함된 리스트 정보를 관리한다.




2. list (**list_id**)

Post 테이블의 post_id를 참조하여 특정 리스트에 포함된 게시물 목록을 관리한다.




3. User(**user_id**)

Post 테이블에서 참조되어 사용자가 작성한 게시물과의 관계를 가진다.

Comment와 Like 테이블에서 user_id를 통해 참조된다. 사용자는 여러 개의 댓글을 작성하고 좋아요를 누를 수 있다.




4. Comment(**comment_id**)

Post 테이블의 post_id를 참조하여 특정 게시물에 달린 댓글을 관리한다.

User 테이블의 user_id를 참조하여 댓글 작성자를 표시한다.




5. Like(**like_id**)

Post 테이블의 post_id를 참조하여 특정 게시물에 대한 좋아요를 관리한다.

User 테이블의 user_id를 참조하여 좋아요를 누른 사용자를 관리한다.


---

## 기능 설명

스프링부트와 JPA를 활용하여 CRUD기능을 구현하는 간단한 블로그 프로젝트이다.

PostRequestDTO를 통해서 클라이언트로부터 요청사항(register, updatePost)을 받고, 엔티티로 변환하여 데이터베이스와 매핑한다. PostResponseDTO를 통해 Post의 정보를 클라이언트에게 반환한다.

우선 Post 엔티티부터 구현하여 게시물을 생성하고, 수정하는 기능을 구현한다.

BlogService 클래스는 PostRepository를 통해 데이터베이스와 상호작용하며, DTO를 사용해 데이터를 클라이언트와 교환한다. 게시물 생성(register), 목록 조회(findAllPost), 게시물 수정 (updatePost), 게시물 삭제 (deletePost) 기능을 구현하며, PostResponseDTO를 반환한다.

BlogController 클래스는 HTTP 요청을 처리하고, 요청에 맞는 비즈니스 로직을 호출하여 결과를 클라이언트에 반환합니다. @RestController를 사용하여 JSON 형식으로 응답을 반환한다. 적절한 Mapping 어노테이선을 통해 경로를 매핑시켜주고, 객체를 반환한다.
