package com.example.vayfeed.service.user;

import com.example.vayfeed.entity.user.Authority;
import com.example.vayfeed.entity.user.User;
import com.example.vayfeed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VayfeedUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public VayfeedUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isEmpty())
            throw new UsernameNotFoundException("User " + username + " not found");
        else{
            User user = optionalUser.get();
            List<Authority> authorities = new ArrayList<>();
            authorities.add(new Authority("ROLE_USER"));
            user.setAuthorities(authorities);
            return user;
        }

    }
}
