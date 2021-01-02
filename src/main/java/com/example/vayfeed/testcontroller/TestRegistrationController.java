package com.example.vayfeed.testcontroller;

import com.example.vayfeed.entity.news.RssNewsSource;
import com.example.vayfeed.entity.user.User;
import com.example.vayfeed.entity.user.UserParams;
import com.example.vayfeed.entity.weather.WeatherApiPlace;
import com.example.vayfeed.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestRegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TestRegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public void register(){

        User user3 = new User();
        user3.setUsername("oskar");
        user3.setPassword(passwordEncoder.encode("test"));
        user3.setEnabled(true);

        UserParams userParams = new UserParams();
        userParams.addPlace(new WeatherApiPlace("Katowice", 50.26, 19.03));
        userParams.addNewsSource(new RssNewsSource("https://www.nasa.gov/rss/dyn/breaking_news.rss", false));
        user3.setUserParams(userParams);

        userService.save(user3);
    }

}
