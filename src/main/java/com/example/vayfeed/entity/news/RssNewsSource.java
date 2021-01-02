package com.example.vayfeed.entity.news;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RssNewsSource {

    private String rssUrl;

    private boolean favorite;
}
