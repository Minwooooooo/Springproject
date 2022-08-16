package com.project.project_week3.Controller;

import com.project.project_week3.Dto.PasswordDto;
import com.project.project_week3.Dto.PostRequestDto;
import com.project.project_week3.Dto.ResponseDto;
import com.project.project_week3.Entity.Post;
import com.project.project_week3.Repository.PostRepository;
import com.project.project_week3.Service.PostService;
import com.project.project_week3.util.ErrorList;
import com.project.project_week3.util.Response;
import com.project.project_week3.util.Security;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final Security security;
    private final PostService postService;

    //게시글 등록
    @PostMapping("/api/posts")
    public Response creatPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        ResponseDto responseDto = new ResponseDto(post);
        Response response = new Response(true,responseDto,null);
        return response;
    }

//    // 게시글 목록 조회
//    @GetMapping("/api/posts")
//    public List<Post> getPosts(){
//        List<Post> temp_list = postRepository.findAll();
//        return temp_list;
//    }

    // 게시글 목록 조회
    @GetMapping("/api/posts")
    public Response getPosts(){
        List<Post> temp_list = postRepository.findAll();
        ArrayList<ResponseDto> response_list = new ArrayList<>();
        for (int i = 0; i < temp_list.size(); i++) {
            Post temp_response = temp_list.get(i);
            ResponseDto responseDto = new ResponseDto(temp_response);
            response_list.add(responseDto);
        }
        Response response = new Response(true,response_list,null);
        return response;
    }



    // 게시글 조회
    @GetMapping("/api/posts/{id}")
    public Response thisPosts(@PathVariable Long id){
        Long dbsize=postRepository.count();
        ErrorList errorList = new ErrorList();
        Response response;
        if (id<=dbsize) {
            response = new Response(true, postRepository.findById(id), null);
        }
        else{
            errorList.none_ID();
            response = new Response(false, postRepository.findById(id), errorList);
        }
        return response;
    }

    // 비밀번호 확인하기
    @PostMapping("/api/posts/{id}")
    public Response checkPassword(@PathVariable Long id, @RequestBody PasswordDto passwordDto){
        Response response;
        Long dbsize=postRepository.count();
        ErrorList errorList = new ErrorList();
        if(id<=dbsize) {
            Boolean check =passwordDto.getPassword().equals(postRepository.findById(id).get().getPassword());
            if (check == true) {
                response = new Response(check, null, null);
            } else {
                errorList.mis_pw();
                response = new Response(check, null, errorList);
            }
        }
        else{
            errorList.none_ID();
            response = new Response(false, postRepository.findById(id), errorList);
        }

        return response;
    }


    // 게시글 수정
   @PutMapping("/api/posts/{id}")
    public Response editPost(@PathVariable Long id,@RequestBody PostRequestDto requestDto){
        Response response;
        Long dbsize=postRepository.count();
        ErrorList errorList = new ErrorList();
        if(id<=dbsize){
            postService.edit(id, requestDto);
            response = new Response(true, postRepository.findById(id), null);
        }
        else {
            errorList.none_ID();
            response = new Response(false, null, errorList);
        }
        return response;
    }

    // 게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public Response delPost(@PathVariable Long id){
        Response response;
        Long dbsize=postRepository.count();
        ErrorList errorList = new ErrorList();
        if(id<=dbsize) {
            postRepository.deleteById(id);
            response = new Response(true, true, null);
        }
        else {
            errorList.none_ID();
            response = new Response(false, null, errorList);
        }
        return response;
    }

}
