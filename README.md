# Week3_Spring

**스프링 부트**로 로그인 기능이 없는 나만의 항해 블로그 **백엔드 서버** 만들기


## :mega: Use Case
![그림1](https://user-images.githubusercontent.com/110237141/184834764-89c37111-86d2-4c43-900a-0327756d4015.png)



## :mega: API 명세서
| 기능 |Method| URL | Request| Response|
|--|--|--|--|--|
|게시물 등록|POST|/api/posts|{<br>,<br>"title":"제목",<br>"content" : "내용",<br>"name" : "이름",<br>"password" : "1234"<br>}|{<br>"success":true<br>"data":{<br>"id":  1,<br>"createdAt":"2022-08-16T16:45:16.6246924",<br>"modifiedAt":  "2022-08-16T16:45:16.6246924",<br>"title":"제목",<br>"content" : "내용",<br>"name" : "이름"<br>}<br>"error":null<br>}|
|게시물 목록|GET|/api/posts  |  |{<br>"success":true<br>"data":{<br>"id":  1,<br>"createdAt":"2022-08-16T16:45:16.6246924",<br>"modifiedAt":  "2022-08-16T16:45:16.6246924",<br>"title":"제목",<br>"content" : "내용",<br>"name" : "이름"<br>}<br>{<br>"id":  2,<br>"createdAt":"2022-08-16T16:45:18.6246924",<br>"modifiedAt":  "2022-08-16T16:45:18.6246924",<br>"title":"제목2",<br>"content" : "내용2",<br>"name" : "이름2"<br>}<br>"error":null<br>}  |
|게시물 조회|GET  |/api/posts/{id}|  |{<br>"success":true<br>"data":{<br>"id":  1,<br>"createdAt":"2022-08-16T16:45:16.6246924",<br>"modifiedAt":  "2022-08-16T16:45:16.6246924",<br>"title":"제목",<br>"content" : "내용",<br>"name" : "이름"<br>}<br>"error":null<br>} |
|비밀번호 확인|POST  |/api/posts/{id}|  |{<br>"success":true<br>"data":true<br>"error":null<br>} |
|게시물 수정|PUT  |/api/posts/{id}  |{<br>,<br>"title":"수정제목",<br>"content" : "수정내용",<br>"name" : "수정이름",<br>"password" : "1234_1"<br>}|{<br>"success":true<br>"data":true<br>"error":null<br>} |
|게시물 삭제|DELETE|/api/posts/{id}  |  |{<br>"success":true<br>"data":true<br>"error":null<br>} |


### :question: 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
|기능|Param|Query|Body|
|---|---|---|---|
|수정|/api/posts/{id}|X|{수정내용}|
|삭제|/api/posts/{id}|X|X|

### :question: 어떤 상황에 어떤 방식의 request를 써야하나요?
|방식|보편적 기능||
|---|---|---|
|GET|조회||
|POST|등록|GET과 달리 URL을 통해 request의 내용이 노출되지않아<br> 비밀번호와 같은 민감한 내용이 담길때도 사용|
|PUT|수정||
|DELETE|삭제||

### :question: RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
RESTful : REST 아키텍처의 제약조건을 준수하는 애플리케이션
RESTful 하지 못한 경우
- CRUD기능을 모두 POST로만 처리
- route에 ID외의 정보가 들어가는 경우
 
**route와 request방식이 중복되어 오류가 발생하거나, 민감한 정보가 route에 담기지 않도록 설계**

### :question: 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
|||
|---|---|
|Controller|Client와 직접 마주하는 곳으로 요청을 받아 Repository에 전달 후 다시 Client에 전달|
|Repository|Entity에 의해 생성된 DB에 접근하는 Method를 사용하기 위한 인터페이스<br>주로 findAll(),findById()를 활용|
|Service|Controller에서 Repository에 전달하거나 Repository에서 Client에 전달되는 과정에서 필요한 가공을 수행<br>예) PUT을 통해 수정내용을 받으면 @Transactinal을 통해 수정|

### :question: 작성한 코드에서 빈(Bean)을 모두 찾아보세요!
    Bean : Java Bean Convention에 따르는 데이터를 표현하기 위한 클래스
    
---

    Java Bean Convention : 모든 필드가 private이며 getter/setter를 통해서만 접근가능하다.
                       Argument(인자)가 없는 Default constructor(기본 생성자)를 갖는다.
                       Seriallizable 인터페이스를 구현한다.
                       Bean클래스는 패키징 되어야 한다.
***Project내 Bean*** : Dto 폴더 내 3가지 Dto, Post, Timestampe
```java
[예시-Post]
@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private  Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String content;

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    //수정하기
    public void updateByRequestDto(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
    }
}
```

# Week4_Spring

**Week3**에 **JWT** 기반 로그인 시스템 및 댓글 시스템 구현하기

### :question: 미완료
- Reponse에 서로다른 형태의 리스트 출력하기
```java
public class Response <T> {
    boolean checkSuccess;
    T data;
    ErrorList errorList;

    public Response(boolean checkSuccess, T data,ErrorList errorList) {
        this.checkSuccess = checkSuccess;
        this.data = data;
        this.errorList =errorList;
    }


}
```
T data 형태로 지정한 부분에 Comment와Post 같이 넣기

- 서버구동

- 오류 통일(일부는 Exception, 일부는 Response로 처리)
