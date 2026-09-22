package com.example.springsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    // API test public - ai cũng truy cập được
    @GetMapping("/test")
    public String testPublic() {
        return "Đăng nhập thành công";
    }

    // API login giả lập
    @PostMapping("/login")
    public String login() {
        return "Đăng nhập thành công";
    }
}
