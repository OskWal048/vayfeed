package com.example.vayfeed.service.user;

import com.example.vayfeed.entity.user.User;
import com.example.vayfeed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
