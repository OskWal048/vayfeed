package com.example.vayfeed.service.weather;

import com.example.vayfeed.entity.weather.WeatherInfo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.List;

public interface WeatherInfoService {
    WeatherInfo readFromApi() throws IOException;
    WeatherInfo readFromApi(double lat, double lon) throws IOException;
    void save(WeatherInfo weatherInfo);
    List<WeatherInfo> findAll();
}
