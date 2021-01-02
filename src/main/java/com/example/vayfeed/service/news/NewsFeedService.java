package com.example.vayfeed.service.news;

import com.example.vayfeed.entity.news.NewsFeed;
import com.example.vayfeed.entity.news.NewsPiece;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;

import java.io.IOException;
import java.util.List;

public interface NewsFeedService {
    NewsFeed readFromRssFeed() throws IOException, FeedException;
    NewsFeed readFromRssFeed(String rssUrl) throws IOException, FeedException;
    void save(NewsFeed newsFeed);
    List<NewsFeed> findAll();
}
