package com.example.vayfeed.controller;

import com.example.vayfeed.entity.user.User;
import com.example.vayfeed.service.news.NewsFeedService;
import com.example.vayfeed.service.user.UserService;
import com.example.vayfeed.service.weather.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/home"})
public class HomePageController {

    private final WeatherInfoService weatherInfoService;
    private final NewsFeedService newsFeedService;
    private final UserService userService;

    public HomePageController(WeatherInfoService weatherInfoService, NewsFeedService newsFeedService, UserService userService) {
        this.weatherInfoService = weatherInfoService;
        this.newsFeedService = newsFeedService;
        this.userService = userService;
    }

    @GetMapping
    public String showHomePage(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())){
            User user = (User)auth.getPrincipal();
            model.addAttribute("newsPieces", user.getNewsFeed());
        }

        return "home";
    }
}
