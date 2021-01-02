package com.example.vayfeed.service.scheduler;

import com.example.vayfeed.entity.news.NewsFeed;
import com.example.vayfeed.entity.news.NewsPiece;
import com.example.vayfeed.entity.news.RssNewsSource;
import com.example.vayfeed.entity.user.User;
import com.example.vayfeed.entity.user.UserParams;
import com.example.vayfeed.entity.weather.WeatherApiPlace;
import com.example.vayfeed.entity.weather.WeatherInfo;
import com.example.vayfeed.repository.UserRepository;
import com.example.vayfeed.service.news.NewsFeedService;
import com.example.vayfeed.service.weather.WeatherInfoService;
import com.rometools.rome.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class InfoUpdateScheduler {

    private final UserRepository userRepository;

    private final WeatherInfoService weatherInfoService;
    private final NewsFeedService newsFeedService;

    public InfoUpdateScheduler(UserRepository userRepository, WeatherInfoService weatherInfoService, NewsFeedService newsFeedService) {
        this.userRepository = userRepository;
        this.weatherInfoService = weatherInfoService;
        this.newsFeedService = newsFeedService;
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void updateInfo() throws IOException, FeedException {
//        List<User> users = userRepository.findAll();
        List<User> users = userRepository.findAll();

        for(User user : users){
            UserParams params = user.getUserParams();
            if(params != null){

                List<WeatherApiPlace> places = params.getPlaces();
                if(places != null){
                    List<WeatherInfo> weatherInfos = new ArrayList<>();
                    for(WeatherApiPlace place : places){
                        weatherInfos.add(weatherInfoService.readFromApi(place.getLat(), place.getLon()));
                    }
                    user.setWeatherInfos(weatherInfos);
                }

                List<RssNewsSource> newsSources = params.getNewsSources();
                if(newsSources != null){
                    List<NewsPiece> newsFeed = new ArrayList<>();
                    for(RssNewsSource newsSource : newsSources){
                        newsFeed.addAll(newsFeedService.readFromRssFeed(newsSource.getRssUrl()).getNewsPieces());
                    }
                    user.setNewsFeed(newsFeed);
                }

            }
            userRepository.save(user);
        }
    }
}
