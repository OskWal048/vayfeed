package com.example.vayfeed.entity.news;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "newsfeeds")
@Getter @Setter @NoArgsConstructor
public class NewsFeed {

    @Id
    private String id;

    private List<NewsPiece> newsPieces;
}
