package com.example.vayfeed.entity.weather.scheduler;

import com.example.vayfeed.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeatherUpdateScheduler {

    private final WeatherInfoService weatherInfoService;

    @Autowired
    public WeatherUpdateScheduler(WeatherInfoService weatherInfoService) {
        this.weatherInfoService = weatherInfoService;
    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void updateWeatherInfo(){
        try {
            weatherInfoService.save(weatherInfoService.readFromApi());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
