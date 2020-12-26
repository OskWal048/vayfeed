package com.example.vayfeed.entity.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class WeatherType {

    private int typeId;

    private String name;

    private String description;

    private String iconName;
}
