package com.project.project_week3.util;

import lombok.Getter;

@Getter
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


//  {
//     "success":true,
//     "data":{
//        "createdAt":"2022-07-25T12:43:01.226062”,
//        "modifiedAt":"2022-07-25T12:43:01.226062”,
//        "id":1,
//        "title":"title",
//        "content":"content",
//        "author":"author"
//      },
//     "error":null
//  }