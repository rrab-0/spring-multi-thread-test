package com.example.multithreading;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class SongLookupService {

    private final RestTemplate restTemplate;

    public SongLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<Song> findSong() throws InterruptedException {
        String url = "http://localhost:8080/song";
        Song response = restTemplate.getForObject(url, Song.class);
        System.out.println(response.getArtist_name());
        return CompletableFuture.completedFuture(response);
    }
}
