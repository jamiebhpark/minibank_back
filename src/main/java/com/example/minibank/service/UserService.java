package com.example.minibank.service;

import com.example.minibank.model.User;
import com.example.minibank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }

    // 새로운 사용자 등록 메서드 추가
    public void registerUser(String email, String password) {
        if (userRepository.findByEmail(email) == null) {  // 중복 확인 추가
            User user = new User();
            user.setEmail(email);
            // 비밀번호를 해시하여 저장
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Email already in use");
        }
    }
}
