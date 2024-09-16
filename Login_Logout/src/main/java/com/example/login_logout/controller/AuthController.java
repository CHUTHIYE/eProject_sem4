package com.example.login_logout.controller;

import com.example.login_logout.entity.User;
import com.example.login_logout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Trả về template login.html
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Trả về template register.html
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        String roleName = "ROLE_USER";
        userService.registerNewUser(user, roleName);
        return new ModelAndView("redirect:/login"); // Chuyển hướng đến trang đăng nhập sau khi đăng ký thành công
    }

    // Thêm các phương thức nếu cần thiết cho trang chủ của admin và user
    @GetMapping("/user/home")
    public String userHome(Model model) {
        model.addAttribute("message", "Welcome to User Home!");
        return "user/home"; // Trả về template user/home.html
    }

    @GetMapping("/admin/home")
    public String adminHome(Model model) {
        model.addAttribute("message", "Welcome to Admin Home!");
        return "admin/home"; // Trả về template admin/home.html
    }
}
