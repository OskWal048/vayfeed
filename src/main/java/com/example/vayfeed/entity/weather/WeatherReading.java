package com.example.vayfeed.entity.weather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class WeatherReading {

    private int readingUnixTime;

    private int sunriseUnixTime;

    private int sunsetUnixTime;

    private double tempKelvin;
    
    private double perceivedTempKelvin;

    private int pressure;

    private int humidity;

    private int cloudiness;

    private double uvi;

    private double windSpeed;

    private List<WeatherType> weatherTypes;
}
