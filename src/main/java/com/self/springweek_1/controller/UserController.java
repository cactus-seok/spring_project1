package com.self.springweek_1.controller;

import com.self.springweek_1.dto.SignupRequestDto;
import com.self.springweek_1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto, Model model) {
        try {
            userService.registerUser(requestDto);
        }catch (IllegalArgumentException e){
            System.out.println(e);
            model.addAttribute("message", e.getMessage());
            return "signup";
        }
        return "redirect:/user/login";
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(String code) {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        userService.kakaoLogin(code);

        return "redirect:/";
    }
}