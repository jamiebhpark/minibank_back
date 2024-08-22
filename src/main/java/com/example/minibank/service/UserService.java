package com.example.minibank.service;

import com.example.minibank.model.User;
import com.example.minibank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // 여기서 JWT 토큰 생성 및 반환 (생략)
            return user;
        }
        return null;
    }
}
