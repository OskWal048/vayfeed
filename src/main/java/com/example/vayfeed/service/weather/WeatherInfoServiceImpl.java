package com.example.vayfeed.service.weather;

import com.example.vayfeed.entity.weather.WeatherInfo;
import com.example.vayfeed.repository.WeatherInfoRepository;
import com.example.vayfeed.service.weather.WeatherInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class WeatherInfoServiceImpl implements WeatherInfoService {

    private final WeatherInfoRepository weatherInfoRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public WeatherInfoServiceImpl(WeatherInfoRepository weatherInfoRepository, ObjectMapper objectMapper) {
        this.weatherInfoRepository = weatherInfoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public WeatherInfo readFromApi() throws IOException {

        WeatherInfo weatherInfo;

        URL url = new URL("http://api.openweathermap.org/data/2.5/onecall?lat=50.26&lon=19.03&appid=9edc3270dff940ef79d2a7fffa87b812&exclude=minutely,hourly,daily");

        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();

        if(responseCode != 200)
            throw new RuntimeException("Http Response Code " + responseCode);
        else{
            weatherInfo = objectMapper.readValue(url, WeatherInfo.class);
        }

        return weatherInfo;
    }

    @Override
    public void save(WeatherInfo weatherInfo) {
        weatherInfoRepository.insert(weatherInfo);
    }

    public List<WeatherInfo> findAll(){
        return weatherInfoRepository.findAll();
    }
}
