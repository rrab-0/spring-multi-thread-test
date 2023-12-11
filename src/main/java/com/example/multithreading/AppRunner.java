package com.example.multithreading;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class AppRunner implements CommandLineRunner {

    private final SongLookupService songLookupService;

    public AppRunner(SongLookupService songLookupService) {
        this.songLookupService = songLookupService;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            try {
                CompletableFuture<Song> song = songLookupService.findSong();
                Song actualSong = song.get();
                System.out.println(actualSong.getArtist_name());
            } catch (InterruptedException | ExecutionException | CancellationException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}