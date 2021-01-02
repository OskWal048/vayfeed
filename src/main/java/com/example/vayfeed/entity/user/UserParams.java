package com.example.vayfeed.entity.user;

import com.example.vayfeed.entity.news.RssNewsSource;
import com.example.vayfeed.entity.weather.WeatherApiPlace;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class UserParams {

    private List<WeatherApiPlace> places;

    private List<RssNewsSource> newsSources;

    public void addPlace(WeatherApiPlace place){
        if(places == null)
            places = new ArrayList<>();
        places.add(place);
    }

    public void addNewsSource(RssNewsSource newsSource){
        if(newsSources == null)
            newsSources = new ArrayList<>();
        newsSources.add(newsSource);
    }
}
