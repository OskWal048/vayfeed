package com.example.vayfeed.testcontroller;

import com.example.vayfeed.entity.weather.WeatherInfo;
import com.example.vayfeed.service.weather.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class TestWeatherInfoController {

    private final WeatherInfoService weatherInfoService;

    @Autowired
    public TestWeatherInfoController(WeatherInfoService weatherInfoService) {
        this.weatherInfoService = weatherInfoService;
    }

    @GetMapping()
    public WeatherInfo testRead(){
        WeatherInfo weatherInfo = new WeatherInfo();

        try {
            weatherInfo = weatherInfoService.readFromApi();
        } catch (IOException e) {
            e.printStackTrace();
        }

        weatherInfoService.save(weatherInfo);

        return weatherInfo;
    }

    @GetMapping("/all")
    public List<WeatherInfo> findAll(){
        return weatherInfoService.findAll();
    }
}
