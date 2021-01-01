package com.example.vayfeed.service.news;

import com.example.vayfeed.entity.news.NewsFeed;
import com.example.vayfeed.entity.news.NewsPiece;
import com.example.vayfeed.repository.NewsFeedRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsFeedServiceImpl implements NewsFeedService {

    private final NewsFeedRepository newsFeedRepository;

    @Autowired
    public NewsFeedServiceImpl(NewsFeedRepository newsFeedRepository) {
        this.newsFeedRepository = newsFeedRepository;
    }

    @Override
    public NewsFeed readFromApi() throws IOException, FeedException {

        NewsPiece newsPiece;
        NewsFeed newsFeed = new NewsFeed();
        List<NewsPiece> newsPieceList = new ArrayList<>();

        URL url = new URL("https://www.nasa.gov/rss/dyn/breaking_news.rss");
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(url));

        List<SyndEntry> entries = feed.getEntries();

        for(SyndEntry e : entries){
            newsPiece = new NewsPiece();
            newsPiece.setTitle(e.getTitle());
            newsPiece.setDescription(e.getDescription().getValue());
            newsPiece.setLink(e.getLink());
            newsPiece.setPubDate(e.getPublishedDate());

            newsPieceList.add(newsPiece);
        }
        newsFeed.setNewsPieces(newsPieceList);

        return newsFeed;
    }

    @Override
    public void save(NewsFeed newsFeed) {
        newsFeedRepository.save(newsFeed);
    }

    @Override
    public List<NewsFeed> findAll() {
        return newsFeedRepository.findAll();
    }

}
