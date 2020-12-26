package com.example.vayfeed.entity.weather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weatherinfos")
@Getter @Setter @NoArgsConstructor
public class WeatherInfo {

    @Id
    private String id;

    private double lat;

    private double lon;

    private String timezone;

    private String timezoneOffset;

    private WeatherReading currentWeatherReading;
}
