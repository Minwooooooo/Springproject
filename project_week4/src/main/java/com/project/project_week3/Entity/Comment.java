package com.project.project_week3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.project_week3.Dto.CommentDto;
import com.project.project_week3.Dto.RequestDto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = true)
    private String author;

    @Column(nullable = false)
    @JsonIgnore
    private String content;

    public Comment(CommentDto commentDto,String nickName) {
        this.postId=commentDto.getPostId();
        this.author=nickName;
        this.content=commentDto.getContent();
    }

    public void updateByRequestDto(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
    }
}
