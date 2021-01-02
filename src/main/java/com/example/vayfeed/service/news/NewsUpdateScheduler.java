package com.example.vayfeed.service.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class NewsUpdateScheduler {

    private final NewsFeedService newsFeedService;

    @Autowired
    public NewsUpdateScheduler(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void updateNews(){
        try {
            newsFeedService.save(newsFeedService.readFromRssFeed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
