package com.example.vayfeed.entity.news;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "newsfeeds")
@Getter @Setter @NoArgsConstructor
public class NewsFeed {

    @Id
    private String id;

    private List<NewsPiece> newsPieces;

    public void addNewsPiece(NewsPiece newsPiece){
        if(newsPieces == null)
            newsPieces = new ArrayList<>();
        newsPieces.add(newsPiece);
    }

    public void addMultipleNewsPieces(List<NewsPiece> newsPieces){
        if(newsPieces == null)
            newsPieces = new ArrayList<>();
        newsPieces.addAll(newsPieces);
    }
}
