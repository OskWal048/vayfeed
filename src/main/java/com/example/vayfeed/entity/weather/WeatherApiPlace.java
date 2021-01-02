package com.example.vayfeed.entity.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class WeatherApiPlace {

    private String city;

    private double lat;

    private double lon;
}
