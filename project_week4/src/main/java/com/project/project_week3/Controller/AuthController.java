package com.project.project_week3.Controller;

import com.project.project_week3.Dto.LoginDto;
import com.project.project_week3.Dto.SignUpDto;
import com.project.project_week3.Dto.TokenDto;
import com.project.project_week3.Security.jwt.JwtFilter;
import com.project.project_week3.Service.AuthService;
import com.project.project_week3.util.Response;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER,authService.login(loginDto).getAccessToken());
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER2,authService.login(loginDto).getRefreshToken());
        return new ResponseEntity<>(authService.login(loginDto),httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpDto signUpDto){
        return ResponseEntity.ok(authService.signup(signUpDto));
    }

}
