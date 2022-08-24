package com.project.project_week3.Controller;

import com.project.project_week3.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final UserService userService;

    @GetMapping("/myname")
    public String myAuth(){
        String myname= userService.NickName();
        return myname;
    }

    @GetMapping("/mydetail")
    public String myDetail(){
        String myDetail= userService.MyDetail();
        return myDetail;
    }
}
