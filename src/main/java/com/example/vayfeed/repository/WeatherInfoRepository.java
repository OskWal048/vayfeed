package com.example.vayfeed.repository;

import com.example.vayfeed.entity.weather.WeatherInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherInfoRepository extends MongoRepository<WeatherInfo, String> {
}
