package com.example.vayfeed.repository;

import com.example.vayfeed.entity.news.NewsFeed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsFeedRepository extends MongoRepository<NewsFeed, String> {
}
