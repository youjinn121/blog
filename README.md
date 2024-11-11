# blog
---
## ERD

![Blog ERD](https://github.com/youjinn121/blog/blob/main/erd.png)

ERD는 Post, list, User, Comment, Like 다섯 개 테이블로 구성되어 있다.

1. Post (**post_id**)

   - user_id를 외래키로 가지고 있으며, User 테이블과 연관된다.
  
   - 하나의 사용자(User)는 여러 개의 게시물(Post)을 작성할 수 있다.
  
   - Comment와 Like 테이블에서 참조되어, 각 게시물에 달린 댓글과 좋아요 정보를 관리한다.
  
   - List 테이블에서 참조되어 각 게시물이 포함된 리스트 정보를 관리한다.




2. list (**list_id**)

   - Post 테이블의 post_id를 참조하여 특정 리스트에 포함된 게시물 목록을 관리한다.




3. User(**user_id**)

   - Post 테이블에서 참조되어 사용자가 작성한 게시물과의 관계를 가진다.
  
   - Comment와 Like 테이블에서 user_id를 통해 참조된다. 사용자는 여러 개의 댓글을 작성하고 좋아요를 누를 수 있다.




4. Comment(**comment_id**)

   - Post 테이블의 post_id를 참조하여 특정 게시물에 달린 댓글을 관리한다.




## 기능 설명


- 블로그 댓글 달기

- 좋아요 기능

- 글 목록 불러오기
