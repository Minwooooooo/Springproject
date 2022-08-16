package com.project.project_week3.Dto;

import com.project.project_week3.Entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseDto {
    //제목 작성자명 작성내용
    //비밀 번호는 제외
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String title;
    private String name;
    private String content;


    public ResponseDto(Post post) {
        this.id= post.getId();
        this.createdAt=post.getCreatedAt();
        this.modifiedAt=post.getModifiedAt();
        this.title=post.getTitle();
        this.name=post.getName();
        this.content=post.getContent();
    }
}

