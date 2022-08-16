# Week3_Spring

**스프링 부트**로 로그인 기능이 없는 나만의 항해 블로그 **백엔드 서버** 만들기


## Use Case
![그림1](https://user-images.githubusercontent.com/110237141/184834764-89c37111-86d2-4c43-900a-0327756d4015.png)



## API 명세서
| 기능 |Method| URL | Request| Response|
|--|--|--|--|--|
|게시물 등록|POST|/api/posts|{<br>,<br>"title":"제목",<br>"content" : "내용",<br>"name" : "이름",<br>"password" : "1234"<br>}|{<br>"success":true<br>"data":{<br>"id":  1,<br>"createdAt":"2022-08-16T16:45:16.6246924",<br>"modifiedAt":  "2022-08-16T16:45:16.6246924",<br>"title":"제목",<br>"content" : "내용",<br>"name" : "이름"<br>}<br>"error":null<br>}|
|게시물 목록|GET|/api/posts  |  |{<br>"success":true<br>"data":{<br>"id":  1,<br>"createdAt":"2022-08-16T16:45:16.6246924",<br>"modifiedAt":  "2022-08-16T16:45:16.6246924",<br>"title":"제목",<br>"content" : "내용",<br>"name" : "이름"<br>}<br>{<br>"id":  2,<br>"createdAt":"2022-08-16T16:45:18.6246924",<br>"modifiedAt":  "2022-08-16T16:45:18.6246924",<br>"title":"제목2",<br>"content" : "내용2",<br>"name" : "이름2"<br>}<br>"error":null<br>}  |
|게시물 조회|GET  |/api/posts/{id}|  |{<br>"success":true<br>"data":{<br>"id":  1,<br>"createdAt":"2022-08-16T16:45:16.6246924",<br>"modifiedAt":  "2022-08-16T16:45:16.6246924",<br>"title":"제목",<br>"content" : "내용",<br>"name" : "이름"<br>}<br>"error":null<br>} |
|비밀번호 확인|POST  |/api/posts/{id}|  |{<br>"success":true<br>"data":true<br>"error":null<br>} |
|게시물 수정|PUT  |/api/posts/{id}  |{<br>,<br>"title":"수정제목",<br>"content" : "수정내용",<br>"name" : "수정이름",<br>"password" : "1234_1"<br>}|{<br>"success":true<br>"data":true<br>"error":null<br>} |
|게시물 삭제|DELETE|/api/posts/{id}  |  |{<br>"success":true<br>"data":true<br>"error":null<br>} |
