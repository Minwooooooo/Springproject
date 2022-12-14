package com.project.project_week3.util;

import lombok.Getter;

@Getter
public class ErrorList {

    String code;
    String message;
    //아이디가 존재하지 않을시
    public void none_ID(){
        this.code="NULL_POST_ID";
        this.message="해당 아이디가 존재하지 않습니다";
        return;
    }

    //비밀번호가 일치하지 않을시
    public void mis_pw(){
        this.code="MISMATCHED_PW";
        this.message="비밀번호가 일치하지 않습니다.";
    }

}
