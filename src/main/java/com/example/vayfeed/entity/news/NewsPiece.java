package com.example.vayfeed.entity.news;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class NewsPiece {

    private String title;

    private String description;

    private String link;

    private Date pubDate;
}
