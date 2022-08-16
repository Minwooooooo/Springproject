package com.project.project_week3.Service;

import com.project.project_week3.Controller.PostController;
import com.project.project_week3.Dto.PostRequestDto;
import com.project.project_week3.Entity.Post;
import com.project.project_week3.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post edit(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        post.updateByRequestDto(requestDto);
        return postRepository.findById(id).get();
    }

    //출력
    //   {
    //   "success": true,
    //   "data": {
    //        "createdAt": "2022-07-25T12:43:01.226062”,
    //        "modifiedAt": "2022-07-25T12:43:01.226062”,
    //        "id": 1,
    //        "title": "title2",
    //        "content": "content2",
    //        "author": "author2"
    //   },
    //   "error": null
    //   }
}
