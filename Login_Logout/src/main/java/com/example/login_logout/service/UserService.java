package com.example.login_logout.service;

import com.example.login_logout.entity.Role;
import com.example.login_logout.entity.User;
import com.example.login_logout.repository.RoleRepository;
import com.example.login_logout.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user, String roleName) {
        // Mã hóa mật khẩu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Tìm role từ cơ sở dữ liệu
        Role userRole = roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Gán role cho người dùng
        user.setRoles(Collections.singleton(userRole));

        // Lưu người dùng vào cơ sở dữ liệu
        return userRepository.save(user);
    }

    public boolean isUsernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}

