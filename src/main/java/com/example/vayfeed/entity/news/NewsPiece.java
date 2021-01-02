package com.example.vayfeed.entity.news;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document()
@Getter @Setter @NoArgsConstructor
public class NewsPiece {

    @Id
    private String id;

    private String title;

    private String description;

    private String link;

    private Date pubDate;
}
